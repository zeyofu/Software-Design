package edu.illinois.zomatoapp.RestaurantData;

/**
 * This class holds the info you get when you search for a city ID on zomato.
 * {
 "location_suggestions": [
 {
 "id": 685,
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
 }
 ],
 "status": "success",
 "has_more": 0,
 "has_total": 0
 }
 */
public class CitySearch {
    private City[] location_suggestions;
    private String status;
    private int has_more;
    private int has_total;

    public City[] getLocation_suggestions() {
        return location_suggestions;
    }

    public String getStatus() {
        return status;
    }

    public int getHas_more() {
        return has_more;
    }

    public int getHas_total() {
        return has_total;
    }
}
