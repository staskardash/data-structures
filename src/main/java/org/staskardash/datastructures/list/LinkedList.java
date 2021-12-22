package org.staskardash.datastructures.list;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class LinkedList<T> implements List<T>, Iterable<T>{

    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void add(T value) {
        add(value, size);
    }

    @Override
    public void add(T value, int index) {
        Node<T> newNode = new Node<>(value);
        if(index < 0 | index > size) {
            throw new IndexOutOfBoundsException ("Can't add value in this in this index!");
        } else if(size == 0) {
            head = tail = newNode;
        } else if(index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else if(index == 0) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> currentNode = getNode(index);
            Node<T> prevNode = currentNode.prev;
            prevNode.next = newNode;
            currentNode.prev = newNode;
            newNode.next = currentNode;
            newNode.prev = prevNode;
        }
        size ++;
    }

    @Override
    public T remove(int index) {
        if(isEmpty() | index < 0 | index >= size) {
            throw new IndexOutOfBoundsException ("Can't remove null value!");
        } else if (size == 1) {
            Node<T> resultNode = head;
            head = tail = null;
            size--;
            return resultNode.value;
        } else if(index == 0) {
            Node<T> resultNode = head;
            head = head.next;
            size--;
            return resultNode.value;
        } else if(index == size - 1) {
            Node<T> newTailNode = tail.prev;
            Node<T> resultNode = tail;
            newTailNode.next = null;
            tail = newTailNode;
            size--;
            return resultNode.value;
        } else {
            Node<T> currentNode = getNode(index);
            Node<T> prevNode = currentNode.prev;
            Node<T> nextNode = currentNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
            return currentNode.value;
        }
    }

    @Override
    public T get(int index) {
        if(isEmpty() | index < 0 | index >= size) {
            throw new IndexOutOfBoundsException("Can't get null value!");
        } else if(index == 0) {
            return head.value;
        } else if(index == size - 1) {
            return tail.value;
        } else {
            return getNode(index).value;
        }
    }

    @Override
    public T set(T value, int index) {
        if(isEmpty() | index < 0 | index >= size) {
            throw new IndexOutOfBoundsException ("LinkedList is Empty");
        } else if(index == 0) {
            Node<T> resultNode = head;
            head.value = value;
            return resultNode.value;
        } else if(index == size - 1) {
            Node<T> resultNode = tail;
            tail.value = value;
            return resultNode.value;
        } else {
            Node<T> currentNode = getNode(index);
            T currentValue = getNode(index).value;
            currentNode.value = value;
            return currentValue;
        }
    }

    @Override
    public void clear() {
        head.next = null;
        head = null;
        tail.prev = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(T value) {
        int index = 0;
        while (index != size) {
            Node<T> currentNode = getNode(index);
            if (Objects.equals(currentNode.value, value)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        int index = size - 1;
        while (index != 0) {
            Node<T> currentNode = getNode(index);
            if (Objects.equals(currentNode.value, value)) {
                return index;
            }
            index--;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (T value : this) {
            stringJoiner.add(value.toString());
        }
        return stringJoiner.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }

        @Override
        public void remove() {
        }
    }

    private static class Node<T> {

        private T value;
        private Node<T> next;
        private Node<T> prev;

        public Node(T value) {
            this.value = value;
        }

    }

    private Node<T> getNode(int index) {
        Node<T> currentNode;
        if (index <= size / 2) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }
}
