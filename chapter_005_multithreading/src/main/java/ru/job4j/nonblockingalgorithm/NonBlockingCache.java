package ru.job4j.nonblockingalgorithm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;
/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class NonBlockingCache {

    private ConcurrentHashMap<Integer, Base> cache = new ConcurrentHashMap<>();

    BiFunction b = new BiFunction() {
        @Override
        public Object apply(Object o, Object o2) {
            return null;
        }
    };

    public void add(Base model) { }
    public void update(Base model) { }
    public void delete(Base model) { }
}
