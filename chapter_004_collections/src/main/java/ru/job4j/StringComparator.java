package ru.job4j;

import java.util.TreeSet;
/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class StringComparator {

    public boolean sameChars(String firstStr, String secondStr) {
        if (firstStr.length() != secondStr.length()) {
            return false;
        }
        TreeSet<Character> firstSet = new TreeSet<>();
        char[] firstArray = firstStr.toCharArray();

        for (int i = 0; i < firstArray.length; i++) {
            firstSet.add(firstArray[i]);
        }
        TreeSet<Character> secondSet = new TreeSet<>();
        char[] secondArray = secondStr.toCharArray();
        for (int i = 0; i < secondArray.length; i++) {
            secondSet.add(secondArray[i]);
        }
        return firstSet.equals(secondSet);
    }
}