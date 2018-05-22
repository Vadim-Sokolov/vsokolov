package ru.job4j.iterators;

import java.util.*;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> its) {
        return new Iterator<Integer>() {

            Iterator<Integer> current;

            @Override
            public boolean hasNext() {
                if (its.hasNext()) {
                    current = its.next();
                }
                return (its.hasNext());
            }

            @Override
            public Integer next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return -1;
            }
        };
    }
}