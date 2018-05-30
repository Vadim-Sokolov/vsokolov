package ru.job4j.set;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class SimpleSetTest {

    private SimpleSet<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleSet<>();
        list.add(25);
        list.add(26);
        list.add(27);
    }

    @Test
    public void addTest() {
        list.add(200);
        assertThat(list.getSize(), is(6));
        assertThat(list.get(3), is(200));
    }

    @Test
    public void containsTest() {
        list.add(200);
        assertThat(list.contains(200), is(true));
        assertThat(list.contains(300), is(false));
    }
}