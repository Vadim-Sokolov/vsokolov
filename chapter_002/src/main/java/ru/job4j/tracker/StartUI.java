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
		MenuTracker menu = new MenuTracker(this.input, this.tracker);
		boolean exit = false;
        menu.fillActions();
		do {
			menu.show();
			int key = Integer.valueOf(input.ask("Please select action: "));
			if (key == 6) {
				exit = true;
				break;
			} else if (key > -1 && key < menu.getActionsLength()) {
				menu.select(key);
			} else {
				System.out.println("Action not found, please try again.");
			}
		} while (!exit);
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}