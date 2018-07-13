package ru.job4j.bomberman;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Cell {

    private boolean empty = true;
    public ReentrantLock lock;
    private final int row;
    private final int column;

    public Cell(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}