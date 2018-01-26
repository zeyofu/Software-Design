package com.example;

/**
 * "id": 685,
 "name": "Champaign, IL",
 "country_id": 216,
 "country_name": "United States",
 "should_experiment_with": 0,
 "discovery_enabled": 0,
 "has_new_ad_format": 0,
 "is_state": 0,
 "state_id": 82,
 "state_name": "Illinois",
 "state_code": "IL"
 */
public class City {
    private int id;
    private String name;
    private int country_id;
    private String country_name;
    private int should_experiment_with;
    private int discovery_enabled;
    private int has_new_ad_format;
    private int is_state;
    private int state_id;
    private String state_name;
    private String state_code;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCountry_id() {
        return country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public int getShould_experiment_with() {
        return should_experiment_with;
    }

    public int getDiscovery_enabled() {
        return discovery_enabled;
    }

    public int getHas_new_ad_format() {
        return has_new_ad_format;
    }

    public int getIs_state() {
        return is_state;
    }

    public int getState_id() {
        return state_id;
    }

    public String getState_name() {
        return state_name;
    }

    public String getState_code() {
        return state_code;
    }
}
