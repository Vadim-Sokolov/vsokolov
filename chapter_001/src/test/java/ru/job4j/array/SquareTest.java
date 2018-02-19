package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class SquareTest {
	
	@Test
	public void lengthEquals5() {
		Square square = new Square();
		int[] result = square.calculate(5);
		assertThat(result.length, is(5));
	}
	
	@Test
	public void fifthElementIs25() {
		Square square = new Square();
		int[] result = square.calculate(5);
		assertThat(result[4], is(25));
	}
}
		