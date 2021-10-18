package com.study.datastructures.map;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class HashMap implements Map {
    List[] buckets = {new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList()};
    int size;


    @Override
    public Object put(Object key, Object value) {


        Entry entry = new Entry(key, value);
        int index = indexOfBuckets(key);


        if (this.getEntry(key) != null) {
            this.getEntry(key).setValue(value);
        } else {
            entry.setHashCode(key.hashCode());
            buckets[index].add(entry);
        }
        return entry;
    }


    @Override
    public Object get(Object key) {
        return getEntry(key).getValue();
    }

    @Override
    public int size() {
        int size = 0;
        for (List list : buckets) {
            size += list.size();
        }
        return size;
    }

    @Override
    public boolean containsKey(Object key) {

        if (this.getEntry(key) != null) {
            return true;
        }
        return false;
    }

    @Override
    public Object remove(Object key) {
        if (this.getEntry(key) != null){
            int indexInBucket = indexOfBuckets(key);
            int indexInArray = 0;
            for (int i = 0; i < buckets[indexInBucket].size(); i++) {
                if(((Entry)(buckets[indexInBucket].get(i))).getKey().equals(key)){
                    indexInArray = i;
                }
            }
            return buckets[indexInBucket].remove(indexInArray);
        }
        return null;
    }

    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (int i = 0; i < buckets.length; i++) {
            for (Object o : buckets[i]) {
                stringJoiner.add(((Entry) o).toString());
            }
        }
        return stringJoiner.toString();
    }

    private int indexOfBuckets(Object key) {
        return key.hashCode() % buckets.length;
    }

    private Entry getEntry(Object key) {
        int index = indexOfBuckets(key);
        int hash = key.hashCode();

        if (buckets[index].isEmpty()) {
            return null;
        } else {
            for (Object o : buckets[index]) {
                if (((Entry) o).getHashCode() == hash) {
                    if (((Entry) o).getKey().equals(key)) {
                        return ((Entry) o);
                    }
                }

            }
        }
        return null;
    }

    private class Entry {
        private int hashCode;
        private Object key;
        private Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public int getHashCode() {
            return hashCode;
        }

        public void setHashCode(int hashCode) {
            this.hashCode = hashCode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Entry)) return false;
            Entry entry = (Entry) o;
            return getKey().equals(entry.getKey()) &&
                    getValue().equals(entry.getValue());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getKey());
        }

        @Override
        public String toString() {
            return key +
                    "=" + value;
        }
    }

}
