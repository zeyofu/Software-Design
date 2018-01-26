package com.example;

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
public class Location {
    private String address;
    private String locality;
    private String city;
    private int city_id;
    private String latitude;
    private String longitude;
    private String zipcode;
    private int country_id;
    private String locality_verbose;

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
}
