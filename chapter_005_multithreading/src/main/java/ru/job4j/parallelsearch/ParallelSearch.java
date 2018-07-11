package ru.job4j.parallelsearch;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class ParallelSearch {

    private final String root;
    private final String text;
    private final List<String> exts;

    @GuardedBy("this")
    private final Queue<String> files = new LinkedList<>();

    @GuardedBy("this")
    private List<String> paths = new ArrayList<>();


    public ParallelSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }

    public void init() {
        Thread search = new Thread() {
            @Override
            public void run() {
                ru.job4j.parallelsearch.FileVisitor fv1 = new ru.job4j.parallelsearch.FileVisitor();
                ArrayList<String> targetFiles = fv1.filterExtensions(fv1.getPaths(root), exts);
                synchronized (files) {
                    for (String t : targetFiles) {
                        files.add(t);
                    }
                }
            }
        };
        Thread read = new Thread() {
            @Override
            public void run() {
                ru.job4j.parallelsearch.FileVisitor fv2 = new ru.job4j.parallelsearch.FileVisitor();
                synchronized (files) {
                    if (files.size() != 0) {
                        try {
                            paths = fv2.filterByText(files, text);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
    }

    synchronized List<String> result() {
        return this.paths;
    }
}
