package com.example;

/**
 * name : String
 * description : String
 * directions : Direction []
 * items : String [] // names of items
 */
public class Room {
    private String name;
    private String description;
    private Direction[] directions;
    private String[] items;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Direction[] getDirections() {
        return directions;
    }

    public String[] getItems() {
        return items;
    }

    /**
     * This method returns directions can go from the room
     *
     * @return String directions
     */
    public String getDirectionString() {
        StringBuilder output = new StringBuilder("From here, you can go: ");
        for (int i = 0; i < directions.length - 1; i++) {
            output.append(directions[i].getDirectionName()).append(", ");
        }
        if (directions.length > 1) {
            output.append("or ");
        }
        if (directions.length > 0) {
            output.append(directions[directions.length - 1].getDirectionName());
        }
        return output.toString();
    }

    /**
     * This method returns true if you can get to the other room.
     * @param other Room
     * @return boolean
     */
    public boolean canGoTo(Room other) {
        boolean canGo = false;
        for (Direction direction : directions) {
            if (direction.getRoom().equals(other.getName())) {
                canGo = true;
            }
        }
        return canGo;
    }
}