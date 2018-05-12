package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class PrimeIterator implements Iterator<Integer> {

    private int[] ints;
    private int index = 0;

    public PrimeIterator(int[] ints) {
        this.ints = ints;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (index < ints.length) {
            if (search() >= 0) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int target = search();
        index = target + 1;
        return ints[target];
    }

    public Integer search() {
        int result = -1;
        for (int i = index; i < ints.length; i++) {
            if (isPrime(ints[i])) {
                result = i;
                break;
            }
        }
        return result;
    }

    private static boolean isPrime(int x) {
        boolean result = true;
        if (x == 0 || x == 1) {
            result = false;
        } else if (x > 2) {
            for (int i = 2; i < x; i++) {
                if (x % i == 0) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
