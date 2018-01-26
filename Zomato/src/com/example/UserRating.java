package com.example;

/**
 * This class stores user-rating info of a restaurant.
 *{
 "aggregate_rating": "3.5",
 "rating_text": "Good",
 "rating_color": "9ACD32",
 "votes": "51"
 }
 */
public class UserRating {
    private String aggregate_rating;
    private String rating_text;
    private String rating_color;
    private String votes;

    public String getAggregate_rating() {
        return aggregate_rating;
    }

    public String getRating_text() {
        return rating_text;
    }

    public String getRating_color() {
        return rating_color;
    }

    public String getVotes() {
        return votes;
    }
}
