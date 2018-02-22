package ru.job4j.professions;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class House {
	
	private String type;
	private double area;
	
	public House(String type, double area) {
		this.type = type;
		this.area = area;
	}
	
	public String getType() {
		return type;
	}
	public double getArea() {
		return area;
	}
}