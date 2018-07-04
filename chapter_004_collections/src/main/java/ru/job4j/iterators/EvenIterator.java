package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class EvenIterator implements Iterator<Integer> {

    private int[] ints;
    private int index = 0;

    public EvenIterator(int[] ints) {
        this.ints = ints;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < ints.length; i++) {
            if (ints[i] % 2 == 0) {
                index = i;
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            return ints[index++];
        }
    }
}
