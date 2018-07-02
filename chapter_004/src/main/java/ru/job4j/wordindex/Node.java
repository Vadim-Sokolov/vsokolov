package ru.job4j.wordindex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Node {

    private Map<Character, Node> children = new HashMap<>();
    private HashSet<Integer> indices = new HashSet<>();

    public Map<Character, Node> getChildren() {
        return children;
    }

    public HashSet<Integer> getIndeces() {
        return indices;
    }
}
