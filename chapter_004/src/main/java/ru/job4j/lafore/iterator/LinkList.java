package ru.job4j.lafore.iterator;

public class LinkList {

    private Link first;

    public LinkList() {
        this.first = null;
    }

    public Link getFirst() {
        return first;
    }

    public void setFirst(Link f) {
        this.first = f;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public ListIterator getIterator() {
        return new ListIterator(this);
    }
}
