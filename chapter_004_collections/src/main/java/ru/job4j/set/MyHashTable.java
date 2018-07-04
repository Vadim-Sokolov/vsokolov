package ru.job4j.set;

import ru.job4j.list.SimpleLinkedList;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class MyHashTable<E> {

    private SimpleLinkedList<E>[] buckets;
    private final int size;

    public MyHashTable(final int size) {
        this.buckets = new SimpleLinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new SimpleLinkedList<>();
        }
        this.size = size;
    }

    /**
     * Method adds an entry to the beginning of list.
     * @param e
     */
    public void add(E e) {
        SimpleLinkedList target = this.buckets[getIndex(e)];
        if (!target.contains(e)) {
            target.add(e);
        }
    }

    /**
     * Method checks whether the list contains a given element.
     * @param e
     */
    public boolean contains(E e) {
        return this.buckets[getIndex(e)].contains(e);
    }

    /**
     * Method deletes a given element from the table.
     * @param e
     */
    public void remove(E e) {
        this.buckets[getIndex(e)].deleteByValue(e);
    }

    public int getIndex(E e) {
        return e.hashCode() % size;
    }

    public int getSize() {
        return this.size;
    }
}
