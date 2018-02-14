package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class BubbleSortTest {
	
	@Test
	public void reverseOddArray() {
		
		BubbleSort bs = new BubbleSort();
		int[] target = new int[] {5, 1, 2, 7, 3};
		int[] result = bs.sort(target);
		assertThat(result, is(new int[] {1, 2, 3, 5, 7}));
	}
}