package ru.job4j.tree;

import java.util.Iterator;
import java.util.Stack;

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
        BSTNode<E> newNode = new BSTNode<>(data);
        if (root == null) {
            root = newNode;
        } else {
            BSTNode<E> current = root;
            BSTNode<E> parent;
            while (true) {
                parent = current;
                if (current.getData().compareTo(data) <= 1) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    } else {
                        current = current.right;
                        if (current == null) {
                            parent.right = newNode;
                            return;
                        }
                    }
                }
            }
        }
    }

    public BSTNode<E> getRoot() {
        return root;
    }

    public BSTIterator iterator() {
        return new BSTIterator(root);
    }
}
