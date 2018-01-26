package edu.illinois.zomatoapp;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import edu.illinois.zomatoapp.RestaurantData.RestaurantCollection;
import edu.illinois.zomatoapp.RestaurantData.Restaurants;

import static org.junit.Assert.*;

/**
 * Created by fia on 10/30/17.
 */
public class RequestDataTest {

    public static final String urlString = "https://developers.zomato.com/api/v2.1/search?" +
            "entity_id=685&entity_type=city&cuisines=25";

    @Before
    public void setUp() throws Exception {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("user-key", "e365840918d9530e75ec3bfe580e8000");
        connection.connect();
        InputStream inStream = connection.getInputStream();
        InputStreamReader inStreamReader = new InputStreamReader(inStream, Charset.forName("UTF-8"));
        Gson gson = new Gson();
        RestaurantCollection restaurantCollection = gson.fromJson(inStreamReader, RestaurantCollection.class);
        System.out.println(restaurantCollection.getResults_found());
        System.out.println(restaurantCollection.getRestaurants()[0].getRestaurant().getR().getRes_id());

    }

    @Test
    public void getCityID() throws Exception {
    }

    @Test
    public void getRestaurantsByCityAndCuisine() throws Exception {
    }

    @Test
    public void getRestaurantsWithMultipleCuisines() throws Exception {
    }

    @Test
    public void getAllRestaurantsByCityAndCuisine() throws Exception {
    }

    @Test
    public void getAllRestaurantsWithMultipleCuisines() throws Exception {
    }

}