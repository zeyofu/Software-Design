package edu.illinois.finalproject.Data;

import java.util.ArrayList;

/**
 * This class contains information of a user.
 * <p>
 * Created by fia on 11/28/17.
 */

public class UserAccount {

    private String email;
    private ArrayList<String> roomList; //contains unique keys of chat rooms

    public UserAccount() {

    }

    public UserAccount(String email, ArrayList<String> roomList) {
        this.email = email;
        this.roomList = roomList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getRoomList() {
        return roomList;
    }

    public void setRoomList(ArrayList<String> roomList) {
        this.roomList = roomList;
    }

    public void enterChatRoom(String roomKey) {
        roomList.add(roomKey);
    }

    public void exitChatRoom(String roomKey) {
        roomList.remove(roomKey);
    }
}