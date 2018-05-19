package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class SimpleArray<T> implements  Iterable<T> {

    Object[] objects;
    int index = 0;

    public SimpleArray(int length) {
        this.objects = new Object[length];
    }

    public void add(T model) throws ArrayIndexOutOfBoundsException {
        if (index >= objects.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.objects[index++] = model;
    }

    public void set(int index, T model) {
        this.objects[index] = model;
    }

    public void delete(int index) {
        this.objects[index] = null;
    }

    public T get(int position) throws NullPointerException {
        if ((T) this.objects[position] == null) {
            throw new NullPointerException();
        } else {
            return (T) this.objects[position];
        }
    }

    public int getLength() {
        return objects.length;
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) Arrays.asList(objects).iterator();
    }
}
