package ru.job4j.bomberman;

import java.util.concurrent.TimeUnit;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Player extends Thread {

    private Cell current;

    public Player(Cell start) {
        this.current = start;
    }

    public Cell getCurrent() {
        return current;
    }

    public void setCurrent(Cell current) {
        this.current = current;
    }

    public void run() {
        while (true){
            try {
                move(current, getDest(1, 0));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move(Cell start, Cell dest) throws InterruptedException {
        if (dest.lock.tryLock(500L, TimeUnit.MILLISECONDS)) {
            this.setCurrent(dest);
            start.lock.unlock();
        }
    }

    public Cell getDest(int directionX, int directionY) {
        int destC = this.current.getColumn() + directionY;
        int destR = this.current.getRow() + directionX;
        return new Cell(destC, destR);
    }
}
