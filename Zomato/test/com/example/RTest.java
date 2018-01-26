package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RTest {

    private R r;
    private Gson gson;
    public static final String JSON_R= "{\n" +
            "          \"res_id\": 17317293\n" +
            "        }";

    @Before
    public void setUp() throws Exception {
        gson = new Gson();
        r = gson.fromJson(JSON_R, R.class);
    }

    @Test
    public void getRes_id() throws Exception {
        assertEquals(17317293, r.getRes_id());
    }
}