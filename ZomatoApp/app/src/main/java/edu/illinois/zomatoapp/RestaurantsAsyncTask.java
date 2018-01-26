package edu.illinois.zomatoapp;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.illinois.zomatoapp.RestaurantData.Restaurant;
import edu.illinois.zomatoapp.RestaurantData.RestaurantCollection;
import edu.illinois.zomatoapp.RestaurantData.Restaurants;

/**
 * This class holds an AsyncTask object
 * Created by fia on 10/31/17.
 */

public class RestaurantsAsyncTask extends AsyncTask<String, Integer, List<Restaurants>> {

    public static final String TAG = RestaurantsAsyncTask.class.getSimpleName();

    public static final String URL_STRING_GENERAL = "https://developers.zomato.com/api/v2.1/search?" +
            "entity_id=";

    private RestaurantAdapter restaurantAdapter;
    private RecyclerView recyclerView;
    private Context context;

    public RestaurantsAsyncTask(Context context, RecyclerView recyclerView, RestaurantAdapter
            restaurantAdapter) {
        this.context = context;
        this.restaurantAdapter = restaurantAdapter;
        this.recyclerView = recyclerView;
    }

    /**
     * This method loops to get a relative complete Restaurants list.
     *
     * @param params
     * @return
     */
    @Override
    protected List<Restaurants> doInBackground(String... params) {
        List<Restaurants> restaurantList = new ArrayList<>();

        for (int i = 0; i < params.length; i++) {

            RestaurantCollection restaurantCollection = getRestaurantCollection(
                    URL_STRING_GENERAL + params[i]);
            restaurantList.addAll(Arrays.asList(restaurantCollection.getRestaurants()));

            //In the end, ensure at least 100 restaurants are shown, but also not too many are shown
            if (i == params.length - 1 && restaurantList.size() < 100) {
                int maximum = restaurantCollection.getResults_found();
                int shown = restaurantCollection.getResults_shown();
                for (int j = 1; j < maximum / shown && j < 6; j++) {
                    String url = URL_STRING_GENERAL + params[i] +
                            "&start=" + Integer.toString(j * shown);
                    restaurantList.addAll(Arrays.asList(getRestaurantCollection(url).getRestaurants()));
                }
            }

            Log.d(TAG, "Restaurants fetched: " + Integer.toString(restaurantList.size()));
        }
        return restaurantList;
    }

    /**
     * This method parses json to restaurant objects by given url String
     * @param urlString
     * @return
     */
    protected RestaurantCollection getRestaurantCollection(String urlString) {
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty(RestaurantAPI.API_KEY, RestaurantAPI.API_KEY_VALUE);
            connection.connect();
            InputStream inStream = connection.getInputStream();
            InputStreamReader inStreamReader = new InputStreamReader(inStream,
                    Charset.forName("UTF-8"));
            Gson gson = new Gson();
            RestaurantCollection restaurantCollection = gson.fromJson(inStreamReader,
                    RestaurantCollection.class);
            return restaurantCollection;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method takes in the parsed restaurants and changs the user view by setting
     * the passed in adapter and corresponding arrayList
     *
     * @param restaurantsList
     */
    @Override
    protected void onPostExecute(List<Restaurants> restaurantsList) {
        if (restaurantsList == null) {
            Log.d(TAG, "No Restaurants Found.");
            return;
        }
        Log.d(TAG, "Restaurants fetched: " + Integer.toString(restaurantsList.size()));

        for (Restaurants restaurant: restaurantsList) {
            restaurantAdapter.addRestaurant(restaurant);
        }
        restaurantAdapter.notifyDataSetChanged();
    }
}
