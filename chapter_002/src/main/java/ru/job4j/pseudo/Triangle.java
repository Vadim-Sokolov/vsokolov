package ru.job4j.pseudo;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Triangle implements Shape {
	
	@Override
	public String draw() {
		StringBuilder pic = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				pic.append("+");
			}
			pic.append(System.getProperty("line.separator"));
		}
		return pic.toString();
	}
}