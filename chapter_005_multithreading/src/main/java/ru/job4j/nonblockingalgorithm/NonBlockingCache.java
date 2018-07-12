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

   /* BiFunction<E e, T t, U u> b = new BiFunction() {
        @Override
        public Object apply(Object o, Object o2) {
            if (!o.equals(o2)) {
                throw new OptimisticException();
            };
        }
    };*/

    public void add(Base model) { }
    public void update(Base model) { }
    public void delete(Base model) { }
}
