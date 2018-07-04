package ru.job4j.list;

import ru.job4j.list.SimpleLinkedList;
import ru.job4j.list.SimpleLinkedList.Node;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Container<E> implements Iterable<E> {

    private SimpleLinkedList<E> node;
    private int size = 0;
    private int modCount = 0;
    private int expectedModCount;

    public Container(SimpleLinkedList<E> node) {
        this.node = node;
    }

    public void add(E value) {
        node.add(value);
    }

    public E get(int index) {
        return node.get(index);
    }

    public int getSize() {
        return node.getSize();
    }

    public void deleteByIndex(int index) {
        node.deleteByIndex(index);
    }

    @Override
    public Iterator<E> iterator() throws ConcurrentModificationException {
        if (expectedModCount != modCount) {
            throw new ConcurrentModificationException();
        }
        return new Iterator<E>() {

            Node current = node.getNode(0);

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    E value = (E) current.getValue();
                    current = current.next;
                    return value;
                }
                return null;
            }
        };
    }
}
