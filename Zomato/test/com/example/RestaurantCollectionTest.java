package com.example;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RestaurantCollectionTest {
    private RestaurantCollection restaurants;
    public static final String JSON_FOR_RESTAURANT_COLLECTION = "{\n" +
            "  \"results_found\": 39,\n" +
            "  \"results_start\": 0,\n" +
            "  \"results_shown\": 20,\n" +
            "  \"restaurants\": [\n" +
            "    {\n" +
            "      \"restaurant\": {\n" +
            "        \"R\": {\n" +
            "          \"res_id\": 17317867\n" +
            "        },\n" +
            "        \"apikey\": \"e365840918d9530e75ec3bfe580e8000\",\n" +
            "        \"id\": \"17317867\",\n" +
            "        \"name\": \"Golden Harbor\",\n" +
            "        \"url\": \"https://www.zomato.com/champaign-il/golden-harbor-champaign?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\n" +
            "        \"location\": {\n" +
            "          \"address\": \"505 S Neil St, Champaign 61820\",\n" +
            "          \"locality\": \"Champaign\",\n" +
            "          \"city\": \"Champaign\",\n" +
            "          \"city_id\": 685,\n" +
            "          \"latitude\": \"40.1114320000\",\n" +
            "          \"longitude\": \"-88.2436540000\",\n" +
            "          \"zipcode\": \"61820\",\n" +
            "          \"country_id\": 216,\n" +
            "          \"locality_verbose\": \"Champaign, Champaign\"\n" +
            "        },\n" +
            "        \"switch_to_order_menu\": 0,\n" +
            "        \"cuisines\": \"Chinese\",\n" +
            "        \"average_cost_for_two\": 25,\n" +
            "        \"price_range\": 2,\n" +
            "        \"currency\": \"$\",\n" +
            "        \"offers\": [],\n" +
            "        \"thumb\": \"https://b.zmtcdn.com/data/pictures/7/17317867/b7fe6575209d867afe6dc0c6d27a8c48_featured_v2.jpg\",\n" +
            "        \"user_rating\": {\n" +
            "          \"aggregate_rating\": \"4.5\",\n" +
            "          \"rating_text\": \"Excellent\",\n" +
            "          \"rating_color\": \"3F7E00\",\n" +
            "          \"votes\": \"292\"\n" +
            "        },\n" +
            "        \"photos_url\": \"https://www.zomato.com/champaign-il/golden-harbor-champaign/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop\",\n" +
            "        \"menu_url\": \"https://www.zomato.com/champaign-il/golden-harbor-champaign/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop\",\n" +
            "        \"featured_image\": \"https://b.zmtcdn.com/data/pictures/7/17317867/b7fe6575209d867afe6dc0c6d27a8c48_featured_v2.jpg\",\n" +
            "        \"has_online_delivery\": 0,\n" +
            "        \"is_delivering_now\": 0,\n" +
            "        \"deeplink\": \"zomato://restaurant/17317867\",\n" +
            "        \"has_table_booking\": 0,\n" +
            "        \"events_url\": \"https://www.zomato.com/champaign-il/golden-harbor-champaign/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\n" +
            "        \"establishment_types\": []\n" +
            "      }\n" +
            "    }, {\n" +
            "      \"restaurant\": {\n" +
            "        \"R\": {\n" +
            "          \"res_id\": 17317759\n" +
            "        },\n" +
            "        \"apikey\": \"e365840918d9530e75ec3bfe580e8000\",\n" +
            "        \"id\": \"17317759\",\n" +
            "        \"name\": \"Sunny Chinese Buffet\",\n" +
            "        \"url\": \"https://www.zomato.com/champaign-il/sunny-chinese-buffet-urbana?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\n" +
            "        \"location\": {\n" +
            "          \"address\": \"1703 Philo Rd, Urbana 61802\",\n" +
            "          \"locality\": \"Urbana\",\n" +
            "          \"city\": \"Champaign\",\n" +
            "          \"city_id\": 685,\n" +
            "          \"latitude\": \"40.0982000000\",\n" +
            "          \"longitude\": \"-88.1909000000\",\n" +
            "          \"zipcode\": \"61802\",\n" +
            "          \"country_id\": 216,\n" +
            "          \"locality_verbose\": \"Urbana, Champaign\"\n" +
            "        },\n" +
            "        \"switch_to_order_menu\": 0,\n" +
            "        \"cuisines\": \"Chinese\",\n" +
            "        \"average_cost_for_two\": 10,\n" +
            "        \"price_range\": 1,\n" +
            "        \"currency\": \"$\",\n" +
            "        \"offers\": [],\n" +
            "        \"thumb\": \"\",\n" +
            "        \"user_rating\": {\n" +
            "          \"aggregate_rating\": \"3.2\",\n" +
            "          \"rating_text\": \"Average\",\n" +
            "          \"rating_color\": \"CDD614\",\n" +
            "          \"votes\": \"44\"\n" +
            "        },\n" +
            "        \"photos_url\": \"https://www.zomato.com/champaign-il/sunny-chinese-buffet-urbana/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop\",\n" +
            "        \"menu_url\": \"https://www.zomato.com/champaign-il/sunny-chinese-buffet-urbana/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop\",\n" +
            "        \"featured_image\": \"\",\n" +
            "        \"has_online_delivery\": 0,\n" +
            "        \"is_delivering_now\": 0,\n" +
            "        \"deeplink\": \"zomato://restaurant/17317759\",\n" +
            "        \"has_table_booking\": 0,\n" +
            "        \"events_url\": \"https://www.zomato.com/champaign-il/sunny-chinese-buffet-urbana/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\n" +
            "        \"establishment_types\": []\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        String url = "https://developers.zomato.com/api/v2.1/search?entity_id=685&entity_type=city&cuisines=25";
        final HttpResponse<String> stringHttpResponse = Unirest.get(url).
                header("user-key", Api.API_KEY).asString();
        if (stringHttpResponse.getStatus() == 200) {
          String json = stringHttpResponse.getBody();
          restaurants = gson.fromJson(json,RestaurantCollection.class);
        }else{
          restaurants = gson.fromJson(JSON_FOR_RESTAURANT_COLLECTION, RestaurantCollection.class);
        }
    }

    @Test
    public void getResult_found() throws Exception {
        assertEquals(39,restaurants.getResults_found());
    }

    @Test
    public void getResult_start() throws Exception {
        assertEquals(0,restaurants.getResults_start());
    }

    @Test
    public void getResult_shown() throws Exception {
        assertEquals(20,restaurants.getResults_shown());
    }

    @Test
    public void getRestaurantsID() throws Exception {
        Restaurant firstResturant = restaurants.getRestaurants()[0].getRestaurant();
        Restaurant forthResturant = restaurants.getRestaurants()[3].getRestaurant();
        assertEquals(17317867,firstResturant.getId());
        assertEquals(17317432,forthResturant.getId());
    }
}