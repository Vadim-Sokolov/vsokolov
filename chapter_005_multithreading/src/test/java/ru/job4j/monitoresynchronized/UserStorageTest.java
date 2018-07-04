package ru.job4j.monitoresynchronized;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * @author vsokolov
 * @version $iD$
 * @since 0.1
 */
public class UserStorageTest {

    private UserStorage us = new UserStorage();
    private User u1 = new User(0, 100);

    @Before
    public void setUp() throws Exception {
        us.add(u1);
        us.add(new User(1, 300));
        us.add(new User(2, 500));
    }

   @Test
    public void addTest() {
        us.add(new User(2, 0));
        us.add(new User(3, 0));
        assertThat(us.getUserById(2).getAmount(), is(500));
        assertThat(us.getUserById(3).getAmount(), is(0));
    }

    @Test
    public void updateTest() {
        User u2 = new User(0, 400);
        us.update(u2);
        assertThat(us.getUserById(0).getAmount(), is(400));
    }

    @Test
    public void deleteTest() {
        us.delete(u1);
        assertThat(us.getUserById(0), is(Matchers.nullValue()));
    }

    @Test
    public void transferTest() {
        us.transfer(2, 1, 500);
        assertThat(us.getUserById(1).getAmount(), is(800));
        assertThat(us.getUserById(2).getAmount(), is(0));
    }
}