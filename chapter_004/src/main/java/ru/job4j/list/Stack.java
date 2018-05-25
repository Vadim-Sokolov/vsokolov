package ru.job4j.list;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Stack<E>  {

    private Container<E> container;

    public Stack(Container<E> container) {
        this.container = container;
    }

    public E poll() {
        E result = container.get(0);
        container.delete();
        return result;
    }

    public void push(E value) {
        container.add(value);
    }

    public E peek() {
        return container.get(0);
    }

    public int getSize() {
        return container.getSize();
    }
}
