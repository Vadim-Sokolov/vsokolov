package ru.job4j.calculate;

import org.junit.Test;
import ru.job4j.functional_interface.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class CalcTest {

    Calc c = new Calc();

    @Test
    public void linearTest() {
        List<Double> target1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            target1.add((double) i + i + 1);
        }
        List<Double> target2 = c.calcInRange(0, 10, (i) -> i + i + 1);
        assertThat(target1.equals(target2), is(true));
    }

    @Test
    public void quadraticTest() {
        List<Double> target1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            target1.add((double) (i * i) + (i + 1) * (i + 1));
        }
        List<Double> target2 = c.calcInRange(0, 10, (i) -> (i * i) + (i + 1) * (i + 1));
        assertThat(target1.equals(target2), is(true));
    }

    @Test
    public void logarithmicTest() {
        List<Double> target1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            target1.add(Math.log(i) + Math.log(i + 1));
        }
        List<Double> target2 = c.calcInRange(0, 10, (i) -> Math.log(i) + Math.log(i + 1));
        assertThat(target1.equals(target2), is(true));
    }
}