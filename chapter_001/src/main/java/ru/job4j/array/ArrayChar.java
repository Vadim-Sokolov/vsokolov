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
		char[] target = new char[subChar.length];
		for (int i = 0; i < originChar.length; i++) {
			if (originChar[i] == subChar[0] && originChar.length - i >= subChar.length) {
				for (int j = 0, x = i; j < target.length; j++, x++) {
					target[j] = originChar[x];
				}
				if (Arrays.equals(target, subChar)) { 
					result = true;
					break;
				}
			}
		}
		return result;
	}
}