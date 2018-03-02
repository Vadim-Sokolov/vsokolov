package ru.job4j.tracker;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
	
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    private static final String EXIT = "6";
  
    private final Input input;
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            
			switch (answer) {
				case ADD:
				this.createItem();
				break;
				
				case SHOW:
				this.showItems();
				break;
				
				case EDIT:
				this.editItem();
				break;
				
				case DELETE:
				this.deleteItem();
				break;
				
				case FINDBYID:
				this.findById();
				break;
				
				case FINDBYNAME:
				this.findByName();
				break;
				
				case EXIT:
				exit = true;
				break;
				
				default:
				System.out.println("Action not found, please try again.");
				break;
			}				
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Add new item --------------\n");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        String id = this.tracker.generateId();
		Item item = new Item(name, desc, id);
        this.tracker.add(item);
        System.out.println("------------ New Item Id : " + item.getId() + "-----------");
    }

	protected void showItems() {
		Item[] target = this.tracker.findAll();
		for (Item item : target) {
			item.print();
		}
	}
	
	private void editItem() {
		String id = this.input.ask("Please enter item id");
		Item target = this.tracker.findById(id);
		target.print();
		String newMessage = this.input.ask("Please enter new item message");
		target.setMessage(newMessage);
		this.tracker.replace(id, target);
		System.out.println("Item modified");
		target.print();
	}
	
	private void deleteItem() {
		String id = this.input.ask("Please enter item id");
		Item target = this.tracker.findById(id);
		System.out.print("Deleting...");
		target.print();
		this.tracker.delete(id);
		System.out.println("Item deleted");
	}
	
	protected void findById() {
		String id = this.input.ask("Please enter item id");
		Item target = this.tracker.findById(id);
		System.out.print("Found ");
		target.print();
	}
	
	protected void findByName() {
		String name = this.input.ask("Please enter item name");
		Item[] target = this.tracker.findByName(name);
		System.out.println("Found ");
		for (Item item : target) {
			item.print();
		}
	}
	
    private void showMenu() {
        System.out.println("Меню.\n");
        System.out.println(
			"0. Add new Item\n" 
			+ "1. Show all items\n" 
			+ "2. Edit item\n" 
			+ "3. Delete item\n" 
			+ "4. Find item by Id\n" 
			+ "5. Find items by name\n" 
			+ "6. Exit Program"
		);
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}