package ru.job4j.pseudo;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Triangle {
	
	public String draw(int n) {
		StringBuilder pic = new StringBuilder();
		for (int i = n; i > 0; i--) {
			for (int j = 1; j < i; j++) {
				pic.append(" ");
			}
			for (int x = n + 1; x > i; x--) {
				pic.append("#");
			}
			pic.append(System.getProperty("line.separator"));
		}
		return pic.toString();
	}
	public static void main(String[] args) {
		Triangle t = new Triangle();
		System.out.println(t.draw(20));
	}
}