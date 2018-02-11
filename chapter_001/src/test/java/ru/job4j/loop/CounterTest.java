package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class CounterTest {
	
	@Test
	public void sumUpEvenNumbersBetween1And10() {
		
		Counter cnt = new Counter();
		int result = cnt.add(1, 10);
		assertThat(result, is(30));
	}
}
