package ru.job4j.professions;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Student {
	
	private String name;
	private String specialty;
	
	public Student(String name, String specialty) {
		this.name = name;
		this.specialty = specialty;
	}
	
	public String getName() {
		return name;
	}
	public String getSpecialty() {
		return specialty;
	}
}