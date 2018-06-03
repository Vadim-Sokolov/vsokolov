package ru.job4j.set;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class SimpleSet<E> implements Iterable<E> {

    private int size = 3;
    private Object[] o;
    private int index = 0;

    public SimpleSet() {
        this.o = new Object[3];
    }

    /**
     * Method checks whether a given element is contained in the Set.
     * If not, adds the element to the Set.
     * @param e
     */
    public void add(E e) {
        if (size <= index) {
            int target = size;
            size *= 2;
            Object[] temp = new Object[size];
            for (int i = 0; i < target; i++) {
                temp[i] = o[i];
            }
            o = temp;
        }
        if (!this.contains(e)) {
            this.o[index++] = e;
        }
    }

    public boolean contains(E e) {
        boolean result = false;
        for (int i = 0; i < this.size; i++) {
            if (e.equals(this.get(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    public E get(int index) {
        return (E) o[index];
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && o[currentIndex] != null;
            }

            @Override
            public E next() {
                return (E) o[currentIndex++];
            }
        };
    }
}
