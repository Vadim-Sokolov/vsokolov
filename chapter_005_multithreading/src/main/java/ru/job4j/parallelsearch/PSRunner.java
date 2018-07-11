package ru.job4j.parallelsearch;

import java.util.ArrayList;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class PSRunner {

    public static void main(String[] args) {
        ArrayList<String> exts = new ArrayList<>();
        exts.add("txt");
        ParallelSearch ps = new ParallelSearch("d:/dir", "Consulted", exts);
        ps.init();
    }
}
