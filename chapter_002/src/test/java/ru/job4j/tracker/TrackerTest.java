package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class TrackerTest {
	
	@Test
	public void whenAddNewItemTrackerHasSameIter() {
		Tracker tracker = new Tracker();
		Item item = new Item("name1", "message1", "123L");
		tracker.add(item);
		assertThat(tracker.findAll()[0], is(item));
	}
	
	@Test
	public void whenReplaceItemThenReturnNewName() {
		Tracker tracker = new Tracker();
		Item previous = new Item("name1", "message1", "123L");
		tracker.add(previous);
		Item next = new Item("name2", "message2", "1234L");
		next.setId(previous.getId());
		tracker.replace(previous.getId(), next);
		assertThat(tracker.findById(previous.getId()).getName(), is("name2"));
	}
	
	/*@Test
	public void whenDeleteItemThenReturnNextItem() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("name1", "message1", "123L");
		Item item2 = new Item("name2", "message2", "1234L");
		tracker.add(item1);
		tracker.add(item2);
		tracker.delete("123L");
		assertThat(tracker.findAll()[0], is(item2));
	}*/
	
	@Test
	public void whenFindAllReturnsArrayOfLength2() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("name1", "message1", "123L");
		Item item2 = new Item("name2", "message2", "1234L");
		tracker.add(item1);
		tracker.add(item2);
		assertThat(tracker.findAll().length, is(2));
	}
	
	/*@Test
	public void whenFindByNameReturnsArrayOfLength2() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("name1", "message1", "123L");
		Item item2 = new Item("name2", "message2", "1234L");
		Item item3 = new Item("name2", "message3", "12345L");
		tracker.add(item1);
		tracker.add(item2);
		tracker.add(item3);
		assertThat(tracker.findByName("name2").length, is(2));
	}*/
	
	@Test
	public void whenFindByIdReturnsAnItemWithCorrectName() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("name1", "message1", "123L");
		Item item2 = new Item("name2", "message2", "1234L");
		tracker.add(item1);
		tracker.add(item2);
		assertThat(tracker.findById("1234L").getName(), is("name2"));
	}
}