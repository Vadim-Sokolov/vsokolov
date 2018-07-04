package ru.job4j.set;

import org.junit.Test;
import org.junit.Before;
import ru.job4j.list.SimpleLinkedList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */public class LinkedSetTest {

    private LinkedSet<String> set;

    @Before
    public void beforeTest() {
        set = new LinkedSet<>(new SimpleLinkedList<>());
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
    }
    @Test
    public void addTest() {
        set.add("ddd");
        assertThat(set.getData().contains("ddd"), is(true));
        assertThat(set.getSize(), is(4));
    }

    @Test
    public void addDuplicateTest() {
        set.add("ccc");
        assertThat(set.getData().contains("ccc"), is(true));
        assertThat(set.getData().contains("bbb"), is(true));
        assertThat(set.getData().contains("aaa"), is(true));
        assertThat(set.getSize(), is(3));
    }
}