package ru.job4j.tree;
/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class BSTNode {

    protected BSTNode left;
    protected BSTNode right;
    private int data;

    public BSTNode(int data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }

    public int getData() {
        return data;
    }
}
