package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class ArrayIterator implements Iterator<Integer> {

    private int[][] ints;
    private int indexRow = 0;
    private int indexColumn = 0;

    public ArrayIterator(int[][] ints) {
        this.ints = ints;
    }

    @Override
    public boolean hasNext() {
        return indexRow < ints.length;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if (ints.length == 0) {
            throw new NoSuchElementException();
        }
        int result = ints[indexRow][indexColumn++];
        if (indexColumn == ints[indexRow].length) {
            indexRow++;
            indexColumn = 0;
        }
        return result;
    }
}
