package edu.illinois.finalproject;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import edu.illinois.finalproject.Adapters.FirebaseChatMessageViewHolder;
import edu.illinois.finalproject.Data.ChatMessage;
import edu.illinois.finalproject.Data.SimpleChatRoom;

import static edu.illinois.finalproject.MainActivity.emailToKey;

/**
 * This class shows a basic functions of a chat app including sending messages
 * <p>
 * Cited by "https://code.tutsplus.com/tutorials/how-to-create-an-android-chat-app-
 * using-firebase--cms-27397"
 */
public class ChatRoomActivity extends AppCompatActivity {

    private static final String TAG = "Debug";
    ;
    private final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private RecyclerView recyclerView;
    private FirebaseRecyclerAdapter adapter;
    private DatabaseReference chatRef;
    private DatabaseReference roomRef;
    private String roomKey;
    private String roomName;
    private LocationListener locationListener;
    private LocationManager locationManager;
    private EditText input;
    private Boolean flag = false;
    public static final String LOCATION_MESSAGE = "Click to get location. ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        // Get the Intent that started this activity and extract the strings
        Bundle extras = getIntent().getExtras();
        roomKey = extras.getString(MainActivity.ROOM_KEY);
        roomName = extras.getString(MainActivity.ROOM_NAME);
        chatRef = FirebaseDatabase.getInstance().getReference("chats").child(roomKey);
        roomRef = FirebaseDatabase.getInstance().getReference("rooms").child(roomKey);
        setTitle(roomName);

        recyclerView = findViewById(R.id.list_of_messages);
        final FloatingActionButton sendMessageButton = findViewById(R.id.sendMessageButton);
        input = findViewById(R.id.input);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (user == null) {
            //return to the main activity to sign in page
            finish();
        } else {
            // Load chat room contents
            displayChatMessages();
            adapter.startListening();
            Toast.makeText(this, "Welcome " + user.getDisplayName() + ", You have entered chat room "
                    + roomName, Toast.LENGTH_LONG).show();
        }

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Read the input field and push a new instance of ChatMessage to the Firebase
                chatRef.push().setValue(new ChatMessage(input.getText().toString(), user.getDisplayName()));
                input.setText("");

                //After each click, the screen scrolls down to display the latest message sent
                //100 is just an intended position here
                recyclerView.smoothScrollToPosition(100);
            }
        });

    }

    /**
     * This method grabs messages from Firebase and shows top 50 to them in the list text.
     * <p>
     * Cited by "https://github.com/firebase/FirebaseUI-Android/blob/master/database/README.md"
     * Cited by "https://www.learnhowtoprogram.com/android/data-persistence/firebase-recycleradapter"
     */
    private void displayChatMessages() {
        recyclerView.setHasFixedSize(true);

        Query query = chatRef;
        FirebaseRecyclerOptions<ChatMessage> options = new FirebaseRecyclerOptions.Builder<ChatMessage>()
                .setQuery(query, ChatMessage.class).build();

        adapter = new FirebaseRecyclerAdapter<ChatMessage, FirebaseChatMessageViewHolder>(options) {
            @Override
            public FirebaseChatMessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                // Create a new instance of the ViewHolder, in this case we are using a custom
                // layout called R.layout.message for each item
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.message, parent, false);

                return new FirebaseChatMessageViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(FirebaseChatMessageViewHolder holder, int position, ChatMessage model) {
                // Bind the Chat object to the FirebaseChatViewHolder
                holder.bindChatMessage(model);
            }
        };

        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        //Add line decoration
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        //Set the message to be back order
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat_room_menu, menu);
        return true;
    }

    /**
     * This method provides user the option to add more user to the room and send current location
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_send_location) {
            getLocation();
        }

        if (item.getItemId() == R.id.add_user) {
            addUser();
        }
        return true;
    }

    /**
     * This method pops up a dialog to enter user email adds that user to the group.
     * <p>
     * Cited by "https://stackoverflow.com/questions/10903754/input-text-dialog-android"
     */
    private void addUser() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add user");
        View viewInflated = LayoutInflater.from(this).inflate(R.layout.dialog_add_user,
                (ViewGroup) findViewById(android.R.id.content), false);

        // Set up the input
        final EditText input = viewInflated.findViewById(R.id.userEmailInput);
        builder.setView(viewInflated);

        // Set up the buttons
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                String email = input.getText().toString();
                roomRef.child("userList").push().setValue(emailToKey(email));
                FirebaseDatabase.getInstance().getReference("users").child(emailToKey(email))
                        .child("roomList").push().setValue(new SimpleChatRoom(roomKey, roomName));

            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    /**
     * Check if GPS is enabled
     */
    private Boolean displayGpsStatus() {
        return Settings.Secure.isLocationProviderEnabled(getBaseContext().getContentResolver(),
                LocationManager.GPS_PROVIDER);
    }

    /**
     * This method gets location of the user
     * <p>
     * Cited by "https://developer.android.com/guide/topics/location/strategies.html"
     */
    public void getLocation() {

        flag = displayGpsStatus();
        if (flag) {
            Log.v(TAG, "onClick");

            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {

                Log.d(TAG, "No Permission");
                ActivityCompat.requestPermissions(ChatRoomActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                return;
            } else {
                // Define a listener that responds to location updates
                locationListener = new MyLocationListener();
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10,
                        locationListener);
            }
        } else {
            showGpsAlert();
        }

    }

    /**
     * Method to create an AlertBox to turn on GPS.
     * Cited by "http://rdcworld-android.blogspot.in/2012/01/get-current-location-coordinates-city.html"
     */
    protected void showGpsAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your Device's GPS is Disable").setCancelable(false).setTitle("Gps Status")
                .setPositiveButton("Turn it on", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // finish the current activity
                        // AlertBoxAdvance.this.finish();
                        Intent myIntent = new Intent(Settings.ACTION_SECURITY_SETTINGS);
                        startActivity(myIntent);
                        dialog.cancel();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // cancel the dialog box
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }


    /**
     * Listener class to get coordinates
     * Cited by "http://rdcworld-android.blogspot.in/2012/01/get-current-location-coordinates-city.html"
     */
    private class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location loc) {

            Toast.makeText(getBaseContext(), "Location changed : Lat: " + loc.getLatitude() + " Lng: "
                    + loc.getLongitude(), Toast.LENGTH_LONG).show();
            String longitude = Double.toString(loc.getLongitude());
            Log.v(TAG, longitude);
            String latitude = Double.toString(loc.getLatitude());
            Log.v(TAG, latitude);

            //Get City-Name from coordinates
            String address = null;
            Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
            List<Address> addresses;
            try {
                addresses = gcd.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
                if (addresses.size() > 0) {
                    address = addresses.get(0).getAddressLine(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            String s = LOCATION_MESSAGE + "\n\n" + address;
            chatRef.push().setValue(new ChatMessage(s, user.getDisplayName()));
            recyclerView.smoothScrollToPosition(100);
            //To avoid successive location sending
            locationManager.removeUpdates(this);
        }

        @Override
        public void onProviderDisabled(String provider) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    }
}
