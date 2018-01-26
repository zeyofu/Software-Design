package com.example;

/**
 * Created by Fia Fu, 9/25/2017
 *
 * {"startingRoom": "MatthewsStreet",
 * "rooms": [{
 * "name": "MatthewsStreet",
 * "description": "You are on Matthews, outside the Siebel Center",\
 * "items": ["coin"],
 * "directions": [{
 * "directionName": "East",
 * "room": "SiebelEntry"}]}]}
 *
 */
public class Layout {
    private String startingRoom;
    private Room[] rooms;

    public String getStartingRoom() {
        return startingRoom;
    }

    public Room[] getRooms() {
        return rooms;
    }
}
