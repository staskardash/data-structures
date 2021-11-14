package org.staskardash.datastructures.list;

public class ArrayList implements List{
    private Object[] array;
    private int size;

    ArrayList() {
    array = new Object[10];
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
            for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public void add(Object value, int index) {
        ensureCapacity();
        for (int i = 0; i < size; i++) {
            if (i == index) {
                for (int y = size - 1; y >= i; y--) {
                    array[y+1] = array[y];
                }
                array[index] = value;
            }
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        if (isEmpty()) {
            throw new IllegalStateException ("IndexOutOfBoundsException!!!");
        }
        Object result = array[index];
        for(int i = 0; i < size; i++) {
            if (i == index) {
                array[i] = null;
                for (int y = i; y < size; y++) {
                    array[y] = array[y + 1];
                }
            }
        }
        size--;
        return result;
    }

    @Override
    public Object get(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("IndexOutOfBoundsException!!!");
        }
        Object result = array[index];
        for(int i = 0; i < size; i++) {
            if (i == index){
                array[i] = null;
            }
        }
        size--;
        return result;
    }

    @Override
    public Object set(Object value, int index) {
        if (isEmpty()) {
            throw new IllegalStateException("IndexOutOfBoundException!!!");
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
        for (int i = 0; i < size; i++){
            if (array[i] == value){
                return true;
            }
        }
        return false;
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
}

