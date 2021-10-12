package com.study.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {

    ArrayList arrayList;

    @Before
    public void setUp() throws Exception {
        arrayList = new ArrayList();
        arrayList.add("0");
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");
    }

    @Test
    public void testAdd() {
        arrayList.add("11");


        assertEquals(12, arrayList.size());
        assertEquals("11", arrayList.get(11));

    }

    @Test
    public void testAddForIndex() {
        arrayList.add("11", 5);

        assertEquals(12, arrayList.size());
        assertEquals("11", arrayList.get(5));
        assertEquals("5", arrayList.get(6));
        assertEquals("10", arrayList.get(11));

    }

    @Test
    public void testRemove() {
        arrayList.remove(0);

        assertEquals("1", arrayList.get(0));
        assertEquals(10, arrayList.size());
        assertEquals("10", arrayList.get(9));
        assertEquals("1", arrayList.remove(0).toString());

    }

    @Test
    public void testGet() {
        assertEquals("0", arrayList.get(0));
    }

    @Test
    public void testSet() {
        arrayList.set("99", 3);

        assertEquals("99", arrayList.get(3));
        assertEquals(11, arrayList.size());

    }

    @Test
    public void testClear() {
        arrayList.clear();

        assertEquals(0, arrayList.size());
        assertNull(arrayList.get(0));
    }

    @Test
    public void testSize() {
        assertEquals(11, arrayList.size());
        arrayList.add("0");
        assertEquals(12, arrayList.size());
        arrayList.remove(5);
        arrayList.remove(5);
        assertEquals(10, arrayList.size());


    }

    @Test
    public void testIsEmpty() {
        arrayList = new ArrayList();

        assertTrue(arrayList.isEmpty());
        arrayList.add("1");
        assertFalse(arrayList.isEmpty());
    }

    @Test
    public void testContains() {

        assertTrue(arrayList.contains("5"));
    }

    @Test
    public void testIndexOf() {
        assertEquals(2, arrayList.indexOf("2"));

        arrayList.add(new String("3"), 3);
    }

    @Test
    public void testLastIndexOf() {
        arrayList.add("4");

        assertEquals(11, arrayList.lastIndexOf("4"));
    }

    @Test
    public void testToString() {
        arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");


        assertEquals("[1, 2, 3]", arrayList.toString());
    }
}