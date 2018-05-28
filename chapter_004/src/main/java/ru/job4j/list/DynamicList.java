package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class DynamicList<E> implements Iterable<E> {

    private int size;
    private Object[] container;
    private int index = 0;
    private int modCount = 0;

    public DynamicList(int size) {
        this.size = size;
        this.container = new Object[size];
    }

    /**
     * Method increases array size if necessary,
     * and adds given value to the array.
     * @param value
     */
    public void add(E value) {
        if (size <= index) {
            int target = size;
            size *= 2;
            Object[] temp = new Object[size];
            for (int i = 0; i < target; i++) {
                temp[i] = container[i];
            }
            container = temp;
        }
        container[index++] = value;
    }

    public E get(int index) {
        return (E) container[index];
    }

    @Override
    public Iterator<E> iterator() {
        int expectedModCount = modCount;
        return (Iterator<E>) Arrays.asList(container).iterator();
    }

    int getSize() {
        return size;
    }
}
