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
public class SimpleLinkedListTest {

    private SimpleLinkedList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleLinkedList<>();
        list.add(100);
        list.add(200);
        list.add(300);
    }

    @Test
    public void whenAddThreeElementsThenSecondElementIsTwo() {
        assertThat(list.get(1), is(200));
    }

    @Test
    public void whenAddThreeElementsThenGetSizeReturnsThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDeleteFirstElementThenFirstElementIsTwo() {
        list.delete();
        assertThat(list.get(0), is(200));
    }

    @Test
    public void whenDeleteSecondElementThenSecondElementIsThree() {
        list.deleteByIndex(1);
        assertThat(list.get(1), is(100));
        assertThat(list.getSize(), is(2));
    }
}