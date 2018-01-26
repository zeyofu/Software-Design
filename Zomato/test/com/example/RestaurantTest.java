package com.example;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RestaurantTest {
    private Gson gson;
    private Restaurant restaurant;
    public static final String JSON_RESTAURANT = "{\"R\": {\n" +
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
            "        \"establishment_types\": []}";

    @Before
    public void setUp() throws Exception {
        gson = new Gson();
        restaurant = gson.fromJson(JSON_RESTAURANT, Restaurant.class);
    }

    @Test
    public void getR() throws Exception {
        assertEquals(17317293, restaurant.getR().getRes_id());
    }

    @Test
    public void getApikey() throws Exception {
        assertEquals("e365840918d9530e75ec3bfe580e8000", restaurant.getApikey());
    }

    @Test
    public void getId() throws Exception {
        assertEquals(17317293, restaurant.getId());
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Evo Cafe",restaurant.getName());
    }

    @Test
    public void getUrl() throws Exception {
        assertEquals("https://www.zomato.com/champaign-il/evo-cafe-champaign?utm_source=api_basic"
                +"_user&utm_medium=api&utm_campaign=v2.1", restaurant.getUrl());
    }

    @Test
    public void getLocation() throws Exception {
        assertEquals("711 S 6th St, Champaign 61820", restaurant.getLocation().getAddress());
    }

    @Test
    public void getSwitch_to_order_menu() throws Exception {
        assertEquals(0, restaurant.getSwitch_to_order_menu());
    }

    @Test
    public void getCuisines() throws Exception {
        assertEquals("Chinese", restaurant.getCuisines());
    }

    @Test
    public void getAverage_cost_for_two() throws Exception {
        assertEquals(10, restaurant.getAverage_cost_for_two(), 0.01);
    }

    @Test
    public void getPrice_range() throws Exception {
        assertEquals(1, restaurant.getPrice_range());
    }

    @Test
    public void getCurrency() throws Exception {
        assertEquals("$",restaurant.getCurrency());
    }

    @Test
    public void getOffers() throws Exception {
    }

    @Test
    public void getThumb() throws Exception {
        assertEquals("", restaurant.getThumb());
    }

    @Test
    public void getUser_rating() throws Exception {
        assertEquals("3.5", restaurant.getUser_rating().getAggregate_rating());
    }

    @Test
    public void getPhotos_url() throws Exception {
        assertEquals( "https://www.zomato.com/champaign-il/evo-cafe-champaign/photos?utm_source="
                + "api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop", restaurant.getPhotos_url());
    }

    @Test
    public void getMenu_url() throws Exception {
        assertEquals("https://www.zomato.com/champaign-il/evo-cafe-champaign/menu?utm_source=api_" +
                "basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop",
                restaurant.getMenu_url());
    }

    @Test
    public void getFeatured_image() throws Exception {
        assertEquals("", restaurant.getFeatured_image());
    }

    @Test
    public void getHas_online_delivery() throws Exception {
        assertEquals(0, restaurant. getHas_online_delivery());
    }

    @Test
    public void getIs_delivering_now() throws Exception {
        assertEquals(0, restaurant. getIs_delivering_now());
    }

    @Test
    public void getDeeplink() throws Exception {
        assertEquals("zomato://restaurant/17317293", restaurant.getDeeplink());
    }

    @Test
    public void getHas_table_booking() throws Exception {
        assertEquals(0, restaurant.getHas_table_booking());
    }

    @Test
    public void getEvents_url() throws Exception {
        assertEquals("https://www.zomato.com/champaign-il/evo-cafe-champaign/events#tabtop?" +
                "utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1", restaurant.getEvents_url());
    }

    @Test
    public void getEstablishment_types() throws Exception {
    }

}