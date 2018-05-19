package ru.job4j.iterators;

import java.util.*;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            private Iterator<Integer> current;
            private Iterator<Iterator<Integer>> cursor = it;

            @Override
            public boolean hasNext() {
                return cursor.hasNext();
            }

            @Override
            public Integer next() throws NoSuchElementException {
                int result = -1;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    current = cursor.next();
                    if (current.hasNext()) {
                        result = current.next();
                    } else {
                       current = cursor.next();
                    }
                }
                return result;
            }
        };
    }
}