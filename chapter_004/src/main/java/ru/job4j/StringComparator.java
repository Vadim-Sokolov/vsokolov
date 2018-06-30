package ru.job4j;

import java.util.Arrays;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class StringComparator {

    public boolean sameChars(String firstStr, String secondStr) {
        char[] first = firstStr.toCharArray();
        char[] second = secondStr.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }
}
