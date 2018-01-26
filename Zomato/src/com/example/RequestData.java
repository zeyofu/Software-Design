package com.example;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by Fia Fu, 9/19/2017
 * This class is used to get the required restaurants from Zomato.
 */

public class RequestData {
    private Gson gson;

    /**
     * This method
     * @param city String the city to request ID
     * @return int the id of the city
     * @throws UnirestException
     */
    public int getCityID(String city) throws UnirestException {
        CitySearch citySearch;
        gson = new Gson();
        String url = "https://developers.zomato.com/api/v2.1/citySearch?q=" + city;
        final HttpResponse<String> stringHttpResponse = Unirest.get(url).
                header("user-key", Api.API_KEY).asString();
        if (stringHttpResponse.getStatus() == 200) {
            String json = stringHttpResponse.getBody();
            citySearch = gson.fromJson(json, CitySearch.class);
        } else {
            citySearch = null;
        }
        return citySearch.getLocation_suggestions()[0].getId();
    }
    /**
     * This Method returns a string containing the restaurants (including location and cuisine) that
     * fits the requirement.
     *
     * @param city int the code for the city
     * @param cuisine int the code for the cuisine
     * @return String containing restaurants and their locations and cuisines
     * @throws UnirestException
     */
    public String getRestaurantsByCityAndCuisine(int city, int cuisine) throws UnirestException {
        RestaurantCollection restaurantsInfo = getRestaurantsByCityAndCuisineHelper(city, cuisine);
        return getRestaurantList(restaurantsInfo);
    }

    //https://developers.zomato.com/api/v2.1/cities?q=Champaign

    /**
     * This is a helper method that takes a RestaurantCollection and returns brief list of restaurants.
     * @param restaurants RestaurantCollection the whole detailed list of restaurants
     * @return String a brief list of restaurants
     */
    private String getRestaurantList(RestaurantCollection restaurants){
        String list = "";
        Restaurants[] restaurantList = restaurants.getRestaurants();
        for (int i = 0; i < restaurantList.length; i++) {
            Restaurant restaurant = restaurantList[i].getRestaurant();
            list += restaurant.getName() + "\n  " + restaurant.getLocation().getAddress() +
                    "\n  " + restaurant.getCuisines() + "\n\n";
        }
        return list;
    }

    /**
     * This Method returns a string containing the restaurants (including location and cuisine) that
     * fits the requirement.
     * @param city int the location of the restaurnats
     * @param cuisines int[] the IDs of desired cuisine
     * @return String containing restaurants and their locations and cuisines
     * @throws UnirestException
     */
    public  String getRestaurantsWithMultipleCuisines(int city, int[] cuisines) throws UnirestException {
        String restaurants = "";
        for (int cuisine: cuisines){
            restaurants += getRestaurantsByCityAndCuisine(city,cuisine);
        }
        return restaurants;
    }

    /**
     * This method is a helper method that returns a RestaurantCollection containing
     * restaurants in a certain city providing a certain cuisine.
     * @param city int the code for the city
     * @param cuisine int the code for the cuisine
     * @return String containing restaurants and their locations and cuisines
     */
    private RestaurantCollection getRestaurantsByCityAndCuisineHelper(int city, int cuisine)
            throws UnirestException {
        String url = "https://developers.zomato.com/api/v2.1/search?entity_id=" + Integer.toString(city) +
                "&entity_type=city&cuisines=" + Integer.toString(cuisine);

        return getRestaurantsByURL(url);
    }

    /**
     * This method returns all restaurants found by the given city and cuisine.
     * @param city int the city ID of the restaurant
     * @param cuisine int the cuisine ID
     * @return String the full brief list of restaurants
     * @throws UnirestException
     */
    public String getAllRestaurantsByCityAndCuisine(int city, int cuisine) throws UnirestException {
        String list = "";
        RestaurantCollection restaurants = getRestaurantsByCityAndCuisineHelper(city,cuisine);
        list += getRestaurantList(restaurants);
        int maximum = restaurants.getResults_found();
        int shown = restaurants.getResults_shown();
        for (int i = 1; i < maximum / shown; i++) {
            String url = "https://developers.zomato.com/api/v2.1/search?entity_id=" + Integer.toString(city) +
                    "&entity_type=city&start=" + Integer.toString(i * shown) + "&cuisines=" + Integer.toString(cuisine);
            list += getRestaurantList(getRestaurantsByURL(url));
        }
        return list;
    }

    /**
     * This Method returns a string containing all the restaurants (including location and cuisine) that
     * fits the requirement.
     * @param city int the location of the restaurnats
     * @param cuisines int[] the IDs of desired cuisine
     * @return String containing restaurants and their locations and cuisines
     * @throws UnirestException
     */
    public  String getAllRestaurantsWithMultipleCuisines(int city, int[] cuisines) throws UnirestException {
        String restaurants = "";
        for (int cuisine: cuisines){
            restaurants += getAllRestaurantsByCityAndCuisine(city,cuisine);
        }
        return restaurants;
    }

    /**
     * This method is a helper method that imports data from a given url and parses it using gson.
     * @param url String the source of data
     * @return RestaurantCollection the restaurants from the url
     * @throws UnirestException
     */
    private RestaurantCollection getRestaurantsByURL(String url) throws UnirestException {
        RestaurantCollection restaurantsFullInfo;
        gson = new Gson();
        final HttpResponse<String> stringHttpResponse = Unirest.get(url).
                header("user-key", Api.API_KEY).asString();
        if (stringHttpResponse.getStatus() == 200) {
            String json = stringHttpResponse.getBody();
            restaurantsFullInfo = gson.fromJson(json, RestaurantCollection.class);
        } else {
            restaurantsFullInfo = null;
        }
        return restaurantsFullInfo;
    }
}