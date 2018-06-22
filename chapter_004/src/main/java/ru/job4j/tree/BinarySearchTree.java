package ru.job4j.tree;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private BSTNode<E> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void add(E data) {
        BSTNode<E> current = root;
        if (current.getData().compareTo(data) == 1) {
            current.left = new BSTNode<>(data);
        }
    }

    public BSTNode<E> getRoot() {
        return root;
    }
}
