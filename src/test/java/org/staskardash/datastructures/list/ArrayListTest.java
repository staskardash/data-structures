package org.staskardash.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ArrayListTest {

    @Test
    public void testAddWithoutIndexAndGetWorkCorrectlyAndChangeSizeToZero() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals(3, arrayList.size());
        arrayList.get(0);
        arrayList.get(1);
        arrayList.get(2);
        assertEquals(0, arrayList.size());
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testAddOnIndexWithObjectAndGetWorkCorrectlyAndChangeSizeToZero() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals(3, arrayList.size());
        arrayList.add("D", 1);
        assertEquals(4, arrayList.size());
        arrayList.get(0);
        arrayList.get(1);
        arrayList.get(2);
        arrayList.get(3);
        assertEquals(0, arrayList.size());
    }

    @Test
    public void testThrowIllegalStateExceptionWhenAddWithIndexBetweenTwoNull

    @Test
    public void testSetAndGetWorkCorrectlyAndChangeSizeToZero() {
        ArrayList arrayList = new ArrayList();
        arrayList.set("A", 0);
        arrayList.set("B", 1);
        arrayList.set("C", 2);
        arrayList.set("D", 3);

        assertEquals(4, arrayList.size());
        arrayList.get(0);
        arrayList.get(1);
        arrayList.get(2);
        arrayList.get(3);
        assertEquals(0, arrayList.size());
        assertTrue(arrayList.isEmpty());
    }

    public void testSetThanAddWithoutIndexWorkCorrectlyAndChangeSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.set("A", 0);
        arrayList.set("B", 1);
        arrayList.set("C", 2);

        assertEquals(3, arrayList.size());
        arrayList.add()
    }
}
