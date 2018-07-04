package ru.job4j.set;

import ru.job4j.list.SimpleLinkedList;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class LinkedSet<E> implements Iterable<E> {

    private SimpleLinkedList<E> data;
    private int size;

    public LinkedSet(SimpleLinkedList<E> data) {
        this.data = data;
    }

    /**
     * Method checks whether the Set contains a given element and
     * if not - adds the element.
     */
    public void add(E e) {
        if (!data.contains(e)) {
            data.add(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return this.data.iterator();
    }

    public int getSize() {
        return data.getSize();
    }

    public SimpleLinkedList<E> getData() {
        return this.data;
    }
}
