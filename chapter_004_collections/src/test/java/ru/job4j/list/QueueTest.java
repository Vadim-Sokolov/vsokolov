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
public class QueueTest {

    private Queue<Integer> list;

    @Before
    public void beforeTest() {
        list = new Queue<>(new Container<>(new SimpleLinkedList<>()));
        list.push(100);
        list.push(200);
        list.push(300);
    }

    @Test
    public void pollTest() {
        assertThat(list.getSize(), is(3));
        assertThat(list.poll(), is(100));
        assertThat(list.peekByIndex(1), is(200));
        assertThat(list.getSize(), is(2));
    }

    @Test
    public void pushTest() {
        list.push(400);
        assertThat(list.peek(), is(400));
    }
}