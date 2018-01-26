package edu.illinois.zomatoapp.RestaurantData;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * THis class returns location info of a restaurant.
 *
 * "location": {
 * "address": "1805 Philo Rd, Urbana 61802",
 * "locality": "Urbana",
 * "city": "Champaign",
 * "city_id": 685,
 * "latitude": "40.0965000000",
 * "longitude": "-88.1909000000",
 * "zipcode": "61802",
 * "country_id": 216,
 * "locality_verbose": "Urbana, Champaign"}
 */
public class Location implements Parcelable{
    private String address;
    private String locality;
    private String city;
    private int city_id;
    private String latitude;
    private String longitude;
    private String zipcode;
    private int country_id;
    private String locality_verbose;

    protected Location(Parcel in) {
        address = in.readString();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public String getAddress() {
        return address;
    }

    public String getLocality() {
        return locality;
    }

    public String getCity() {
        return city;
    }

    public int getCity_id() {
        return city_id;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getZipcode() {
        return zipcode;
    }

    public int getCountry_id() {
        return country_id;
    }

    public String getLocality_verbose() {
        return locality_verbose;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(address);
    }
}
