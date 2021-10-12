package com.study.datastructures.list;

public class LinkedList implements List {

    private Node[] array;

    private Node head;
    private Node tail;
    private int size;



    public LinkedList(int capacity) {
        this.array = new Node[capacity];
    }


    public void add(Object value) {
        if (size == 0) {
            head = tail = new Node(value);
            array[0] = head;
        } else {
            if (size == array.length) {
                Node[] arrayCopy = new Node[array.length + array.length / 2];
                System.arraycopy(array, 0, arrayCopy, 0, size);
                array = arrayCopy;
            }
            tail.setValue(value);
            tail.setPrev(array[size - 1]);
            tail.setNext(array[size + 1]);
        }
        size++;
    }


    public void add(Object value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index should be between '0' and " + size + " (including)");
        }
        if (size == 0) {
            head = tail = new Node(value);
            array[0] = head;
            size++;
        } else {
            if (size == array.length) {
                Node[] arrayCopy = new Node[array.length + array.length / 2];
                System.arraycopy(array, 0, arrayCopy, 0, size);
                array = arrayCopy;
            }
//            array[index].value = value;
//            array[index].prev = array[size - 1];
//            array[index].next = array[size + 1];
        }
    }


    public Object remove(int index) {
        return null;
    }


    public Object get(int index) {
        return null;
    }


    public Object set(Object value, int index) {
        return null;
    }


    public void clear() {

    }


    public int size() {
        return 0;
    }


    public boolean isEmpty() {
        return false;
    }


    public boolean contains(Object value) {
        return false;
    }


    public int indexOf(Object value) {
        return 0;
    }


    public int lastIndexOf(Object value) {
        return 0;
    }
}
