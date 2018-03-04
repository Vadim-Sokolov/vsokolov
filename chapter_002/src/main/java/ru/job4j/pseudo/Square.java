package ru.job4j.pseudo;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Square implements Shape {
	
	@Override
	public String draw() {
		StringBuilder pic = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			pic.append("++++" + System.getProperty("line.separator"));
		}
		return pic.toString();
	}
}