package edu.illinois.finalproject.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import edu.illinois.finalproject.ChatRoomActivity;
import edu.illinois.finalproject.Data.SimpleChatRoom;
import edu.illinois.finalproject.R;

import static edu.illinois.finalproject.MainActivity.ROOM_KEY;
import static edu.illinois.finalproject.MainActivity.ROOM_NAME;

/**
 * This class is created to set chat room view list.
 * Cited by "https://www.learnhowtoprogram.com/android/data-persistence/firebase-recycleradapter"
 *
 * Created by fia on 12/4/17.
 */

public class FirebaseSimpleChatRoomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View mView;
    Context mContext;
    private String roomKey;
    private String roomName;

    public FirebaseSimpleChatRoomViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindChatRoom(SimpleChatRoom simpleChatRoom) {
        roomName = simpleChatRoom.getRoomName();
        roomKey = simpleChatRoom.getRoomKey();

        // Set the text view
        TextView roomNameText = mView.findViewById(R.id.room_name);
        roomNameText.setText(roomName);
    }


    @Override
    public void onClick(View v) {
        Bundle extras = new Bundle();
        extras.putString(ROOM_KEY, roomKey);
        extras.putString(ROOM_NAME, roomName);
        mContext.startActivity(new Intent(mContext, ChatRoomActivity.class).putExtras(extras));
    }
}