package edu.illinois.finalproject.Data;

/**
 * Created by fia on 12/5/17.
 */

public class SimpleChatRoom {

    private String roomKey;
    private String roomName;

    public SimpleChatRoom() {

    }

    public SimpleChatRoom(String roomKey, String roomName) {
        this.roomKey = roomKey;
        this.roomName = roomName;
    }

    public String getRoomKey() {
        return roomKey;
    }

    public void setRoomKey(String roomKey) {
        this.roomKey = roomKey;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
