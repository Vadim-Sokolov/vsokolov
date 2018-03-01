package ru.job4j.pseudo;

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
public class PaintTest {
	
	@Test
	public void whenDrawSquare() {
		PrintStream stdOut = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		new Paint().draw(new Square());
		assertThat(new String(baos.toByteArray()), 
			is("++++\n++++\n++++\n++++\n\r\n"));
	}
}