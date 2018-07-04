package ru.job4j.list;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class DynamicListTest {

    private DynamicList<Integer> list;

    @Before
    public void beforeTest() {
        list = new DynamicList<>(3);
        list.add(25);
        list.add(26);
        list.add(27);
    }
    @Test
    public void increaseSizeTest() {
        list.add(100);
        assertThat(list.getSize(), is(6));
    }

    @Test
    public void addTest() {
        list.add(100);
        assertThat(list.get(3), is(100));
    }

    @Test
    public void getTest() {
        assertThat(list.get(1), is(26));
    }
}