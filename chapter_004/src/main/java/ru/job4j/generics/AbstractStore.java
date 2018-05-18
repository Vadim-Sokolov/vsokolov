package ru.job4j.generics;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public abstract class AbstractStore<T extends Base> implements Store {

    SimpleArray<T> t;

    @Override
    public void add(Base model) {
        t.add((T) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        t.set(Integer.parseInt(id), (T) model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        t.delete(Integer.parseInt(id));
        return true;
    }

    @Override
    public Base findById(String id) {
        return t.get(Integer.parseInt(id));
    }
}
