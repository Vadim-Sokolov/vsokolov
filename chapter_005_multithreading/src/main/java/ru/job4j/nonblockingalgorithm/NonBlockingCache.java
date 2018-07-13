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

    public synchronized void add(Base model) {
        if (cache.contains(model.getId())) {
            model.setVersion(model.getVersion() + 1);
        }
        cache.put(model.getId(), model);
    }

    public synchronized void update(Base model) {
        if (cache.contains(model.getId())) {
            Base target = cache.get(model.getId());
            target.setName(model.getName());
            target.setVersion(target.getVersion() + 1);
        }
    }
    public synchronized void delete(Base model) {
        if (cache.contains(model.getId())) {
            cache.remove(model.getId());
        }
    }






    BiFunction<Base, Base, Base> b = new BiFunction<Base, Base, Base>() {
        @Override
        public Base apply(Base o, Base o2) {
            if (!o.equals(o2)) {
                throw new OptimisticException();
            }
            return null;
        }
    };
}
