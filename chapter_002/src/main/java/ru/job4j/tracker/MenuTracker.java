package ru.job4j.tracker;

/**
* @author vsokolov
* @version $Id$
* @since 0.1
*/

class EditItem implements UserAction {
	public int key() {
			return 2;
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
		
		public String info() {
			return String.format("%s %s", this.key(), "Edit item.");
		}
}
	
public class MenuTracker {
	
	private Input input;
	private Tracker tracker;
	private UserAction[] actions = new UserAction[7];
	
	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}
	
	public int getActionsLength() {
		return actions.length;
	}
	
	public void fillActions() {
		this.actions[0] = this.new AddItem();
		this.actions[1] = new MenuTracker.ShowItems();
		this.actions[2] = new EditItem();
		this.actions[3] = this.new DeleteItem();
		this.actions[4] = this.new FindItemById();
		this.actions[5] = this.new FindItemByName();
		this.actions[6] = this.new Exit();
	}
	
	public void show() {
		for (UserAction action : this.actions) {
			if (action != null) {
				System.out.println(action.info());
			}
		}
	}
	
	public void select(int key) {
			this.actions[key].execute(this.input, this.tracker);
	}
	
	/**
     * Класс реализует добавление новой заявки в хранилище.
     */
	private class AddItem implements UserAction {
		public int key() {
			return 0;
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
		
		public String info() {
			return String.format("%s %s", this.key(), "Add new item.");
		}
	}
	
	private static class ShowItems implements UserAction {
		public int key() {
			return 1;
		}
		
		public void execute(Input input, Tracker tracker) {
			Item[] target = tracker.findAll();
			for (Item item : target) {
				item.print();
			}
		}
		
		public String info() {
			return String.format("%s %s", this.key(), "Show all items.");
		}
	}
	
	private class DeleteItem implements UserAction {
		public int key() {
			return 3;
		}
		
		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Please enter item id");
			Item target = tracker.findById(id);
			System.out.print("Deleting...");
			target.print();
			tracker.delete(id);
			System.out.println("Item deleted");
		}
		
		public String info() {
			return String.format("%s %s", this.key(), "Delete item.");
		}
	}
	
	private class FindItemById implements UserAction {
		public int key() {
			return 4;
		}
		
		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Please enter item id");
			Item target = tracker.findById(id);
			System.out.print("Found ");
			target.print();
		}
		
		public String info() {
			return String.format("%s %s", this.key(), "Find item by Id.");
		}
	}
	
	private class FindItemByName implements UserAction {
		public int key() {
			return 5;
		}
		
		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Please enter item name");
			Item[] target = tracker.findByName(name);
			System.out.println("Found ");
			for (Item item : target) {
				item.print();
			}
		}
		
		public String info() {
			return String.format("%s %s", this.key(), "Find item by name.");
		}
	}
	
	private class Exit implements UserAction {
		public int key() {
			return 6;
		}
		
		public void execute(Input input, Tracker tracker) {
		}
		
		public String info() {
			return String.format("%s %s", this.key(), "Exit");
		}
	}
}