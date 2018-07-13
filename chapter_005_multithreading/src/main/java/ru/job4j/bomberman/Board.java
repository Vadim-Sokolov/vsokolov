package ru.job4j.bomberman;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Board {

    private Cell[][] board;
    private final int size;
    private Player player;

    public Board(int size) {
        this.size = size;
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                board[column][row] = new Cell(column, row);
            }
        }
    }

    public boolean move(Cell source, Cell dest) throws InterruptedException {
        boolean result = true;
        if (dest.lock.tryLock(500L, TimeUnit.MILLISECONDS)) {
                player.setCurrent(dest);
                source.lock.unlock();
            } else {
                result = false;
            }
        return result;
    }
}
