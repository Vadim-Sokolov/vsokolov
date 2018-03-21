package ru.job4j.search;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String t1 = o1.toLowerCase();
        String t2 = o2.toLowerCase();
        char[] a = t1.toCharArray();
        char[] b = t2.toCharArray();
        int index = a.length > b.length ? b.length : a.length;
        int result = 0;
        for (int i = 0; i < index; i++) {
            result = Integer.compare((int) a[i], (int) b[i]);
            if (result != 0) {
                break;
            }
        }
        if (result == 0 && a.length != b.length) {
            result = a.length > b.length ? 1 : -1;
        }
        return result;
    }
}
