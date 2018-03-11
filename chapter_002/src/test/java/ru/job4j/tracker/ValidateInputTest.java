package ru.job4j.tracker;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class ValidateInputTest {
	
	private final ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private final PrintStream out = System.out;
	
	@Before
	public void loadBaos() {
		System.setOut(new PrintStream(this.baos));
	}
	
	@After
	public void loadSys() {
		System.setOut(this.out);
	}
	
	@Test
	public void whenInvalidInput() {
		ValidateInput input = new ValidateInput(
			new StubInput(new String[] {"invalid", "1"}));
		input.ask("Enter", new int[] {1});
		assertThat(this.baos.toString(), 
		is("You need to enter a number, please try again"
		+ System.getProperty("line.separator")));
	}
}