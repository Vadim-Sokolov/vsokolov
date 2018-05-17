package ru.job4j.generics;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public abstract class AbstractStore implements Store {

    @Override
    public void add(Base model) {

    }

    @Override
    public boolean replace(String id, Base model) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Base findById(String id) {
        return null;
    }
}
