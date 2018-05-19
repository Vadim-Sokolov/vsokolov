package ru.job4j.generics;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class AbstractStoreTest {

    private SimpleArray<User> list;
    private UserStore us;

    @Before
    public void beforeTest() {
        list = new SimpleArray<>(10);
        us = new UserStore(list);
        us.add(new User("one"));
        us.add(new User("two"));
        us.add(new User("three"));
    }
    @Test
    public void addTest() {
        User target = new User("four");
        us.add(target);
        assertThat(list.get(3), is(target));
    }

    @Test
    public void replaceTest() {
        User target = new User("four");
        us.replace("three", target);
        assertThat(list.get(2), is(target));
    }

    @Test (expected = NullPointerException.class)
    public void deleteTest() {
        us.delete("two");
        list.get(1);
    }

    @Test
    public void findByIdTest() {
        assertThat(us.findById("two"), is(list.get(1)));
    }

    @Test
    public void getIndexTest() {
        assertThat(us.getIndex("two"), is(1));
    }
}