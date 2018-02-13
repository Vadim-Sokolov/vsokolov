package ru.job4j.array;

import java.lang.Math;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Square {
	
	/**
	* Method creates an array of given size and fills it with
	* int's squared from 1 to int = size, then returns the array.
	* @param int bound - size of array
	* @return result - the array
	*/
	public int[] calculate(int bound) {
		
		int[] result = new int[bound];		
		for (int i = 0; i < bound; i++) {
			result[i] = (i + 1) * (i + 1);
		}
		return result;
	}
}