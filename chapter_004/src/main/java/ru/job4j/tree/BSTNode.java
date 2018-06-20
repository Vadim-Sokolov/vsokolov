package ru.job4j.tree;

import java.util.Comparator;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class BSTNode<E> {

    protected BSTNode<E> left;
    protected BSTNode<E> right;
    private E data;

    public BSTNode(E data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }

    public E getData() {
        return data;
    }
}
