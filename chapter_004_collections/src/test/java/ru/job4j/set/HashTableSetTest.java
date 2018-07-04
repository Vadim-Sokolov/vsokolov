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
public class HashTableSetTest {

    private HashTableSet<String> set;

    @Before
    public void beforeTest() {
        set = new HashTableSet<>(new MyHashTable(10));
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
    }

    @Test
    public void addTest() {
        set.add("ddd");
        assertThat(set.contains("ddd"), is(true));
    }

    @Test
    public void containsTest() {
        assertThat(set.contains("aaa"), is(true));
        assertThat(set.contains("dasl"), is(false));
    }

    @Test
    public void removeTest() {
        set.remove("bbb");
        assertThat(set.contains("bbb"), is(false));
    }
}