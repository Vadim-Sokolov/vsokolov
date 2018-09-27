package ru.job4j.calculate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Calc {
    //1. Реализовать метод подсчета функции в диапазоне.
    //линейная а+б
    //квадрадичная а^2 + b^2
    // logarithmic = log(x) + log(y)

    public List<Double> calcInRange(int start, int end, Function<Double, Double> func){
        List<Double> result = new ArrayList<>();
        double target = 0;
        for (int i = start; i < end; i++) {
            result.add(func.apply(target));
        }
        return result;
    }

    public static void main(String[] args) {
        Calc c = new Calc();
        c.calcInRange(0, 10, (?) -> ? + ?);
    }
}
