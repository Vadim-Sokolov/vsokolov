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
public class ContainerTest {

    private Container<Integer> list;

    @Before
    public void beforeTest() {
        list = new Container<>(new SimpleLinkedList<>());
        list.add(100);
        list.add(200);
        list.add(300);
    }
    @Test
    public void addTest() {
        list.add(400);
        assertThat(list.getSize(), is(4));
    }

    @Test
    public void getTest() {
        assertThat(list.get(0), is(300));
    }
}