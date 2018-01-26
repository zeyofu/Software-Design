package com.example;

/**
 * created by Fia Fu
 * 9/18/2017
 *
 * This class holds all info about a single restaurant.
 *
 * {"R":
 * {"res_id": 17317867},
 * "apikey": "e365840918d9530e75ec3bfe580e8000",
 * "id": "17317867",
 * "name": "Golden Harbor",
 * "url": "https://www.zomato.com/champaign-il/golden-harbor-champaign?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1",
 * "location": {"address": "505 S Neil St, Champaign 61820",
 * "locality": "Champaign",
 * "city": "Champaign",
 * "city_id": 685,
 * "latitude": "40.1114320000",
 * "longitude": "-88.2436540000",
 * "zipcode": "61820",
 * "country_id": 216,
 * "locality_verbose": "Champaign, Champaign" },
 * "switch_to_order_menu": 0,
 * "cuisines": "Chinese",
 * "average_cost_for_two": 25,
 * "price_range": 2,
 * "currency": "$",
 * "offers": [],
 * "thumb": "https://b.zmtcdn.com/data/pictures/7/17317867/b7fe6575209d867afe6dc0c6d27a8c48_featured_v2.jpg",
 * "user_rating": { "aggregate_rating": "4.5",
 * "rating_text": "Excellent",
 * "rating_color": "3F7E00",
 * "votes": "292"},
 * "photos_url": "https://www.zomato.com/champaign-il/golden-harbor-champaign/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop",
 * "menu_url": "https://www.zomato.com/champaign-il/golden-harbor-champaign/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop",
 * "featured_image": "https://b.zmtcdn.com/data/pictures/7/17317867/b7fe6575209d867afe6dc0c6d27a8c48_featured_v2.jpg",
 * "has_online_delivery": 0,
 * "is_delivering_now": 0,
 * "deeplink": "zomato://restaurant/17317867",
 * "has_table_booking": 0,
 * "events_url": "https://www.zomato.com/champaign-il/golden-harbor-champaign/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1",
 * "establishment_types": []}
 */
public class Restaurant {
    private R R;
    private String apikey;
    private int id;
    private String name;
    private String url;
    private Location location;
    private int switch_to_order_menu;
    private String cuisines;
    private double average_cost_for_two;
    private int price_range;
    private String currency;
    private String[] offers;
    private String thumb;
    private UserRating user_rating;
    private String photos_url;
    private String menu_url;
    private String featured_image;
    private int has_online_delivery;
    private int is_delivering_now;
    private String deeplink;
    private int has_table_booking;
    private String events_url;
    private String[] establishment_types;

    public com.example.R getR() {
        return R;
    }

    public String getApikey() {
        return apikey;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Location getLocation() {
        return location;
    }

    public int getSwitch_to_order_menu() {
        return switch_to_order_menu;
    }

    public String getCuisines() {
        return cuisines;
    }

    public double getAverage_cost_for_two() {
        return average_cost_for_two;
    }

    public int getPrice_range() {
        return price_range;
    }

    public String getCurrency() {
        return currency;
    }

    public String[] getOffers() {
        return offers;
    }

    public String getThumb() {
        return thumb;
    }

    public UserRating getUser_rating() {
        return user_rating;
    }

    public String getPhotos_url() {
        return photos_url;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public String getFeatured_image() {
        return featured_image;
    }

    public int getHas_online_delivery() {
        return has_online_delivery;
    }

    public int getIs_delivering_now() {
        return is_delivering_now;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public int getHas_table_booking() {
        return has_table_booking;
    }

    public String getEvents_url() {
        return events_url;
    }

    public String[] getEstablishment_types() {
        return establishment_types;
    }
}
