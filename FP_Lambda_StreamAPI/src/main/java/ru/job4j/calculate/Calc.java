package ru.job4j.calculate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Calc {
    /*  Реализовать метод подсчета функции в диапазоне.
        линейная а+б
        квадрадичная а^2 + b^2
        logarithmic = log(x) + log(y)
    */

    public List<Double> calcInRange(int start, int end, Function<Double, Double> func){
        List<Double> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.add(func.apply((double) i));
        }
        return result;
    }
}
