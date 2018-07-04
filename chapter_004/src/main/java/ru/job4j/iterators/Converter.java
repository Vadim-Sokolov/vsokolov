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

            Iterator<Integer> current = its.next();

            @Override
            public boolean hasNext() {
                return current.hasNext() || its.hasNext();
            }

            @Override
            public Integer next() throws NoSuchElementException {
                if (current.hasNext()) {
                    return current.next();
                } else if (its.hasNext()) {
                    current = its.next();
                    return current.next();
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}