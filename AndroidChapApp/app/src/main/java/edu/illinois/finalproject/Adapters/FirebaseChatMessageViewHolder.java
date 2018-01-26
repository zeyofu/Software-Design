package edu.illinois.finalproject.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Scanner;

import edu.illinois.finalproject.Data.ChatMessage;
import edu.illinois.finalproject.R;

import static android.content.ContentValues.TAG;
import static edu.illinois.finalproject.ChatRoomActivity.LOCATION_MESSAGE;

/**
 * This class is created to set chat message view list.
 * Created by fia on 11/20/17.
 */

public class FirebaseChatMessageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View mView;
    Context mContext;
    private String message;

    public FirebaseChatMessageViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindChatMessage(ChatMessage chatMessage) {
        TextView messageText = mView.findViewById(R.id.message_text);
        TextView messageUser = mView.findViewById(R.id.message_user);
        TextView messageTime = mView.findViewById(R.id.message_time);

        // Set their text
        message = chatMessage.getMessageText();
        messageText.setText(message);
        messageUser.setText(chatMessage.getMessageUser());

        // Format the date before showing it
        messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)", chatMessage.getMessageTime()));
    }

    /**
     * THis method opens an map indent once it detects that the message is a location sharing.
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (message.length() > 23 && message.substring(0, 23).equals(LOCATION_MESSAGE)) {
            Log.d(TAG, "Getting location...");
            String[] location = new String[3];
            Scanner scanner = new Scanner(message);
            int i = 0;
            while (scanner.hasNextLine()) {
                location[i] = scanner.nextLine();
                i++;
            }
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("http://maps.google.com/maps?daddr=" + location[2]));
            mContext.startActivity(intent);
        } else {
            return;
        }
    }
}