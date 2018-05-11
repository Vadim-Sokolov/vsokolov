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
        if (index < ints.length) {
            for (int i = index; i < ints.length; i++) {
                if (ints[i] % 2 == 0) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if (hasNext() == false) {
            throw new NoSuchElementException();
        }
        int target = -1;
        for (int i = index; i < ints.length; i++) {
            if (ints[i] % 2 == 0) {
                target = i;
                break;
            }
        }
        index = target + 1;
        return ints[target];
    }
}
