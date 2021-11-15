package org.staskardash.datastructures.list;

import java.util.StringJoiner;

public class ArrayList implements List{
    private Object[] array;
    private int size;

    ArrayList() {
    array = new Object[10];
    }

    ArrayList(int initialCapacity) {
        array = new Object[initialCapacity];
    }

    @Override
    public void add(Object value) {
        ensureCapacity();
        array[size] = value;
        size++;
    }

    private void ensureCapacity() {
        if (array.length == size) {
            Object[] newArray = new Object[(int) (array.length * 1.5)];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    @Override
    public void add(Object value, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException ("Can't be added to a non-existent array index");
        }
        ensureCapacity();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public Object remove(int index) {
        if (index >= size || index < 0 || isEmpty()) {
            throw new IndexOutOfBoundsException ("Can't remove null value!");
        }
        Object result = array[index];
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        array[size - 1] = null;
        size--;
        return result;
    }

    @Override
    public Object get(int index) {
        if (isEmpty() || index < 0) {
            throw new IndexOutOfBoundsException("Can't get null value!");
        }
        Object result = array[index];
        for(int i = 0; i < array.length; i++) {
            if (i == index){
                array[i] = null;
            }
        }
        size--;
        return result;
    }

    @Override
    public Object set(Object value, int index) {
        if (index >= size || index < 0 || isEmpty()) {
            throw new IndexOutOfBoundsException("Can't set null value!");
        }
        Object result = array[index];
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
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(Object value) {
        int index;
        for (int i = 0; i < size; i++){
            if (array[i] == value) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        int index;
        for (int i = size; i >= 0; i--) {
            if (array[i] == value) {
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
}

