package ru.job4j.array;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Matrix {
	/**
	* Method creates a matrix of given size and fills it
	* with integers as a multiplication table. Returns the result.
	* @param size - size of matrix
	* @return array
	*/
	public int[][] multiple(int size) {
		int[][] result = new int[size][size];		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				result[i][j] = (i + 1) * (j + 1);
			}
		}
		return result;
	}
}
				