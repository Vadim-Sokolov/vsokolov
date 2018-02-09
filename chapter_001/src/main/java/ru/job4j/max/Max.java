package ru.job4j.max;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Max {
	
	 public int max(int first, int second) {
		 
		 int result = (first > second) ? first : second;
		 return result;
	 }
}
