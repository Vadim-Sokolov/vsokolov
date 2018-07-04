package ru.job4j.tree;

import java.util.Optional;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public interface SimpleTree<E extends Comparable<E>> {

    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);
}
