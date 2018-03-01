package ru.job4j.array;

import java.util.Arrays;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Merger {
	
	/**
	* Method merges two sorted arrays into
	* one sorted array and returns the result.
	* @param a - 1st sorted array
	* @param b - 2d sorted array
	* @return result - resulting sorted array
	*/
    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        int i = 0;

        while (i < result.length) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }
            if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
                break;
            }
            i++;
        }
        return result;
    }
}