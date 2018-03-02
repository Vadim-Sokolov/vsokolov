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
	
	public String getMessage() {
		return this.message;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void print() {
		System.out.println("\nItem Name:" + this.name 
		+ "\nItem Message: " + this.message + "\nItem id: " + this.id + "\n=======");
	}
	
	public String toStr() {
		String result = "\nItem Name:" + this.name 
		+ "\nItem Message: " + this.message + "\nItem id: " + this.id + "\n=======";
		return result;
	}
}