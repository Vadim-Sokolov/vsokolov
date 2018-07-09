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

    public void add(Base model) {
        cache.computeIfAbsent(model.getId(), (Function<? super Integer, ? extends Base>) cache.put(model.getId(), model));
    }
    public void update(Base model) {
        cache.computeIfPresent(model.getId(), (BiFunction<? super Integer, ? super Base, ? extends Base>) cache.put(model.getId(), model));
    }
    public void delete(Base model) {
        cache.computeIfPresent(model.getId(), (BiFunction<? super Integer, ? super Base, ? extends Base>) cache.remove(model.getId()));
    }


}
