package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.sql.Connection;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author vsokolov
 * @version $iD$
 * @since 0.1
 */
public class TrackerTest {

    File file = new File("d:/ba.txt");
    ConnectionManager cm = new ConnectionManager(file);
    Connection conn = cm.getConnection();
    Tracker tr = new Tracker(conn);
    Item i = new Item("Alice", "Acquisition");
    Item j = new Item("Bart", "Banking");

    @Test
    public void add() {
        //tr.add(i);
        assertThat(tr.findById(1).getName(), is("Alice"));
    }

    @Test
    public void replace() {
        //tr.replace(j, 2);
        assertThat(tr.findById(2).getName(), is("Bart"));
    }

    @Test
    public void delete() {
        //tr.delete(3);
        assertThat(tr.findById(3).getName(), is("not found"));
    }

    @Test
    public void findAll() {
        List<Item> result = tr.findAll();
        assertThat(result.size(), is(3));
    }

    @Test
    public void findByName() {
        List<Item> result = tr.findByName("Alice");
        assertThat(result.size(), is(2));
    }

    @Test
    public void findById() {
        Item result = tr.findById(4);
        assertThat(result.getName(), is("Alice"));
    }
}