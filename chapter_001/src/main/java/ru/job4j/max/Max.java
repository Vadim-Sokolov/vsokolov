package ru.job4j.max;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Max {
	
	/**
	 * Method compares two int's and returns their maximum.
	 * @param int first
	 * @param int second
	 * @return result - maximum
	 */	
	 public int max(int first, int second) {
		 
		 int result = (first > second) ? first : second;
		 return result;
	 }
	 
	 /**
	 * Method compares three int's and returns their maximum.
	 * @param int first
	 * @param int second
	 * @param int third
	 * @return result - maximum
	 */	
	 public int max(int first, int second, int third) {
		 
		 int result = max(max(first, second), third);
		 return result;
	 }
}
