package edu.illinois.finalproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.Arrays;
import java.util.List;

import edu.illinois.finalproject.Adapters.FirebaseSimpleChatRoomViewHolder;
import edu.illinois.finalproject.Data.SimpleChatRoom;

/**
 * This class shows a basic functions of a chat app including signing in and out
 * <p>
 * Cited by "https://code.tutsplus.com/tutorials/how-to-create-an-android-chat-app-
 * using-firebase--cms-27397"
 */
public class MainActivity extends AppCompatActivity {

    private static final int SIGN_IN_REQUEST_CODE = 1;
    private final List<AuthUI.IdpConfig> providers = Arrays.asList(
            new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
            new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build());
    private FirebaseUser user;
    private RecyclerView recyclerView;
    private FirebaseRecyclerAdapter adapter;
    private DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users");
    private DatabaseReference roomRef = FirebaseDatabase.getInstance().getReference("rooms");
    public static final String ROOM_KEY = "room key";
    public static final String ROOM_NAME = "room name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set title color
//        ActionBar bar = getActionBar();
//        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("0xff00ffff")));

        recyclerView = findViewById(R.id.list_of_rooms);
        final Button createRoomButton = findViewById(R.id.createRoomButton);
        final EditText roomNameInput = findViewById(R.id.roomNameInput);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {

            // Pop up the sign in/up activity
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders
                    (providers).build(), SIGN_IN_REQUEST_CODE);

        } else {

            // User is already signed in. Display a welcome Toast with username
            Toast.makeText(this, "Welcome back " + user.getDisplayName(), Toast.LENGTH_LONG).show();

            // Load chat room list
            displayChatRooms();
            adapter.startListening();
        }

        createRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //If the input is empty, show a toast and do nothing
                if (roomNameInput.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter new chat room's name",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                // Read the input field and push a new instance of ChatRoom including the user to the Firebase.
                // Push the room's key to the user on Firebase.
                String roomKey = roomRef.push().getKey();
                String roomName = roomNameInput.getText().toString();
                roomRef.child(roomKey).child("name").setValue(roomName);
                roomRef.child(roomKey).child("userList").push().setValue(emailToKey(user.getEmail()));
                userRef.child(emailToKey(user.getEmail())).child("roomList").push().setValue
                        (new SimpleChatRoom(roomKey, roomName));

                roomNameInput.setText("");

                //starts a new activity, go inside the char room
                Bundle extras = new Bundle();
                extras.putString(ROOM_KEY, roomKey);
                extras.putString(ROOM_NAME, roomName);
                startActivity(new Intent(MainActivity.this, ChatRoomActivity.class)
                        .putExtras(extras));
            }
        });
    }

    private void displayChatRooms() {
        recyclerView.setHasFixedSize(true);

        //query to get all rooms
        Query query = userRef.child(emailToKey(user.getEmail())).child("roomList");
        FirebaseRecyclerOptions<SimpleChatRoom> options = new FirebaseRecyclerOptions.Builder<SimpleChatRoom>()
                .setQuery(query, SimpleChatRoom.class).build();

        adapter = new FirebaseRecyclerAdapter<SimpleChatRoom, FirebaseSimpleChatRoomViewHolder>(options) {
            @Override
            public FirebaseSimpleChatRoomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                // Create a new instance of the ViewHolder, in this case we are using a custom
                // layout called R.layout.chat_room for each item
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.chat_room, parent, false);

                return new FirebaseSimpleChatRoomViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(FirebaseSimpleChatRoomViewHolder holder, int position, SimpleChatRoom model) {
                // Bind the Chat object to the FirebaseChatViewHolder
                holder.bindChatRoom(model);
            }
        };

        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        //Add line decoration
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    /**
     * This method determines if the user is signed in
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SIGN_IN_REQUEST_CODE) {

            if (resultCode == RESULT_OK) {

                //The user has signed in. Show a toast display all chat rooms.
                Toast.makeText(this, "Successfully signed in. Welcome" + FirebaseAuth.getInstance()
                        .getCurrentUser().getDisplayName(), Toast.LENGTH_LONG).show();

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                userRef.child(emailToKey(user.getEmail()));
                displayChatRooms();
                adapter.startListening();

            } else {
                Toast.makeText(this, "We couldn't sign you in. Please try again later.",
                        Toast.LENGTH_LONG).show();

                // Go back to the sign-in page
                startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders
                        (providers).build(), SIGN_IN_REQUEST_CODE);
            }
        }
    }

    /**
     * Firebase keys cannot have a period (.) in them, so this converts the emails to valid keys
     * <p>
     * Cited by "https://gist.github.com/katowulf/6479129"
     */
    final public static String emailToKey(String email) {
        return email.replace('.', ',');
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * This method provides user the option to sign out
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_sign_out) {
            AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(MainActivity.this, "You have been signed out.",
                            Toast.LENGTH_LONG).show();
                    adapter.stopListening();

                    // Go back to the sign-in page
                    startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders
                            (providers).build(), SIGN_IN_REQUEST_CODE);
                }
            });
        }

        if (item.getItemId() == R.id.menu_delete_record) {
            //Destroys all user record
            userRef.child(emailToKey(user.getEmail())).setValue(null);
        }

        if (item.getItemId() == R.id.menu_delete_account) {
            //Deletes the account without deleting records
            AuthUI.getInstance().delete(this).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(MainActivity.this, "You have deleted your account.",
                            Toast.LENGTH_LONG).show();
                    adapter.stopListening();

                    // Go back to the sign-in page
                    startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
                            .setAvailableProviders(providers).build(), SIGN_IN_REQUEST_CODE);
                }
            });
        }

        return true;
    }

}
