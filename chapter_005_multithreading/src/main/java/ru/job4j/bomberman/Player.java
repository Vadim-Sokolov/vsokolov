package ru.job4j.bomberman;

public class Player extends Thread {

    private Cell current;

    public Cell getCurrent() {
        return current;
    }

    public void setCurrent(Cell current) {
        this.current = current;
    }
}
