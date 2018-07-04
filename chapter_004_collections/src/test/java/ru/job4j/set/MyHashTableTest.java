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
public class MyHashTableTest {

    private MyHashTable<String> table;

    @Before
    public void beforeTest() {
        table = new MyHashTable<>(3);
        table.add("aaa");
        table.add("bbb");
        table.add("ccc");
    }

    @Test
    public void addTest() {
        table.add("ddd");
        assertThat(table.contains("ddd"), is(true));
    }

    @Test
    public void containsTest() {
        assertThat(table.contains("aaa"), is(true));
        assertThat(table.contains("adaa"), is(false));
    }

    @Test
    public void removeTest() {
        table.remove("bbb");
        assertThat(table.contains("bbb"), is(false));
    }

    @Test
    public void getIndexTest() {
        int target = "aaa".hashCode() % table.getSize();
        assertThat(table.getIndex("aaa"), is(target));
    }
}