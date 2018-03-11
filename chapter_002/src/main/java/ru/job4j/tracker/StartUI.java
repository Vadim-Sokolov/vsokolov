package ru.job4j.tracker;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
  
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
		int[] range = new int[menu.getActionsLength()];
		for (int i = 0; i < range.length; i++) {
			range[i] = i;
		}
		do {
			menu.show();
			int key = input.ask("Please select action: ", range);
			if (key == 6) {
				exit = true;
				break;
			} else {
				menu.select(key);
			} 
		} while (!exit);
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}