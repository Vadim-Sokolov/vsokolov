package ru.job4j.tree;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class BinarySearchTree {

    private BSTNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void add(int data) {
        root = add(root, data);
    }

    public BSTNode add(BSTNode node, int data) {
        if (node == null) {
            node = new BSTNode(data);
        } else if (data < node.getData()) {
            node.left = add(node.left, data);
        } else {
            node.right = add(node.right, data);
        }
        return node;
    }

    public BSTNode getRoot() {
        return root;
    }
}
