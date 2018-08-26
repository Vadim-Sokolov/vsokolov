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
        this.board = new Cell[size][size];
        this.size = size;
        for (int row = 0; row < this.size; row++) {
            for (int column = 0; column < this.size; column++) {
                this.board[column][row] = new Cell(column, row);
            }
        }
        this.player = new Player(board[1][1]);
    }

    public boolean move(Cell source, Cell dest) throws InterruptedException {
        boolean result = false;
        if (dest.lock.tryLock(500L, TimeUnit.MILLISECONDS)) {
                player.setCurrent(dest);
                source.lock.unlock();
                result = true;
            }
        return result;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Cell getCell(int column, int row) {
        return board[column][row];
    }

    public int getSize() {
        return  this.size;
    }
}