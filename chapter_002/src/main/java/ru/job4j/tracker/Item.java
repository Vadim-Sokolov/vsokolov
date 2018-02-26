package ru.job4j.tracker;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Item {
	
	private String name;
	private String id;
	private String message;
	
	public Item(String name, String message, String id) {
		this.name = name;
		this.message = message;
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}