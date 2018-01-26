package edu.illinois.zomatoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.zomatoapp.RestaurantData.Restaurants;

public class MainActivity extends AppCompatActivity {

    //Links to Zomato restaurants, url string with only ciry id number
    public static final String URL_STRING_CHAMPAIGN = "685";
    public static final String URL_STRING_CHICAGO = "216";
    public static final String URL_STRING_NEW_YORK = "280";
    public final String[] URL_STRING_ARRAY = {URL_STRING_CHAMPAIGN, URL_STRING_CHICAGO, URL_STRING_NEW_YORK};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.restaurant_list);

        List<Restaurants> restaurants = new ArrayList<>();
        final RestaurantAdapter restaurantAdapter = new RestaurantAdapter(restaurants, this);

        recyclerView.setAdapter(restaurantAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false));

        RestaurantsAsyncTask restaurantsAsyncTask = new RestaurantsAsyncTask(this, recyclerView,
                restaurantAdapter);
        restaurantsAsyncTask.execute(URL_STRING_ARRAY);
    }
}
