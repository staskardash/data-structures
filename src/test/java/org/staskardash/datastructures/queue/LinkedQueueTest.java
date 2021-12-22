package org.staskardash.datastructures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LinkedQueueTest {

    @Test
    public void testEnqueueAndDequeueWorkCorrectlyAndChangeSizeToZero() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");

        assertEquals(3, linkedQueue.size());
        assertEquals("A", linkedQueue.dequeue());
        assertEquals("B", linkedQueue.dequeue());
        assertEquals("C", linkedQueue.dequeue());
        assertEquals(0, linkedQueue.size());
        assertTrue(linkedQueue.isEmpty());
    }

    @Test
    public void testEnqueueOverInitialCapacityAndDequeueWorkCorrectly() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");

        assertEquals(3, linkedQueue.size());
        assertEquals("A", linkedQueue.dequeue());
        assertEquals("B", linkedQueue.dequeue());
        assertEquals("C", linkedQueue.dequeue());
        assertEquals(0, linkedQueue.size());
        assertTrue(linkedQueue.isEmpty());
    }

    @Test
    public void testEnqueueAndPeek() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");

        assertEquals(3, linkedQueue.size());
        assertEquals("A", linkedQueue.peek());
        assertEquals("A", linkedQueue.peek());
        assertEquals(3, linkedQueue.size());
    }

    @Test
    public void testIsEmptyReturnTueOnNewQueue() {
        LinkedQueue linkedQueue = new LinkedQueue();

        assertTrue(linkedQueue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseOnQueueWithData() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");

        assertFalse(linkedQueue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnQueueAfterClear() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.clear();

        assertTrue(linkedQueue.isEmpty());
    }

    @Test
    public void testContainsReturnTrue() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");

        assertTrue(linkedQueue.contains("A"));
    }

    @Test
    public void testContainsReturnFalse() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");

        assertFalse(linkedQueue.contains("C"));
    }

    @Test
    public void testContainsReturnFalseOnEmptyQueue() {
        LinkedQueue linkedQueue = new LinkedQueue();

        assertFalse(linkedQueue.contains("A"));
    }

    @Test
    public void testThrowIllegalStateExceptionsWhenDequeueFromEmptyQueue() {
        LinkedQueue linkedQueue = new LinkedQueue();

        Assertions.assertThrows(IllegalStateException.class, () -> {
            linkedQueue.dequeue();
        });
    }
}
