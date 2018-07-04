package ru.job4j.lafore.iterator;

public class ListIterator {

    private Link current;
    private Link previous;
    private LinkList myList;

    public ListIterator(LinkList list) {
        this.myList = list;
        reset();
    }

    public void reset() {
        this.current = myList.getFirst();
        this.previous = null;
    }

    public boolean atEnd() {
        return (current.getNext() == null);
    }

    public void nextLink() {
        previous = current;
        current = current.getNext();
    }

    public Link getCurrent() {
        return this.current;
    }

    public void insertAfter(int i) {
        Link newLink = new Link(i);
        if (myList.isEmpty()) {
            myList.setFirst(newLink);
            current = newLink;
        } else {
            newLink.setNext(current.getNext());
            current.setNext(newLink);
            nextLink();
        }
    }

    public int deleteCurrent() {
        int data = current.getData();
        if (previous == null) {
            myList.setFirst(current.getNext());
            reset();
        } else {
            previous.setNext(current.getNext());
            if (atEnd()) {
                reset();
            } else {
                current = current.getNext();
            }
        }
        return data;
    }
}
