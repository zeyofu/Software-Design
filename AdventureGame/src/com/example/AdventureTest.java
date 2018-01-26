package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdventureTest {

    private static Adventure game;
    private static final String standURL = "https://courses.engr." +
            "illinois.edu/cs126/adventure/siebel.json";

    @Before
    public void setUp() throws Exception {
        game = new Adventure();
        game.getSetUp(standURL);
    }

    @org.junit.Test
    public void getRoomByNameNull() throws Exception {
        assertEquals(null, game.getRoomByName("Chicken"));
    }

    @Test
    public void getRoomByNameValid() throws Exception {
        assertEquals("AcmOffice", game.getRoomByName("AcmOffice").getName());
    }

    @Test
    public void getRoomNameByDirectionInvalid() throws Exception {
        assertEquals(null, game.getRoomNameByDirection("chicken"));
    }

    @Test
    public void getRoomNameByDirectionValid() throws Exception {
        assertEquals("SiebelEntry", game.getRoomNameByDirection("east"));
    }

    @Test (expected = RuntimeException.class)
    public void getSetUpBadURL() throws Exception {
        game.getSetUp("dfsdf");
        game.getSetUp("https://baidu.com");
    }

    @Test
    public void floorValidator() throws Exception {
        assertEquals(false, game.floorValidator());
    }
}