package com.study.datastructures.map;

public interface Map{
    Object put(Object key, Object value);

    Object get(Object key);

    int size();

    boolean containsKey(Object key);

    Object remove(Object key);

    String toString();

    int getCapacity();

}
