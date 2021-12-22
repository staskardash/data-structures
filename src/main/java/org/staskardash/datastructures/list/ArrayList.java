package org.staskardash.datastructures.list;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class ArrayList<T> implements List<T>, Iterable<T>{
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private T[] array;
    private int size;

    ArrayList() {
    this(DEFAULT_INITIAL_CAPACITY);
    }

    ArrayList(int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
    }

    @Override
    public void add(T value) {
        add(value, size);
    }

    @Override
    public void add(T value, int index) {
        if (index < 0 | index > size) {
            throw new IndexOutOfBoundsException ("Can't be added to a non-existent array index");
        }
        ensureCapacity();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public T remove(int index) {
        if (index >= size | index < 0 | isEmpty()) {
            throw new IndexOutOfBoundsException ("Can't remove null value!");
        }
        T result = array[index];
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        array[size - 1] = null;
        size--;
        return result;
    }

    @Override
    public T get(int index) {
        if (isEmpty() | index < 0) {
            throw new IndexOutOfBoundsException("Can't get null value!");
        }
        T result = array[index];
        for(int i = 0; i < array.length; i++) {
            if (i == index){
                array[i] = null;
            }
        }
        return result;
    }

    @Override
    public T set(T value, int index) {
        if (index >= size | index < 0 | isEmpty()) {
            throw new IndexOutOfBoundsException("Can't set null value!");
        }
        T result = array[index];
        for (int i = 0; i < size; i++) {
            if (i == index) {
                array[i] = value;
            }
        }
        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
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
        int index;
        for (int i = 0; i < size; i++){
            if (Objects.equals(array[i], value)) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        int index;
        for (int i = size; i >= 0; i--) {
            if (Objects.equals(array[i], value)) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (int i = 0; i < size; i++) {
            stringJoiner.add(array[i].toString());
        }
        return stringJoiner.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private void ensureCapacity() {
        if (array.length == size) {
            T[] newArray = (T[]) new Object[(int) (array.length * 1.5) + 1];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    private class ArrayIterator implements Iterator<T>{
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            T value = array[index];
            index++;
            return value;
        }

        @Override
        public void remove() {

        }
    }
}

