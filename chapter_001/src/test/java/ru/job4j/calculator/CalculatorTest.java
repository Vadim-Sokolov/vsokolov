package ru.job4j.calculator;

import org.junit.Test;
import ru.job4j.calculator.Calculator;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class CalculatorTest {

    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSubtract1minus1Then0() {
        Calculator calc = new Calculator();
        calc.subtract(1D, 1D);
        double result = calc.getResult();
        double expected = 0.0d;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMultiply2By2Then4() {
        Calculator calc = new Calculator();
        calc.multiply(2D, 2d);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDivide4By2Then2() {
        Calculator calc = new Calculator();
        calc.divide(4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
}