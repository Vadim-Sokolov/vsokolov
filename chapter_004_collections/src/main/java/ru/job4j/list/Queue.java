package ru.job4j.list;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Queue<E> {

    private Container<E> container;

    public Queue(Container<E> container) {
        this.container = container;
    }

    public E poll() {
        int target = container.getSize() - 1;
        E result = container.get(target);
        container.deleteByIndex(target);
        return result;
    }

    public void push(E value) {
        container.add(value);
    }

    public E peek() {
        return container.get(0);
    }

    public E peekByIndex(int index) {
        return container.get(index);
    }

    public int getSize() {
        return container.getSize();
    }
}
