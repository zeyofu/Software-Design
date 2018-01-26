package edu.illinois.zomatoapp.RestaurantData;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * created by Fia Fu
 * 9/18/2017
 * This class holds all info about a single restaurant.
 *
 * modified by Fia Fu
 * 11/07/2017
 * This class implements Parcelable
 *
 * {"r":
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
public class Restaurant implements Parcelable{
    private r R;
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

    public Restaurant(r r, String apikey, int id, String name, String url, Location location, int switch_to_order_menu, String cuisines, double average_cost_for_two, int price_range, String currency, String[] offers, String thumb, UserRating user_rating, String photos_url, String menu_url, String featured_image, int has_online_delivery, int is_delivering_now, String deeplink, int has_table_booking, String events_url, String[] establishment_types) {
        R = r;
        this.apikey = apikey;
        this.id = id;
        this.name = name;
        this.url = url;
        this.location = location;
        this.switch_to_order_menu = switch_to_order_menu;
        this.cuisines = cuisines;
        this.average_cost_for_two = average_cost_for_two;
        this.price_range = price_range;
        this.currency = currency;
        this.offers = offers;
        this.thumb = thumb;
        this.user_rating = user_rating;
        this.photos_url = photos_url;
        this.menu_url = menu_url;
        this.featured_image = featured_image;
        this.has_online_delivery = has_online_delivery;
        this.is_delivering_now = is_delivering_now;
        this.deeplink = deeplink;
        this.has_table_booking = has_table_booking;
        this.events_url = events_url;
        this.establishment_types = establishment_types;
    }


    public r getR() {
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

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * This class contains all the info we need in detailed activity
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.url);
        dest.writeParcelable(this.location, flags);
        dest.writeString(this.cuisines);
        dest.writeDouble(this.average_cost_for_two);
        dest.writeString(this.currency);
        dest.writeInt(this.price_range);
        dest.writeString(this.thumb);
        dest.writeString(this.menu_url);
    }

    protected Restaurant(Parcel in) {
        this.name = in.readString();
        this.url = in.readString();
        this.location = in.readParcelable(Location.class.getClassLoader());
        this.cuisines = in.readString();
        this.average_cost_for_two = in.readDouble();
        this.currency = in.readString();
        this.price_range = in.readInt();
        this.thumb = in.readString();
        this.menu_url = in.readString();
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel source) {
            return new Restaurant(source);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };
}
