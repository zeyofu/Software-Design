package edu.illinois.zomatoapp.RestaurantData;

/**
 * Created by Fia Fu, 9/18/2017
 *
 * This class holds a collection of restaurants found.
 *"results_found": 39,
 * "results_start": 0,
 * "results_shown": 20,
 * "restaurants": [
 *
 */
public class RestaurantCollection {
    private int results_found;
    private int results_start;
    private int results_shown;
    private Restaurants[] restaurants;

    public int getResults_found() {
        return results_found;
    }

    public int getResults_start() {
        return results_start;
    }

    public int getResults_shown() {
        return results_shown;
    }

    public Restaurants[] getRestaurants() {
        return restaurants;
    }
}
