package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CitySearchTest {

    private CitySearch result;
    private Gson gson;
    public static final String JSON_CITY_SEARCH = "{\n" +
            "  \"location_suggestions\": [\n" +
            "    {\n" +
            "      \"id\": 685,\n" +
            "      \"name\": \"Champaign, IL\",\n" +
            "      \"country_id\": 216,\n" +
            "      \"country_name\": \"United States\",\n" +
            "      \"should_experiment_with\": 0,\n" +
            "      \"discovery_enabled\": 0,\n" +
            "      \"has_new_ad_format\": 0,\n" +
            "      \"is_state\": 0,\n" +
            "      \"state_id\": 82,\n" +
            "      \"state_name\": \"Illinois\",\n" +
            "      \"state_code\": \"IL\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"success\",\n" +
            "  \"has_more\": 0,\n" +
            "  \"has_total\": 0\n" +
            "}";

    @Before
    public void setUp() throws Exception {
        gson = new Gson();
        result = gson.fromJson(JSON_CITY_SEARCH, CitySearch.class);
    }

    @Test
    public void getLocation_suggestions() throws Exception {
        assertEquals(685, result.getLocation_suggestions()[0].getId());
    }

    @Test
    public void getStatus() throws Exception {
        assertEquals("success", result.getStatus());
    }

    @Test
    public void getHas_more() throws Exception {
        assertEquals(0, result.getHas_more());
    }

    @Test
    public void getHas_total() throws Exception {
        assertEquals(0, result.getHas_total());
    }

}