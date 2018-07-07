package ru.job4j.userstore;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class StoreTest {

    Store st = new Store();
    List<Store.User> previous = new ArrayList<>();
    List<Store.User> current = new ArrayList<>();

    @Before
    public void setUp() {
        previous.add(new Store.User(0, "aaa"));
        previous.add(new Store.User(1, "bbb"));
        previous.add(new Store.User(2, "ccc"));

        current.add(new Store.User(0, "ddd"));
        current.add(new Store.User(3, "eee"));

    }

    @Test
    public void getChangesTest() {
        HashMap result = st.getChanges(previous, current);
        assertThat(result.get("New Users:"), is(1));
        assertThat(result.get("Changed Users:"), is(1));
        assertThat(result.get("Deleted Users:"), is(2));
    }
}