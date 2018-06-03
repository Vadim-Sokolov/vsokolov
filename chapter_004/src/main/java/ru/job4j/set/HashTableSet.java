package ru.job4j.set;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class HashTableSet<E> {

    private MyHashTable<E> data;

    public HashTableSet(MyHashTable data) {
        this.data = data;
    }

    /**
     * Method adds an entry to the beginning of list.
     * @param e
     */
    public void add(E e) {
        data.add(e);
    }

    /**
     * Method checks whether the list contains a given element.
     * @param e
     */
    public boolean contains(E e) {
        return data.contains(e);
    }

    /**
     * Method deletes a given element from the table.
     * @param e
     */
    public void remove(E e) {
        data.remove(e);
    }
}
