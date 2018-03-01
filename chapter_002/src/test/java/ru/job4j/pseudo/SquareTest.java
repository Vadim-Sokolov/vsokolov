package ru.job4j.pseudo;

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
	public void whenDrawSquare() {
		Square square = new Square();
		assertThat(square.draw(), is("++++\n++++\n++++\n++++\n"));
	}
}