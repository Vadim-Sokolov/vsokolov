package ru.job4j.list;

import java.util.HashSet;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class SimpleLinkedList<E> {

    private int size = 0;
    private Node<E> first;

    public boolean hasLoop() {
        boolean result = true;
        HashSet<Node> s = new HashSet<Node>();
        if (this.getNode(0) == null) {
            result = false;
        } else {
            for (int i = 0; i < this.getSize(); i++) {
                if (this.getNode(i).next == null) {
                    result = false;
                    break;
                } else if (s.contains(this.getNode(i).next)) {
                    break;
                } else {
                    s.add(this.getNode(i));
                }
            }
        }
        return result;
    }

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
     * Method deletes entry in the list by index.
     */
    public void deleteByIndex(int index) {
        if (index == 0) {
            Node<E> temp = this.first;
            this.first = temp.next;
        } else {
            Node<E> temp = this.getNode(index).next;
            this.getNode(index - 1).next = temp;
        }
        this.size--;
    }

    /**
     * Method returns element from list by index.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.value;
    }

    /**
     * Method returns element from list by index.
     */
    public Node<E> getNode(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
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
    public static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
        }

        E getValue() {
            return this.value;
        }
    }
}
