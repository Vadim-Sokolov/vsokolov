package ru.job4j.generics;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class UserStore extends AbstractStore {

    SimpleArray<User> users;

    @Override
    public void add(Base model) {
        users.add((User) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        users.set(Integer.parseInt(id), (User) model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        users.delete(Integer.parseInt(id));
        return true;
    }

    @Override
    public Base findById(String id) {
        return users.get(Integer.parseInt(id));
    }
}
