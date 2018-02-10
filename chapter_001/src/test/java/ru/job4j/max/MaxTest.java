package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {
	
	@Test
	public void whenFirstLessSecond() {
		Max maxim = new Max();
		int result = maxim.max(1, 2);
		assertThat(result, is(2));
	}
	
	@Test public void whenFirstGreaterSecond() {
		Max maxim = new Max();
		int result = maxim.max(2, 1);
		assertThat(result, is(2));
	}
	
	@Test public void whenFirstEqualSecond() {
		Max maxim = new Max();
		int result = maxim.max(2, 2);
		assertThat(result, is(2));
	}
	
	@Test public void findMaximumOfThreeNumbers() {
		Max maxim = new Max();
		int result = maxim.max(1, 2, 3);
		assertThat(result, is(3));
	}
}

	
	