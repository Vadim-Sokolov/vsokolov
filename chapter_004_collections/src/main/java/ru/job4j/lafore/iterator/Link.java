package ru.job4j.lafore.iterator;

public class Link {

    private int data;
    private Link next;

    public Link(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link n) {
        this.next = n;
    }
}
