package com.study.datastructures.list;


import java.util.Arrays;
import java.util.StringJoiner;

public class ArrayList implements List {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] array;
    private int size;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        this.array = new Object[capacity];
    }

    public void add(Object value) {
        this.add(value, size);
    }

    public void add(Object value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index should be between '0' and " + size + " (including)");
        }
        if (size == array.length) {
            Object[] arrayCopy = new Object[array.length + array.length / 2];
            System.arraycopy(array, 0, arrayCopy, 0, size);
            array = arrayCopy;
        }
        Object[] arrayCopy = new Object[array.length];
        System.arraycopy(array, 0, arrayCopy, 0, index);
        arrayCopy[index] = value;
        System.arraycopy(array, index, arrayCopy, index + 1, size - index);
        array = arrayCopy;
        size++;
    }

    public Object remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index should be between '0' and " + size + " (including)");
        }
        Object result = array[index];
        Object[] arrayCopy = new Object[array.length-1];
        if (index == 0) {
            System.arraycopy(array, 1, arrayCopy, 0, size - 1);
            array = arrayCopy;
        } else if (index == size - 1) {
            System.arraycopy(array, 1, arrayCopy, 0, size - 2);
            array = arrayCopy;
        } else {
            System.arraycopy(array, 0, arrayCopy, 0, index);
            System.arraycopy(array, index + 1, arrayCopy, index, size - index);
            array = arrayCopy;
        }
        size--;
        return result;
    }

    public Object get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index should be between '0' and " + size + " (including)");
        }
        return array[index];
    }

    public Object set(Object value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index should be between '0' and " + size + " (including)");
        }
        Object result = array[index];
        array[index] = value;
        return result;
    }

    public void clear() {
        array = new Object[size];
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public boolean contains(Object value) {
        boolean isContains = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == (value)) {
                isContains = true;
            }
        }
        return isContains;
    }

    public int indexOf(Object value) {
        if (value == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        if (value == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        }
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                index = i;
            }
        }
        return index;
    }

    public String toString() {

        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            stringJoiner.add(String.valueOf(array[i]));
        }
        return stringJoiner.toString();
    }
}
