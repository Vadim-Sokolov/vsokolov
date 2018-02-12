package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Paint {
	
	/**
	* Method draws a pyramid in console
	* by creating a string of ^s, spaces and new lines.
	* @param int height - height of the pyramid
	* @return sb.toString() - the String to be printed out
	*/
	public String pyramid(int height) {
		return this.loopBy(height, 2 * height - 1, (row, column) 
		-> row >= height - column - 1 && row + height - 1 >= column);
	}
	
	private String loopBy(int height, int width, BiPredicate<Integer, Integer> predict) {
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row != height; row++) {
			for (int column = 0; column != width; column++) {
				if (predict.test(row, column)) {
					sb.append("^");
				} else {
					sb.append(" ");
				}
			}
			sb.append(System.lineSeparator());
		}
		return sb.toString();	
	}
}