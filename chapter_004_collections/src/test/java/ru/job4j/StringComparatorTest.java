package ru.job4j;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StringComparatorTest {

    StringComparator sc = new StringComparator();

    @Test
    public void sameCharsTest() {
        assertThat(sc.sameChars("mama", "amam"), is(true));
        assertThat(sc.sameChars("deed", "amam"), is(false));
    }
}