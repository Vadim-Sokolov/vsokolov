package ru.job4j.pseudo;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {
	
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream baosOut = new ByteArrayOutputStream();
	
	@Before
	public void loadOut() {
		System.out.println("Execute before method");
		System.setOut(new PrintStream(this.baosOut));
	}
	
	@After
	public void loadStandard() {
		System.setOut(this.standardOut);
		System.out.println("Execute after method");
	}
	
	@Test
	public void whenDrawSquare() {
		new Paint().draw(new Square());
		assertThat(new String(this.baosOut.toByteArray()), 
			is("++++\n++++\n++++\n++++\n\r\n"));
	}
	
	@Test
	public void whenDrawTriangle() {
		new Paint().draw(new Triangle());
		assertThat(new String(this.baosOut.toByteArray()), 
			is("\n+\n++\n+++\n++++\n\r\n"));
	}
}