package ru.job4j.tracker;

import java.util.*;
import java.lang.System;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Tracker {

	private final Item[] items = new Item[100];
	private int position = 0;
	private static final Random RN = new Random();

	/**
	* Метод реализаущий добавление заявки в хранилище
	* @param item новая заявка
	*/
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items[this.position++] = item;
		return item;
	}
	
	/**
	* Метод реализаущий редактирование заявки в хранилище
	* @param item редаkтируемая заявка
	*/
    public void replace(String id, Item item) {
		Item target = this.findById(id);
		int indexOfTarget = Arrays.asList(this.items).indexOf(target);
		items[indexOfTarget] = item;
	}
	
	/**
	* Method deletes an item from the array.
	* @param item - to delete
	*/
	public void delete(String id) {
		Item target = this.findById(id);
		int indexOfTarget = Arrays.asList(this.items).indexOf(target);
		System.arraycopy(this.items, indexOfTarget + 1, this.items, indexOfTarget,
			this.items.length - indexOfTarget);
	}
	
	/**
	* Method returns a list of all the items.
	*/
	public Item[] findAll() {
		int index = this.items.length - 1;
		for (Item item : this.items) {
			if (item == null) {
				index = Arrays.asList(this.items).indexOf(item);
				break;
			}
		}
		return Arrays.copyOfRange(this.items, 0, index);
	}
	
	/**
	* Method returns a list of all the items with a given name.
	* param@ key - given name.
	*/
	public Item[] findByName(String key) {
		Item[] result = new Item[this.items.length];
		int resultPosition = 0;
		for (Item item : this.items) {
			if (item.getName().equals(key)) {
				result[resultPosition++] = item;
			}
		}
		return Arrays.copyOfRange(result, 0, resultPosition - 1);
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
	private String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
	}
}