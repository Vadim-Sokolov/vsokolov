package ru.job4j.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Converter {

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        ArrayList target = new ArrayList();
        while (it.hasNext()) {
            Iterator<Integer> temp = it.next();
            while (temp.hasNext()) {
                target.add(temp.next());
            }
        }
        return target.iterator();
    }
}
