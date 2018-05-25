package ru.job4j.list;

import ru.job4j.list.SimpleLinkedList;
import ru.job4j.list.SimpleLinkedList.Node;

import java.util.Arrays;
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

    public void delete() {
        node.delete();
    }

    public void deleteByIndex(int index) {
        node.deleteByIndex(index);
    }

    @Override
    public Iterator<E> iterator() {
        int expectedModCount = modCount;
        return (Iterator<E>) Arrays.asList(node).iterator();
    }
}
