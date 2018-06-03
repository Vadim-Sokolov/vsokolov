package ru.job4j.set;

import ru.job4j.list.DynamicList;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class SimpleSet<E> implements Iterable<E> {

    private int size;
    private DynamicList<E> data;
    private int index = 0;

    public SimpleSet() {
        this.data = new DynamicList<>(3);
    }

    /**
     * Method checks whether a given element is contained in the Set.
     * If not, adds the element to the Set.
     * @param e
     */
    public void add(E e) {
        data.add(e);
    }

    public boolean contains(E e) {
        boolean result = false;
        for (int i = 0; i < this.data.getSize(); i++) {
            if (e.equals(this.get(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    public E get(int index) {
        return (E) data.get(index);
    }

    public int getSize() {
        return this.data.getSize();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && data.get(index) != null;
            }

            @Override
            public E next() {
                return (E) data.get(index++);
            }
        };
    }
}
