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
		Square squar = new Square();
		int[] target = squar.calculate(5);
		int result = floop.indexOf(target, 16);
		assertThat(result, is(3));
	}
	
	@Test
	public void elementNotFound() {
		
		FindLoop floop = new FindLoop();
		Square squar = new Square();
		int[] target = squar.calculate(5);
		int result = floop.indexOf(target, 15);
		assertThat(result, is(-1));
	}
}