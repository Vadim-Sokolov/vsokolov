package ru.job4j.array;

import java.util.Arrays;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class ArrayChar {
	
	private char[] data;
	
	public ArrayChar(String line) {
		this.data = line.toCharArray();
	}
	
	/**
	* Method checks that a line begins with a 
	* given prefix.
	* @param prefix
	* @return boolean
	*/
	public boolean startsWith(String prefix) {
		boolean result = true;
		char[] value = prefix.toCharArray();
		char[] target = new char[value.length];
		
		for (int i = 0; i < value.length; i++) {
			target[i] = this.data[i];
		}
		return Arrays.equals(value, target);
	}
}