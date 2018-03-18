package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
* @author vsokolov
* @version $Id$
* @since 0.1
*/

class EditItem extends BaseAction {
		
		public EditItem(int key, String name) {
			super(key, name);
		}
		
		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Please enter item id");
			Item target = tracker.findById(id);
			target.print();
			String newMessage = input.ask("Please enter new item message");
			target.setMessage(newMessage);
			tracker.replace(id, target);
			System.out.println("Item modified");
			target.print();
		}
}
	
public class MenuTracker {
	
	private Input input;
	private Tracker tracker;
	private List<UserAction> actions = new ArrayList<>();
	
	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}
	
	public int getActionsLength() {
		return actions.size();
	}
	
	public void fillActions() {
		this.actions.add(this.new AddItem(0, "Add Item"));
		this.actions.add(new MenuTracker.ShowItems(1, "Show Items"));
		this.actions.add(new EditItem(2, "Edit Item"));
		this.actions.add(this.new DeleteItem(3, "Delete Item"));
		this.actions.add(this.new FindItemById(4, "Find Item by id"));
		this.actions.add(this.new FindItemByName(5, "Find Item by name"));
		this.actions.add(this.new Exit(6, "Exit"));
	}
	
	public void addAction(UserAction action) {
		this.actions.add(action);
	}
	
	public void show() {
		for (UserAction action : this.actions) {
			System.out.println(action.info());
		}
	}
	
	public void select(int key) {
			this.actions.get(key).execute(this.input, this.tracker);
	}
	
	/**
     * Класс реализует добавление новой заявки в хранилище.
     */
	private class AddItem extends BaseAction {
		
		public AddItem(int key, String name) {
			super(key, name);
		}
		
		public void execute(Input input, Tracker tracker) {
		System.out.println("------------ Add new item --------------\n");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        String id = tracker.generateId();
		Item item = new Item(name, desc, id);
        tracker.add(item);
        System.out.println("------------ New Item Id : " + item.getId() + "-----------");
		}
	}
	
	private static class ShowItems extends BaseAction {
		
		public ShowItems(int key, String name) {
			super(key, name);
		}
		
		public void execute(Input input, Tracker tracker) {
			List<Item> target = tracker.findAll();
			for (Item item : target) {
				item.print();
			}
		}
	}
	
	private class DeleteItem extends BaseAction {
		
		public DeleteItem(int key, String name) {
			super(key, name);
		}
		
		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Please enter item id");
			Item target = tracker.findById(id);
			System.out.print("Deleting...");
			target.print();
			tracker.delete(id);
			System.out.println("Item deleted");
		}
	}
	
	private class FindItemById extends BaseAction {
		
		public FindItemById(int key, String name) {
			super(key, name);
		}
		
		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Please enter item id");
			Item target = tracker.findById(id);
			System.out.print("Found ");
			target.print();
		}
	}
	
	private class FindItemByName extends BaseAction {
		
		public FindItemByName(int key, String name) {
			super(key, name);
		}
		
		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Please enter item name");
			List<Item> target = tracker.findByName(name);
			System.out.println("Found ");
			for (Item item : target) {
				item.print();
			}
		}
	}
	
	private class Exit extends BaseAction {
		
		public Exit(int key, String name) {
			super(key, name);
		}
		
		public void execute(Input input, Tracker tracker) {
		}
	}
}