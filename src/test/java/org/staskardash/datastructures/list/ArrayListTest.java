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
        arrayList.add("D");

        assertEquals(4, arrayList.size());
        arrayList.get(0);
        arrayList.get(1);
        arrayList.get(2);
        arrayList.get(3);
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
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testThrowIllegalStateExceptionWhenAddWithIndexBetweenTwoNull() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayList.add("C", 3);
        });
    }

    @Test
    public void testAddAndRemoveWorkCorrectlyAndChangeSizeToZero() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

        assertEquals(4, arrayList.size());
        arrayList.remove(0);
        assertEquals(3, arrayList.size());
        arrayList.remove(1);
        assertEquals(2, arrayList.size());
        arrayList.remove(0);
        assertEquals(1, arrayList.size());
        arrayList.remove(0);
        assertEquals(0,arrayList.size());
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testAddRemoveGetAndLastIndexOfWorkCorrectlyAndChangeSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

        assertEquals(4, arrayList.size());
        arrayList.remove(1);
        assertEquals(3, arrayList.size());
        arrayList.get(1);
        assertEquals(2, arrayList.lastIndexOf("D"));
        assertEquals(2, arrayList.size());

    }

    @Test
    public void testThrowIllegalStateExceptionWhenRemoveOnEmptyList() {
        ArrayList arrayList = new ArrayList();

        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayList.remove(0);
        });
    }

    @Test
    public void testThrowIllegalStateExceptionWhenGetOnEmptyList() {
        ArrayList arrayList = new ArrayList();

        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayList.get(1);
        });
    }


    @Test
    public void testAddThanSetAndGetWorkCorrectlyAndDoesNotChangeSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals(3, arrayList.size());
        arrayList.set("D", 1);
        assertEquals(3, arrayList.size());
        arrayList.get(1);
        assertEquals(2, arrayList.size());
    }

    @Test
    public void testThrowIllegalStateExceptionWhenSetonEmptyList() {
        ArrayList arrayList = new ArrayList();

        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayList.set("A", 0);
        });
    }

    @Test
    public void testIsEmptyReturnTrueAfterClear() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        assertEquals(1, arrayList.size());
        arrayList.clear();
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnNewList() {
        ArrayList arrayList = new ArrayList();

        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseOnListWithObject() {
        ArrayList arrayList = new ArrayList();

        arrayList.add("A");
        assertFalse(arrayList.isEmpty());
    }

    @Test
    public void testContainsReturnTrue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertTrue(arrayList.contains("B"));
    }

    @Test
    public void testAddAndSetContainsReturnTrue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        assertTrue(arrayList.contains("B"));
        arrayList.set("C", 1);
        assertTrue(arrayList.contains("C"));
    }

    @Test
    public void testContainsReturnFalse() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");

        assertFalse(arrayList.contains("B"));
    }

    @Test
    public void testContainsReturnFalseOnEmptyList() {
        ArrayList arrayList = new ArrayList();

        assertFalse(arrayList.contains("B"));
    }

    @Test
    public void testAddThenFindObjectWithIndexOfWorkCorrectly() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");
        arrayList.add("C");

        assertEquals(0, arrayList.indexOf("A"));
    }

    @Test
    public void testAddThenFindObjectWithIndexOfObjectThatDoesNotExistWorkCorrectly() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        assertEquals(-1, arrayList.indexOf("C"));
    }

    @Test
    public void testFindObjectWithIndexOfOnEmptyList() {
        ArrayList arrayList = new ArrayList();

        assertEquals(-1, arrayList.indexOf("A"));
    }

    @Test
    public void testAddThenSetAndAddByIndexThenFindObjectWithLastIndexOfWorkCorrectly() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals(2, arrayList.lastIndexOf("C"));
        arrayList.set("C", 1);
        arrayList.add("C", 2);
        assertEquals(3, arrayList.lastIndexOf("C"));
    }


}
