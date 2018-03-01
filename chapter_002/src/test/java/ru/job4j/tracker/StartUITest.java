package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class StartUITest {
	
	@Test
	public void whenUserAddItemTrackerHasItemWithSameName() {
		Tracker tracker = new Tracker();
		Input input = new StubInput(new String[] {"0", "test name", "message", "6"});
		new StartUI(input, tracker).init();
		assertThat(tracker.findAll() [0].getName(), is("test name"));
	}
	
	@Test
	public void whenEditItemTrackerHasItemWithNewName() {
		Tracker tracker = new Tracker();
		tracker.add(new Item("1", "2", "3L"));
		Input input = new StubInput(new String[] {"2", "3L", "message", "6"});
		new StartUI(input, tracker).init();
		assertThat(tracker.findAll() [0].getMessage(), is("message"));
	}
	
	@Test
	public void whenDeleteItemItemsHasLength1() {
		Tracker tracker = new Tracker();
		tracker.add(new Item("1", "2", "3L"));
		tracker.add(new Item("4", "5", "6L"));
		Input input = new StubInput(new String[] {"3", "3L", "6"});
		new StartUI(input, tracker).init();
		assertThat(tracker.findAll().length, is("1"));
	}
}