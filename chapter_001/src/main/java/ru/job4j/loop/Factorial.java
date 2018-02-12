package ru.job4j.loop;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Factorial {
	
	/**
	* Method calculates factorial of a given number and returns the result.
	* @param int n
	* @return result
	*/
	public int calc(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
}