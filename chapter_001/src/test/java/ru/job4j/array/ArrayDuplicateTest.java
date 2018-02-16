package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicateTest {
	
	@Test
	public void removeDuplicatesFromGivenArray() {
		
		ArrayDuplicate arrd = new ArrayDuplicate();
		String[] target = new String[] {"Привет", "Мир", "Привет", "Супер", "Мир"};
		String[] expected = new String[]  {"Привет", "Мир", "Супер"};
		String[] result = arrd.remove(target);
		assertThat(result, is(expected));
	}
}