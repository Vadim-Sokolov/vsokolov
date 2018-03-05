package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class StartUITest {
	
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	
	@Before
	public void loadOut() {
		System.out.println("Execute before method");
		System.setOut(new PrintStream(this.out));
	}
	
	@After
	public void loadStandard() {
		System.setOut(this.standardOut);
		System.out.println("Execute after method");
	}
	
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
		assertThat(tracker.findAll().length, is(1));
	}
	
	@Test
	public void whenShowItems() {
		Tracker tracker = new Tracker();
		tracker.add(new Item("1", "2", "3L"));
		tracker.add(new Item("4", "5", "6L"));
		Input input = new StubInput(new String[] {"1", "6"});
		new StartUI(input, tracker).showItems();
		assertThat(new String(this.out.toByteArray()),
			is(new StringBuilder()
			.append(tracker.items[0].toStr())
			.append(System.getProperty("line.separator"))
			.append(tracker.items[1].toStr())
			.append(System.getProperty("line.separator"))
			.toString()));
	}
	
	@Test
	public void whenFindById() {
		Tracker tracker = new Tracker();
		tracker.add(new Item("1", "2", "3L"));
		tracker.add(new Item("4", "5", "6L"));
		Input input = new StubInput(new String[] {"3L"});
		new StartUI(input, tracker).findById();
		assertThat(new String(this.out.toByteArray()),
			is(new StringBuilder()
			.append("Found ")
			.append(tracker.items[0].toStr())
			.append(System.getProperty("line.separator"))
			.toString()));
	}
	
	@Test
	public void whenFindByName() {
		Tracker tracker = new Tracker();
		tracker.add(new Item("1", "2", "3L"));
		tracker.add(new Item("1", "5", "6L"));
		Input input = new StubInput(new String[] {"1"});
		new StartUI(input, tracker).findByName();
		assertThat(new String(this.out.toByteArray()),
			is(new StringBuilder()
			.append("Found ")
			.append(System.getProperty("line.separator"))
			.append(tracker.items[0].toStr())
			.append(System.getProperty("line.separator"))
			.append(tracker.items[1].toStr())
			.append(System.getProperty("line.separator"))
			.toString()));
	}
}