package ru.job4j.tracker;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class ValidateInput extends ConsoleInput {
	public int ask(String question, int[] range) {
		boolean invalid = true;
		int value = -1;
		do {
			try {
				value = super.ask(question, range);
				invalid = false;
			} catch (MenuOutException moe) {
				System.out.println("This number is not in the menu, please try again");
			} catch (NumberFormatException nfe) {
				System.out.println("You need to enter a number, please try again");
			}
		} while (invalid);
		return value;
	}
}