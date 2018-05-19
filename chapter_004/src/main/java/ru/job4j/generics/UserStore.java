package ru.job4j.generics;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class UserStore extends AbstractStore<User> {
    public UserStore(SimpleArray<User> t) {
        super(t);
    }
}
