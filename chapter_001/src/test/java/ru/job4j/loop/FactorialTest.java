package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class FactorialTest {
	
	@Test
	public void calculateFactorialFor5() {
		Factorial fact = new Factorial();
		int result = fact.calc(5);
		assertThat(result, is(120));
	}
	
	@Test
	public void calculateFactorialFor0() {
		Factorial fact = new Factorial();
		int result = fact.calc(0);
		assertThat(result, is(1));
	}
}