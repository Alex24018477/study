package com.study.datastructures.map;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class HashMapTest {

    Map map = new HashMap();

    @Before
    public void setUp() throws Exception {

        map.put("0", "Java0");
        map.put("1", "Java1");
        map.put("2", "Java2");
        map.put("3", "Java3");
        map.put("4", "Java4");
        map.put("5", "Java5");
    }

    @Test
    public void testPutAndGet() {

        assertEquals(6, map.size());
        assertEquals("Java0", map.get("0"));
        assertEquals("Java5", map.get("5"));

        map.put("4", "Alex");
        map.put("4", "Alex24");

        assertEquals("Alex24", map.get("4"));

    }


    @Test
    public void testSize() {
        Map map = new HashMap();

        assertEquals(0, map.size());

        map.put("0", "Java0");
        map.put("1", "Java1");

        assertEquals(2, map.size());

        map.put("1", "Alex");

        assertEquals(2, map.size());

    }

    @Test
    public void testContainsKey() {

        assertTrue(map.containsKey("0"));
        assertTrue(map.containsKey("5"));
        assertFalse(map.containsKey("6"));

    }

    @Test
    public void testRemove() {

        map.remove("0");
        map.remove("4");


        assertFalse(map.containsKey("0"));
        assertFalse(map.containsKey("4"));
        assertEquals(4, map.size());
        assertEquals(null, map.remove("20"));
        assertEquals("2=Java2", map.remove("2").toString());

    }

    @Test
    public void testToString() {

        assertEquals(54, map.toString().toCharArray().length);
    }


}