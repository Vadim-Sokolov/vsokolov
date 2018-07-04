package ru.job4j.tree;

import java.util.Stack;

public class BSTIterator {

    private Stack<BSTNode> stack = new Stack<>();

    public BSTIterator(BSTNode root) {
        push(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public BSTNode next() {
        BSTNode node = stack.pop();
        push(node.right);
        return node;
    }

    private void push(BSTNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
