package ru.job4j.array;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {

	/**
	* Method reverses a given array and returns the result.
	* @param array - given array
	* @return array
	*/
	public int[] sort(int[] array) {
		int length = array.length;
		int temp = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 1; j < length - i; j++) {
				if (array[j - 1] > array[j]) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
}