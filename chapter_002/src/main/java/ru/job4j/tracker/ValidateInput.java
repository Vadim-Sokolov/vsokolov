package ru.job4j.tracker;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class ValidateInput implements Input {
	
	private final Input input;
	
	public ValidateInput(final Input input) {
		this.input = input;
	}
	
	@Override
	public String ask(String question) {
		return this.input.ask(question);
	}
	
	public int ask(String question, int[] range) {
		boolean invalid = true;
		int value = -1;
		do {
			try {
				value = Integer.valueOf(this.ask(question));
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