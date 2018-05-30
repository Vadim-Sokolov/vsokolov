package ru.job4j.condition;

import static org.hamcrest.number.IsCloseTo.closeTo;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *@author vsokolov
 *@version $Id$
 *@since 0.1
 */
 
public class TriangleTest {
	
	@Test
	public void setThreePointsAndCalculateTriangleArea() {
		
		// Create 3 Point objects.
		Point a = new Point(0, 0);
		Point b = new Point(2, 0);
		Point c = new Point(0, 2);
		
		// Create Triangle object using the Points above.
		Triangle triangle = new Triangle(a, b, c);
		
		// Calculate area.
		double result = triangle.area();
		
		// set the expected result.
		double expected = 2d;
		
		// Assert equality.
		assertThat(result, closeTo(expected, 0.1));
	}
}
 