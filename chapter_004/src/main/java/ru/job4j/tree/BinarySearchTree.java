package ru.job4j.tree;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class BinarySearchTree<E> {

    private BSTNode<E> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void add(E data) {
        root = add(root, data);
    }

    public BSTNode<E> add(BSTNode node, E data) {
        if (node == null) {
            node = new BSTNode(data);
        } else if (data.hashCode() < node.getData().hashCode()) {
            node.left = add(node.left, data);
        } else {
            node.right = add(node.right, data);
        }
        return node;
    }

    public BSTNode<E> getRoot() {
        return root;
    }
}
