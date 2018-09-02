package ru.job4j.bomberman;

import java.util.concurrent.TimeUnit;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Monster extends Thread {

    private Cell current;
    private Board board;
    private Cell previous;

    public Monster(Cell start, Board board) {
        this.current = start;
        this.board = board;
        this.previous = start;
    }

    public Cell getCurrent() {
        return current;
    }

    public void setCurrent(Cell current) {
        this.current = current;
    }

    public void run() {
        while (true) {
            try {
                move(current, getDest());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move(Cell start, Cell dest) throws InterruptedException {
        if (dest.lock.tryLock(5000L, TimeUnit.MILLISECONDS)) {
            this.setCurrent(dest);
            start.lock.unlock();
            this.previous = start;
        } else {
            this.setCurrent(this.previous);
            start.lock.unlock();
        }
    }

    public Cell getDest() {
        int destC;
        int destR;
        Cell player = board.getPlayer().getCurrent();
        if (player.getColumn() < current.getColumn()) {
            destC = current.getColumn() - 1;
        } else if (player.getColumn() > current.getColumn()) {
            destC = current.getColumn() + 1;
        } else {
            destC = current.getColumn();
        }
        if (player.getRow() < current.getRow()) {
            destR = current.getColumn() - 1;
        } else if (player.getRow() > current.getRow()) {
            destR = current.getRow() + 1;
        } else {
            destR = current.getRow();
        }
        return board.getCell(destC, destR);
    }
}
