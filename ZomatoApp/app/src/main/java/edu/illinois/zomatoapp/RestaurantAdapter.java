package edu.illinois.zomatoapp;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

import edu.illinois.zomatoapp.RestaurantData.Restaurant;
import edu.illinois.zomatoapp.RestaurantData.Restaurants;

/**
 * This class creates a restaurant Adapter object that sets the user interface views,
 * and it is called in the asyncTask.
 *
 * Created by fia on 10/31/17.
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private List<Restaurants> restaurants;
    private Context context;

    public RestaurantAdapter(List<Restaurants> restaurants, Context context) {
        this.restaurants = restaurants;
        this.context = context;
    }

    public void addRestaurant(Restaurants restaurant) {
        restaurants.add(0, restaurant);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View restaurantItem = LayoutInflater.from(context).
                inflate(R.layout.restaurant_list_with_image, parent, false);
        return new ViewHolder(restaurantItem);
    }

    /**
     * Once called, this method sets image and text views in the user interface.
     * If the given restaurants didn't upload a thumb image link, load the default
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Restaurant restaurant = restaurants.get(position).getRestaurant();

        holder.nameTextView.setText(restaurant.getName());
        holder.addressTextView.setText(restaurant.getLocation().getAddress());
        holder.cuisineTextView.setText(restaurant.getCuisines());

        //Check if the thumb is not empty, load its own picture, otherwise the default
        if (!restaurant.getThumb().isEmpty()) {
            Picasso.with(context).load(restaurant.getThumb()).into(holder.imageView);
        }

        //Once click on the item an intent (detailed activity) will start
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context = v.getContext();
                Intent detailedIntent = new Intent(context, DetailActivity.class);
                detailedIntent.putExtra("restaurant", restaurant);
                context.startActivity(detailedIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView nameTextView;
        public TextView addressTextView;
        public TextView cuisineTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            this.addressTextView = (TextView) itemView.findViewById(R.id.addressTextView);
            this.cuisineTextView = (TextView) itemView.findViewById(R.id.cuisineTextView);
        }
    }
}
