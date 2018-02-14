package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class FindLoopTest {
	
	@Test
	public void findElement() {
		
		FindLoop floop = new FindLoop();
		int[] target = new int[] {1, 3, 5};
		int result = floop.indexOf(target, 3);
		assertThat(result, is(1));
	}
	
	@Test
	public void elementNotFound() {
		
		FindLoop floop = new FindLoop();
		int[] target = new int[] {1, 3, 5};
		int result = floop.indexOf(target, 4);
		assertThat(result, is(-1));
	}
}