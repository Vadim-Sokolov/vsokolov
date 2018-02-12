package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {
	
	@Test
	public void pyramidHeight2() {
		Paint paint = new Paint();
		String result = paint.pyramid(2);
		String ln = System.lineSeparator();
		assertThat(result, is(String.format(" ^ %s^^^%s", ln, ln)));
	}
	
	@Test
	public void pyramidHeight3() {
		Paint paint = new Paint();
		String result = paint.pyramid(3);
		String ln = System.lineSeparator();
		assertThat(result, is(String.format("  ^  %s ^^^ %s^^^^^%s", ln, ln, ln)));
	}
}