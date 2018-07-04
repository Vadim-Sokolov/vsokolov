package ru.job4j.tree;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    BinarySearchTree tree = new BinarySearchTree();

    @Test
    public void addTest() {
        tree.add(24);
        tree.add(11);
        tree.add(30);
        assertThat(tree.getRoot().getData(), is(24));
        assertThat(tree.getRoot().left.getData(), is(11));
        assertThat(tree.getRoot().right.getData(), is(30));
    }
}