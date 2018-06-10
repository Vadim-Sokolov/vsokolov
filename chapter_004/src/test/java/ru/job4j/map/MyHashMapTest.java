package ru.job4j.map;

import org.junit.Test;
import org.junit.Before;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class MyHashMapTest {

    private MyHashMap<User, Integer> map;
    private User first = new User("aaa", 1, new GregorianCalendar(2000, 10, 23));

    @Before
    public void beforeTest() {
        map = new MyHashMap<>(new Hashtable());
        map.insert(first, 100);
        map.insert(new User("bbb", 2, new GregorianCalendar(1990, 11, 24)), 200);
        map.insert(new User("ccc", 3, new GregorianCalendar(1980, 12, 25)), 300);
    }
    @Test
    public void insertTest() {
        User test = new User("aaa", 1, new GregorianCalendar(2000, 10, 23));
        map.insert(test, 400);
        assertThat(map.get(first), is(400));
    }

    @Test
    public void getTest() {
        assertThat(map.get(first), is(100));
    }

    @Test
    public void deleteTest() {
        map.delete(first);
        assertThat(map.get(first), is((Integer) null));
    }
}