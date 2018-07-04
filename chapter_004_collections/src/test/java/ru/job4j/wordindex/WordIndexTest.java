package ru.job4j.wordindex;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class WordIndexTest {

    private WordIndex ww = new WordIndex();

    @Before
    public void setUp() throws IOException {
        ww.loadFile("d:/ba.txt");
    }

    @Test
    public void insertTest() {
    }

    @Test
    public void findTest() {
        assertThat(ww.find("reasonable"), is(true));
        assertThat(ww.find("spelunker"), is(false));
    }

    @Test
    public void loadFileTest() {
        assertThat(ww.getIndicesForWord("Consulted").contains(0), is(true));
        assertThat(ww.getIndicesForWord("Consulted").size(), is(1));
        assertThat(ww.getIndicesForWord("eagerness").size(), is(3));
        assertThat(ww.getIndicesForWord("eagerness").contains(2), is(true));
    }

    @Test
    public void getIndicesForWordTest() {
        for (Integer i : ww.getIndicesForWord("eagerness")) {
            System.out.println(i);
        }
    }
}