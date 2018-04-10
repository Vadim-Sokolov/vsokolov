package ru.job4j.coffeemachine;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CoffeeMachineTest {

    @Test
    public void changeTest() {
        CoffeeMachine cm = new CoffeeMachine();
        int[] result = cm.change(20, 5);
        assertThat(result.length, is(2));
        assertThat(result[1], is(5));
    }

    @Test
    public void isEnough() {
        CoffeeMachine cm = new CoffeeMachine();
        boolean result = cm.isEnough(20, 5);
        assertThat(result, is(true));
    }

    @Test
    public void rec() {
        CoffeeMachine cm = new CoffeeMachine();
        int[] result = cm.change(100, 32);
        int[] expected = new int[]{10, 10, 10, 10, 10, 10, 5, 2, 1};
        assertThat(result, is(expected));
    }
}