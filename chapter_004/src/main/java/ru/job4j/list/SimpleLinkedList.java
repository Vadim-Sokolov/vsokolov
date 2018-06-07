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

    /**
     * Method checks whether the list has a loop
     * using Floyd algorithm.
     */
    public boolean hasLoop() {
        boolean result = false;
        Node<E> turtouse = this.first;
        Node<E> hare = this.first;

        while (hare != null && hare.next != null) {
            turtouse = turtouse.next;
            hare = hare.next.next;
            if (turtouse == hare) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Method adds an entry to the beginning of list.
     *
     * @param value
     */
    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Method deletes entry in the list by index.
     *
     * @param index
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
     * Method deletes entry in the list by value.
     *
     * @param e
     */
    public void deleteByValue(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(getNode(i).getValue())) {
                deleteByIndex(i);
                break;
            }
        }
    }

    /**
     * Method returns element from list by index.
     *
     * @param index
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
     *
     * @param index
     */
    public Node<E> getNode(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    /**
     * Method checks whether the list contains a given element.
     *
     * @param e
     */
    public boolean contains(E e) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (e.equals(getNode(i).getValue())) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Method checks whether the list contains a given element.
     *
     * @param index
     */
    public boolean hasNext(int index) {
        return this.getNode(index).next != null;
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
