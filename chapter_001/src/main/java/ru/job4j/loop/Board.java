package ru.job4j.loop;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Board {
	
	/**
	* Method draws a chess board in console.
	* by creating a string of Xs, spaces and new lines.
	* @param width - number of chars in a line
	* @param height - number of lines
	* @return sb.toString() - the String to be printed out
	*/
	public String paint(int width, int height) {
		StringBuilder sb = new StringBuilder();
		String newLine = System.lineSeparator();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if ((i + j) % 2 == 0) {
					sb.append("X");
				} else {
					sb.append(" ");
				}
			}
			sb.append(newLine);
		}		
		return sb.toString();
	}
}