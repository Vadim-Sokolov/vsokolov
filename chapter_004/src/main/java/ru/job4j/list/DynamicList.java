package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class DynamicList<E> implements Iterable<E> {

    private int size = 100;
    private Object[] container = new Object[size];
    private int index = 0;
    private int modCount = 0;

    public DynamicList(int size, Object[] container) {
        this.size = size;
        this.container = container;
    }

    public void add(E value) {
        if (index < size) {
            container[index++] = value;
        } else {
            int target = size;
            size *= 2;
            Object[] temp = new Object[size];
            for (int i = 0; i < target; i++) {
                temp[i] = container[i];
            }
            container = temp;
            container[index++] = value;
        }
    }

    public E get(int index) {
        return (E) container[index];
    }

    @Override
    public Iterator<E> iterator() {
        int expectedModCount = modCount;
        return (Iterator<E>) Arrays.asList(container).iterator();
    }

    public int getSize() {
        return size;
    }
}
