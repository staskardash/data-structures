package org.staskardash.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractListTest {
    
    private List list;

    @BeforeEach
    public void before() {
        list = getList();
    }

    protected abstract List getList();

    @Test
    public void testAddWithoutIndexAndGetWorkCorrectlyAndDoesNotChangeSize() {
        
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        assertEquals(4, list.size());
        list.get(0);
        list.get(1);
        list.get(2);
        list.get(3);
        assertEquals(4, list.size());
    }

    @Test
    public void testAddOverInitialCapacityAndGetWorkCorrectly() {
        ArrayList list = new ArrayList(2);
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals(3, list.size());
        list.get(0);
        list.get(1);
        list.get(2);
        assertEquals(3, list.size());


    }

    @Test
    public void testAddOnIndexWithObjectAndGetWorkCorrectlyAndDoesNotChangeSize() {
        
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals(3, list.size());
        list.add("D", 1);
        assertEquals(4, list.size());
        list.get(0);
        list.get(1);
        list.get(2);
        list.get(3);
        assertEquals(4, list.size());
    }

    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenAddWithIndexBetweenTwoNull() {
        
        list.add("A");
        list.add("B");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add("C", 3);
        });
    }

    @Test
    public void testAddAndRemoveWorkCorrectlyAndChangeSizeToZero() {
        
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        assertEquals(4, list.size());
        list.remove(0);
        assertEquals(3, list.size());
        list.remove(1);
        assertEquals(2, list.size());
        list.remove(0);
        assertEquals(1, list.size());
        list.remove(0);
        assertEquals(0,list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testAddRemoveAndLastIndexOfWorkCorrectlyAndChangeSize() {
        
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        assertEquals(4, list.size());
        list.remove(1);
        assertEquals(3, list.size());
        list.remove(1);
        assertEquals(1, list.lastIndexOf("D"));
        assertEquals(2, list.size());

    }

    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenRemoveOnEmptyList() {
        

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(0);
        });
    }

    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenGetOnEmptyList() {
        

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(1);
        });
    }


    @Test
    public void testAddThanSetAndGetWorkCorrectlyAndDoesNotChangeSize() {
        
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals(3, list.size());
        list.set("D", 1);
        assertEquals(3, list.size());
        list.get(1);
        assertEquals(3, list.size());
    }

    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenSetonEmptyList() {
        

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set("A", 0);
        });
    }

    @Test
    public void testIsEmptyReturnTrueAfterClear() {
        
        list.add("A");
        assertEquals(1, list.size());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnNewList() {
        

        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseOnListWithObject() {
        

        list.add("A");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testContainsReturnTrue() {
        
        list.add("A");
        list.add("B");
        list.add("C");

        assertTrue(list.contains("B"));
    }

    @Test
    public void testAddAndSetContainsReturnTrue() {
        
        list.add("A");
        list.add("B");

        assertTrue(list.contains("B"));
        list.set("C", 1);
        assertTrue(list.contains("C"));
    }

    @Test
    public void testContainsReturnFalse() {
        
        list.add("A");

        assertFalse(list.contains("B"));
    }

    @Test
    public void testContainsReturnFalseOnEmptyList() {
        

        assertFalse(list.contains("B"));
    }

    @Test
    public void testAddThenFindObjectWithIndexOfWorkCorrectly() {
        
        list.add("A");
        list.add("B");
        list.add("A");
        list.add("C");

        assertEquals(0, list.indexOf("A"));
        assertEquals(3, list.indexOf("C"));
    }

    @Test
    public void testAddThenFindObjectWithIndexOfObjectThatDoesNotExistWorkCorrectly() {
        
        list.add("A");
        list.add("B");

        assertEquals(-1, list.indexOf("C"));
    }

    @Test
    public void testFindObjectWithIndexOfOnEmptyList() {
        

        assertEquals(-1, list.indexOf("A"));
    }

    @Test
    public void testAddThenSetAndAddByIndexThenFindObjectWithLastIndexOfWorkCorrectly() {
        
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals(2, list.lastIndexOf("C"));
        list.set("C", 1);
        list.add("B", 2);
        assertEquals(2, list.lastIndexOf("B"));
    }

    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenGetLessThanZero() {
        

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-1);
        });
    }

    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenAddLessThanZero() {
        

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add("A", -1);
        });
    }
}
