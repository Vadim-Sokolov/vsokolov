package ru.job4j;

import org.junit.Test;
import ru.job4j.functional_interface.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void add1to3() {
        Calculator c = new Calculator();
        List<Double> buffer = new ArrayList<>();
        c.multiply(0, 3, 1, (value, i) -> (double) value + i,
                result -> buffer.add(result));
        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }
}