package ru.job4j.board;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class BoardTest {

    @Test
    public void addTest() {
        Board board = new Board();
        Cell cell = new Cell(1, 2);
        Bishop bishop = new Bishop(cell);
        board.add(bishop);
        assertThat(board.getFigures()[0], is(bishop));
    }

    @Test
    public void moveTest() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(1, 2);
        Cell dest = new Cell(4, 5);
        Bishop bishop = new Bishop(source);
        board.add(bishop);
        assertThat(board.move(source, dest), is(true));
    }

    @Test
    public void isPathClear() {
        Board board = new Board();
        Cell[] cells = {new Cell(1, 2), new Cell(2, 3), new Cell(3, 4)};
        assertThat(board.isPathClear(cells), is(true));
    }

    @Test
    public void getFigure() {
        Board board = new Board();
        Cell source = new Cell(1,2);
        Bishop bishop = new Bishop(source);
        board.add(bishop);
        assertThat(board.getFigure(source), is(bishop));
    }
}