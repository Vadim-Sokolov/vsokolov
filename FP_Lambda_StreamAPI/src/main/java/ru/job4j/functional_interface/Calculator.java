package ru.job4j.functional_interface;

import java.util.function.*;

public class Calculator {

    public void multiply(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op, Consumer<Double> media) {
        for (int i = start; i < finish; i++) {
            media.accept(op.apply(value, i));
        }
    }

    public static void main (String[] args) {
        Calculator c = new Calculator();

        c.multiply(0, 10, 2, MathUtil::add, result -> System.out.println(result));

        //MathUtil::add // static call
        //buffer::add // non-static call

        /*c.multiply(0, 10, 2, (value, i) -> {
                    double result = value * i;
                    System.out.printf(String.format("%nMultiply %s * %s = %s", value, i, result));
                    return result;
                },
                result -> System.out.println(result)
        );*/
    }
}
