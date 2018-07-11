package ru.job4j;

import java.util.Set;
import java.util.TreeMap;
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
        TreeMap<Character, Integer> firstMap = new TreeMap<>();
        char[] firstArray = firstStr.toCharArray();

        for (int i = 0; i < firstArray.length; i++) {
            if (firstMap.containsKey(firstArray[i])) {
                firstMap.put(firstArray[i], firstMap.get(firstArray[i] + 1));
            } else {
                firstMap.put(firstArray[i], 1);
            }
        }
        TreeMap<Character, Integer> secondMap = new TreeMap<>();
        char[] secondArray = firstStr.toCharArray();

        for (int i = 0; i < secondArray.length; i++) {
            if (secondMap.containsKey(secondArray[i])) {
                secondMap.put(secondArray[i], secondMap.get(secondArray[i] + 1));
            } else {
                secondMap.put(secondArray[i], 1);
            }
        }
        TreeSet fs = (TreeSet) firstMap.keySet();
        TreeSet ss = (TreeSet) secondMap.keySet();
        boolean result = true;
        if (fs.equals(ss)) {
            for (Object c : fs) {
                if (!firstMap.get(c).equals(secondMap.get(c))) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}