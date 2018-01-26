package edu.illinois.zomatoapp;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.MapView;
import com.squareup.picasso.Picasso;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import edu.illinois.zomatoapp.RestaurantData.Restaurant;

/**
 * This class is a detailed activity for each restaurant item once clicked on
 * A link to website and map is included
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Get a restaurant out of extras passed with intent
        final Intent intent = getIntent();
        final Restaurant restaurant = intent.getParcelableExtra("restaurant");

        final TextView websiteText = (TextView) findViewById(R.id.websiteText);
        final ImageView photoView = (ImageView) findViewById(R.id.photoViews);
        final TextView nameText = (TextView) findViewById(R.id.nameText);
        final TextView costText = (TextView) findViewById(R.id.costText);
        final TextView priceText = (TextView) findViewById(R.id.priceText);
        final TextView cuisineText = (TextView) findViewById(R.id.cuisineText);
        final TextView addressText = (TextView) findViewById(R.id.addressText);

        //Sets the thumb image
        if (!restaurant.getThumb().isEmpty()) {
            Picasso.with(this).load(restaurant.getThumb()).into(photoView);
        }

        //Sets all text views
        nameText.setText(restaurant.getName());
        costText.setText("Average Cost For two: " + restaurant.getAverage_cost_for_two() + "$");
        cuisineText.setText(restaurant.getCuisines());
        String price = "";
        for (int i = 0; i < restaurant.getPrice_range(); i++) {
            price += "$";
        }
        priceText.setText(price);

        //Sets the website link
        final String websiteUrl = restaurant.getUrl();
        websiteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri websiteURI = Uri.parse(websiteUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, websiteURI);
                startActivity(intent);
            }
        });

        //Sets the map intent
        final String address = restaurant.getLocation().getAddress();
        addressText.setText("Address: " + address);
        try {
            final String encodedAddress = URLEncoder.encode(address, "UTF-8");
            addressText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Context context = v.getContext();
                    Uri locationUri = Uri.parse("geo:0,0?q=" + encodedAddress);
                    Intent intent = new Intent(Intent.ACTION_VIEW, locationUri);
                    if (intent.resolveActivity(context.getPackageManager()) != null) {
                        context.startActivity(intent);
                    }
                }
            });
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
            addressText.setOnClickListener(null);
        }
    }
}

