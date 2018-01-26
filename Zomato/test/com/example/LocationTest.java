package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationTest {
    private Location location;
    private Gson gson;
    public static final String JSON_LOCATION = "{\n" +
            "          \"address\": \"711 S 6th St, Champaign 61820\",\n" +
            "          \"locality\": \"UIUC Campus\",\n" +
            "          \"city\": \"Champaign\",\n" +
            "          \"city_id\": 685,\n" +
            "          \"latitude\": \"40.1101000000\",\n" +
            "          \"longitude\": \"-88.2307000000\",\n" +
            "          \"zipcode\": \"61820\",\n" +
            "          \"country_id\": 216,\n" +
            "          \"locality_verbose\": \"UIUC Campus, Champaign\"\n" +
            "        }";

    @Before
    public void setUp() throws Exception {
        gson = new Gson();
        location = gson.fromJson(JSON_LOCATION, Location.class);
    }

    @Test
    public void getAddress() throws Exception {
        assertEquals("711 S 6th St, Champaign 61820", location.getAddress());
    }

    @Test
    public void getLocality() throws Exception {
        assertEquals("UIUC Campus", location.getLocality());
    }

    @Test
    public void getCity() throws Exception {
        assertEquals("Champaign", location.getCity());
    }

    @Test
    public void getCity_id() throws Exception {
        assertEquals(685, location.getCity_id());
    }

    @Test
    public void getLatitude() throws Exception {
        assertEquals("40.1101000000", location.getLatitude());
    }

    @Test
    public void getLongitude() throws Exception {
        assertEquals("-88.2307000000", location.getLongitude());
    }

    @Test
    public void getZipcode() throws Exception {
        assertEquals("61820", location.getZipcode());
    }

    @Test
    public void getCountry_id() throws Exception {
        assertEquals(216, location.getCountry_id());
    }

    @Test
    public void getLocality_verbose() throws Exception {
        assertEquals("UIUC Campus, Champaign", location.getLocality_verbose());
    }

}