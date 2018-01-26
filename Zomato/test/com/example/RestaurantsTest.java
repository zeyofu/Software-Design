package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantsTest {
    private Gson gson;
    private Restaurants restaurant;
    public static final String JSON_FOR_ONE_RESTAURANTS = "{\"restaurant\": {\n" +
            "        \"R\": {\n" +
            "          \"res_id\": 17317293\n" +
            "        },\n" +
            "        \"apikey\": \"e365840918d9530e75ec3bfe580e8000\",\n" +
            "        \"id\": \"17317293\",\n" +
            "        \"name\": \"Evo Cafe\",\n" +
            "        \"url\": \"https://www.zomato.com/champaign-il/evo-cafe-champaign?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\n" +
            "        \"location\": {\n" +
            "          \"address\": \"711 S 6th St, Champaign 61820\",\n" +
            "          \"locality\": \"UIUC Campus\",\n" +
            "          \"city\": \"Champaign\",\n" +
            "          \"city_id\": 685,\n" +
            "          \"latitude\": \"40.1101000000\",\n" +
            "          \"longitude\": \"-88.2307000000\",\n" +
            "          \"zipcode\": \"61820\",\n" +
            "          \"country_id\": 216,\n" +
            "          \"locality_verbose\": \"UIUC Campus, Champaign\"\n" +
            "        },\n" +
            "        \"switch_to_order_menu\": 0,\n" +
            "        \"cuisines\": \"Chinese\",\n" +
            "        \"average_cost_for_two\": 10,\n" +
            "        \"price_range\": 1,\n" +
            "        \"currency\": \"$\",\n" +
            "        \"offers\": [],\n" +
            "        \"thumb\": \"\",\n" +
            "        \"user_rating\": {\n" +
            "          \"aggregate_rating\": \"3.5\",\n" +
            "          \"rating_text\": \"Good\",\n" +
            "          \"rating_color\": \"9ACD32\",\n" +
            "          \"votes\": \"51\"\n" +
            "        },\n" +
            "        \"photos_url\": \"https://www.zomato.com/champaign-il/evo-cafe-champaign/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop\",\n" +
            "        \"menu_url\": \"https://www.zomato.com/champaign-il/evo-cafe-champaign/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop\",\n" +
            "        \"featured_image\": \"\",\n" +
            "        \"has_online_delivery\": 0,\n" +
            "        \"is_delivering_now\": 0,\n" +
            "        \"deeplink\": \"zomato://restaurant/17317293\",\n" +
            "        \"has_table_booking\": 0,\n" +
            "        \"events_url\": \"https://www.zomato.com/champaign-il/evo-cafe-champaign/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\n" +
            "        \"establishment_types\": []\n" +
            "      }}";

    @Before
    public void setUp() throws Exception {
        gson = new Gson();
        restaurant = gson.fromJson(JSON_FOR_ONE_RESTAURANTS, Restaurants.class);
    }

    @Test
    public void getRestaurant() throws Exception {
        assertEquals(17317293, restaurant.getRestaurant().getId());
    }

}