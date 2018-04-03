package ru.job4j.board;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class BishopTest {

    private final Cell start = new Cell(1, 1);
    private final Cell dest = new Cell(2, 2);
    private final Bishop bish = new Bishop(start);

    @Test
    public void wayTest() throws ImpossibleMoveException {
        assertThat(bish.way(start, dest)[0].getX(), is(2));
    }

    @Test
    public void isMovePossibleTest() {
        assertThat(bish.isMovePossible(start, dest), is(true));
    }
}