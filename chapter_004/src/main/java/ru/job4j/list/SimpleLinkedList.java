package ru.job4j.list;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class SimpleLinkedList<E> {

    private int size;
    private Node<E> first;

    /**
     * Method adds an entry to the beginning of list.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Method deletes 1st entry in the list.
     */
    public void delete() {
        Node<E> target = this.first;
        this.first = target.next;
    }

    /**
     * Method returns element from list by index.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * Method returns size of list.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Class for storing data.
     */
    private static class Node<E> {
        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }
}
