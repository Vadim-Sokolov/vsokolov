package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class TurnTest {
	
	@Test
	public void reverseOddArray() {
		Turn turn = new Turn();
		int[] target = new int[] {1, 2, 3, 4, 5};
		int[] result = turn.back(target);
		assertThat(result, is(new int[] {5, 4, 3, 2, 1}));
	}
	
	@Test
	public void reverseEvenArray() {
		Turn turn = new Turn();
		int[] target = new int[] {4, 1, 6, 2};
		int[] result = turn.back(target);
		assertThat(result, is(new int[] {2, 6, 1, 4}));
	}
}
		