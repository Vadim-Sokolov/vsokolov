package ru.job4j.tree;

import java.util.*;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E>, Iterable {

    private Node<E> root;

    public Tree(Node<E> root) {
        this.root = root;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = true;
        Optional<Node<E>> target = findBy(parent);
        Node<E> toAdd = new Node<>(child);
        if (target.isPresent()) {
            target.get().add(toAdd);
        } else {
            result = false;
        }
        return result;
    }

    public boolean isBinary() {
        boolean result = true;
        Iterator<Node<E>> itr = this.iterator();
        while (itr.hasNext()) {
            if (itr.next().leaves().size() > 2) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                result = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }

    @Override
    public Iterator iterator() {
        return Arrays.asList(this).iterator();
    }
}
