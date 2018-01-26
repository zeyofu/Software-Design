package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CityTest {

    private City city;
    private Gson gson;
    public static final String JSON_CITY = "{\n" +
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
            "    }";

    @Before
    public void setUp() throws Exception {
        gson = new Gson();
        city = gson.fromJson(JSON_CITY, City.class);
    }

    @Test
    public void getId() throws Exception {
        assertEquals(685, city.getId());
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Champaign, IL", city.getName());
    }

    @Test
    public void getCountry_id() throws Exception {
        assertEquals(216, city.getCountry_id());
    }

    @Test
    public void getCountry_name() throws Exception {
        assertEquals("United States", city.getCountry_name());
    }

    @Test
    public void getShould_experiment_with() throws Exception {
        assertEquals(0, city.getShould_experiment_with());
    }

    @Test
    public void getDiscovery_enabled() throws Exception {
        assertEquals(0, city.getDiscovery_enabled());
    }

    @Test
    public void getHas_new_ad_format() throws Exception {
        assertEquals(0, city.getHas_new_ad_format());
    }

    @Test
    public void getIs_state() throws Exception {
        assertEquals(0, city.getIs_state());
    }

    @Test
    public void getState_id() throws Exception {
        assertEquals(82, city.getState_id());
    }

    @Test
    public void getState_name() throws Exception {
        assertEquals("Illinois", city.getState_name());
    }

    @Test
    public void getState_code() throws Exception {
        assertEquals("IL", city.getState_code());
    }

}