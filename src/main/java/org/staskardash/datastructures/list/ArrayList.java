package org.staskardash.datastructures.list;

public class ArrayList implements List{
    private Object[] array;
    private int size;

    ArrayList() {
    array = new Object[5];
    }

    @Override
    public void add(Object value) {

    }

    @Override
    public void add(Object value, int index) {

    }
 
    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(Object value, int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object value) {
        return 0;
    }
}
