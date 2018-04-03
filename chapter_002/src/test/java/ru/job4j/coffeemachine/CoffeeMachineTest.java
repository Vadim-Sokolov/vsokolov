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
        assertThat(result[1], is(1));
    }

    @Test
    public void isEnough() {
        CoffeeMachine cm = new CoffeeMachine();
        boolean result = cm.isEnough(20, 5);
        assertThat(result, is(true));
    }
}