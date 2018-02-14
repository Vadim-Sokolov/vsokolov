package ru.job4j.array;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Turn {

	/**
	* Method reverses a given array and returns the result.
	* @param int[] array - given array
	* @return array
	*/
	public int[] back(int[] array) {
		
		int j = array.length - 1;
		for (int i = 0; i < array.length / 2; i++, j--) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		return array;
	}
}