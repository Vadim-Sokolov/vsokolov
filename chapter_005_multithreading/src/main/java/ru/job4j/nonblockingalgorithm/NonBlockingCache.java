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

    BiFunction<Base, Base, Base> b = new BiFunction<Base, Base, Base>() {
        @Override
        public Base apply(Base o, Base o2) {
            if (!o.equals(o2)) {
                throw new OptimisticException();
            }
            return null;
        }
    };

    public void add(Base model) { }
    public void update(Base model) { }
    public void delete(Base model) { }
}
