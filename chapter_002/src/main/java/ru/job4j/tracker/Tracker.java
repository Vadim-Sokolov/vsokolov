package ru.job4j.tracker;

import java.util.*;
import java.lang.System;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Tracker {

	protected final List<Item> items = new ArrayList<>();
	private int position = 0;
	private static final Random RN = new Random();

	/**
	* Метод реализаущий добавление заявки в хранилище
	* @param item новая заявка
	*/
	public Item add(Item item) {
		this.items.add(item);
		return item;
	}
	
	/**
	* Метод реализаущий редактирование заявки в хранилище
	* @param item редаkтируемая заявка
	*/
    public void replace(String id, Item item) {
		Item target = this.findById(id);
		this.items.remove(this.findById(id));
		this.items.add(item);
	}
	
	/**
	* Method deletes an item from the array.
	* @param id - to delete
	*/
	public void delete(String id) {
		this.items.remove(this.findById(id));
	}
	
	/**
	* Method returns a list of all the items.
	*/
	public List<Item> findAll() {
		return this.items;
	}
	
	/**
	* Method returns a list of all the items with a given name.
	* param@ key - given name.
	*/
	public List<Item> findByName(String key) {
		List<Item> result = new ArrayList<>();
		for (Item item : this.items) {
			if (item.getName().equals(key)) {
				result.add(item);
			}
		}
		return result;
	}
	
	/**
	* Method returns a item with a given id.
	* param@ id - given id.
	*/
    public Item findById(String id) {
		Item result = null;
		for (Item item : this.items) {
			if (item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}

	/**
	* Метод генерирует уникальный ключ для заявки.
	* @return Уникальный ключ.
	*/
	protected String generateId() {
		return String.valueOf(RN.nextInt(100000));
	}
}