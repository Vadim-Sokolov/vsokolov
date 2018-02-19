package ru.job4j.array;

import java.lang.Math;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class FindLoop {

	/**
	* Method looks for an entry in a given array
	* and returns it's index.
	* @param data - given array
	* @param el - element to find
	* @return result - index of el
	*/
	public int indexOf(int[] data, int el) {
		int result = -1;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == el) {
				result = i;
				break;
			}
		}
		return result;
	}
}