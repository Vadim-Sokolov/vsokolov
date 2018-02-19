package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class MatrixTest {
	
	@Test
	public void reverseOddArray() {
		Matrix mats = new Matrix();
		int[][] expected = new int[][] {{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
		int[][] result = mats.multiple(3);
		assertThat(result, is(expected));
	}
}