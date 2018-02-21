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
		char[] value = prefix.toCharArray();
		char[] target = new char[value.length];
		for (int i = 0; i < value.length; i++) {
			target[i] = this.data[i];
		}
		return Arrays.equals(value, target);
	}
	
	/**
	* Method checks that a String contains 
	* a given substring.
	* @param origin - given String
	* @param sub - the substring
	* @return boolean
	*/
	public boolean contains(String origin, String sub) {
		boolean result = false;
		char[] originChar = origin.toCharArray();
		char[] subChar = sub.toCharArray();
		char target = subChar[0];
		for (int i = 0; i < originChar.length; i++) {
			if (originChar[i] == target && originChar.length - i >= subChar.length) {
				for (int j = 1, x = i + 1; j < subChar.length; j++, x++) {
					if (subChar[j] != originChar[x]) {
						break;
					} else {
						result = true;
					}
				}
			}
		}
		return result;
	}
}