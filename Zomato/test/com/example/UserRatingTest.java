package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRatingTest {

    private UserRating rating;
    private Gson gson;
    public static final String JSON_USER_RATING = "{\n" +
            "          \"aggregate_rating\": \"3.5\",\n" +
            "          \"rating_text\": \"Good\",\n" +
            "          \"rating_color\": \"9ACD32\",\n" +
            "          \"votes\": \"51\"\n" +
            "        }";

    @Before
    public void setUp() throws Exception {
        gson = new Gson();
        rating = gson.fromJson(JSON_USER_RATING, UserRating.class);
    }

    @Test
    public void getAggregate_rating() throws Exception {
        assertEquals("3.5", rating.getAggregate_rating());
    }

    @Test
    public void getRating_text() throws Exception {
        assertEquals("Good", rating.getRating_text());
    }

    @Test
    public void getRating_color() throws Exception {
        assertEquals("9ACD32", rating.getRating_color());
    }

    @Test
    public void getVotes() throws Exception {
        assertEquals("51", rating.getVotes());
    }

}