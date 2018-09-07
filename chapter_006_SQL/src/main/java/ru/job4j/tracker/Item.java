package ru.job4j.tracker;
/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Item {

    private String name;
    private String message;

    public Item(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return this.name;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }
}