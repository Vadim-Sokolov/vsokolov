package ru.job4j.generics;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class RoleStore extends AbstractStore {

    SimpleArray<Role> roles;

    @Override
    public void add(Base model) {
        roles.add((Role) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        roles.set(Integer.parseInt(id), (Role) model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        roles.delete(Integer.parseInt(id));
        return true;
    }

    @Override
    public Base findById(String id) {
        return roles.get(Integer.parseInt(id));
    }
}
