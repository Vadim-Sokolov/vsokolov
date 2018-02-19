package ru.job4j.loop;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Counter {
	
	/**
	* Method adds all the even numbers in range specified by parameters.
	* And returns the result.
	* @param start
	* @param finish
	* @return result
	*/		
	public int add(int start, int finish) {
		int result = 0;
		for (int i = start; i <= finish; i++) {
			
			if (i % 2 == 0) {
				result += i;
			}
		}
		return result;
	}
}