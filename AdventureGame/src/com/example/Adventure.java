package com.example;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Scanner;

public class Adventure {
    private static final String standardURL = "https://courses.engr." +
            "illinois.edu/cs126/adventure/siebel.json";
    public static Room current = null;
    private static Gson gson;
    private static Room[] rooms;
    private static boolean quit = false;

    /**
     * This method takes in a customer url and sets up game background.
     *
     * @param url String
     * @throws UnirestException
     */
    public static void getSetUp(String url) throws UnirestException {
        gson = new Gson();
        Layout gameInfo;
        final HttpResponse<String> stringHttpResponse = Unirest.get(url).asString();
        final HttpResponse<String> stringHttpResponseStandard = Unirest.get(standardURL).asString();
        try {
            if (stringHttpResponse.getStatus() == 200) {
                String json = stringHttpResponse.getBody();
                gameInfo = gson.fromJson(json, Layout.class);
                rooms = gameInfo.getRooms();
                current = getRoomByName(gameInfo.getStartingRoom());
            }
        } catch (Exception e) {
            System.out.println("The provided URL is invalid. Applying the standard now...");
            if (stringHttpResponseStandard.getStatus() == 200) {
                String json = stringHttpResponse.getBody();
                gameInfo = gson.fromJson(json, Layout.class);
                rooms = gameInfo.getRooms();
                current = getRoomByName(gameInfo.getStartingRoom());
            } else {
                gameInfo = null;
            }
        }
    }

    /**
     * THis method gets room by room's name. Case insensitive.
     *
     * @param currRoom
     * @return
     */
    public static Room getRoomByName(String currRoom) {
        for (Room room : rooms) {
            if (room.getName().equals(currRoom)) {
                return room;
            }
        }
        return null;
    }

    /**
     * Returns name of the room to go, or null if can't go
     *
     * @param direction String direction to go
     * @return String the room to go's name
     */
    public static String getRoomNameByDirection(String direction) {
        Direction[] directions = current.getDirections();
        for (Direction dir : directions) {
            if (dir.getDirectionName().toLowerCase().equals(direction)) {
                return dir.getRoom();
            }
        }
        return null;
    }

    public static void main(String[] args) throws UnirestException {

        String customerURL = "";
        for (String arg : args) {
            customerURL += arg;
        }

        //Set up the original state
        if (!customerURL.equals("")) {
            try {
                getSetUp(customerURL);
            } catch (Exception e) {
                System.out.println("The provided URL is bad. Now applying the standard one...");
                getSetUp(standardURL);
            }
        } else {
            getSetUp(standardURL);
        }

        System.out.println(current.getDescription() + current.getDirectionString());

        Scanner scanner = new Scanner(System.in);

        while (!quit) {
            String commands = scanner.nextLine();
            String[] input = commands.toLowerCase().split(" ");  //Lower case all input
            if (input.length > 0) {
                //Check whether to quit game
                if (input[0].equals("quit") || input[0].equals("exit")) {
                    quit = true;
                } else if (input.length == 2 && input[0].equals("go")) {  //Check for 'go' commands
                    String nextRoom = getRoomNameByDirection(input[1]);
                    if (nextRoom == null) {
                        System.out.println("I can’t " + commands);
                    } else {
                        current = getRoomByName(nextRoom);
                        System.out.println(current.getDescription() + current.getDirectionString());
                    }
                } else {
                    System.out.println("I don't understand '" + commands + "'");
                }
            }
        }
    }

    /**
     * This method returns true if for every pair of rooms A and B that,
     * if you can get from A to B, then you can get from B to A.
     *
     * @return boolean
     */
    public boolean floorValidator() {
        boolean symmetry = true;
        while (symmetry) {
            for (int i = 0; i < rooms.length; i++) {
                for (int j = i + 1; j < rooms.length; j++) {
                    if (!(rooms[i].canGoTo(rooms[j]) && rooms[j].canGoTo(rooms[i]))) {
                        symmetry = false;
                    }
                }
            }
        }
        return symmetry;
    }
}
