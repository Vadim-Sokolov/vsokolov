package ru.job4j.map;

import ru.job4j.list.SimpleLinkedList;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class MyHashMap<K, V> implements Iterable {

    private int size = 3;
    private int index = 0;
    private Entry<K, V>[] buckets = new Entry[size];

    /**
     * Method inserts a new pair Key-Value into the map.
     * If Key already exists returns "false".
     * @param key
     * @param value
     * @return boolean
     */
    public boolean insert(K key, V value) {
        if (this.index == size - 2) {
            mapGrow();
        }
        boolean result = true;
        int target = findBucket(key);
        Entry<K, V> toAdd = new Entry<>(key, value);
        if (buckets[target] == null) {
            buckets[target] = toAdd;
            index++;
        } else {
            result = false;
        }
        return result;
    }

    /**
     * Method returns Value by Key.
     * @param key
     * @return V
     */
    public V get(K key) {
        V result;
        int target = findBucket(key);
        if (buckets[target] == null) {
            result = null;
        } else {
            result = buckets[target].getValue();
        }
        return result;
    }

    /**
     * Method deletes value by key.
     * @param key
     * @return boolean
     */
    public boolean delete(K key) {
        boolean result = true;
        int target = findBucket(key);
        if (buckets[target] == null) {
            result = false;
        } else {
            buckets[target] = null;
            index--;
        }
        return result;
    }

    public int findBucket(K key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public void mapGrow() {
        int target = size;
        size *= 2;
        Entry<K, V>[] temp = new Entry[size];
        for (int i = 0; i < target; i++) {
            temp[i] = buckets[i];
        }
        buckets = temp;
    }

    public int getSize() {
        return this.size;
    }

    public class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }
    }

    @Override
    public Iterator iterator() {
        Set keys = new HashSet();
        for (int i = 0; i < buckets.length; i++) {
            keys.add(buckets[i].getKey());
        }
        return keys.iterator();
    }
}
