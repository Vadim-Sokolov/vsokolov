package ru.job4j.map;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class MyHashMap<K, V> implements Iterable {

    private Hashtable data;

    public MyHashMap(Hashtable data) {
        this.data = data;
    }
    /**
     * Method inserts a new pair Key-Value into the map.
     * If Key already exists returns "false".
     * @param key
     * @param value
     * @return
     */
    public void insert(K key, V value) {
        data.put(key, value);
    }

    /**
     * Method returns Value by Key.
     * @param key
     * @return
     */
    public V get(K key) {
        return (V) data.get(key);
    }

    /**
     * Method deletes value by key.
     * @param key
     * @return
     */
    public void delete(K key) {
        data.remove(key);
    }

    @Override
    public Iterator iterator() {
        Set keys = this.data.keySet();
        return keys.iterator();
    }
}
