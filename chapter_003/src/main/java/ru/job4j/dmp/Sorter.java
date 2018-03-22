package com;

// комментариев нет
import java.util.*;

public class Sorter {

    //'{' is not preceded with whitespace.
    public Sorter(){ // дефолтный конструктор не нужен

    }

    Set<User> sort (List<User> list) { //'(' is preceded with whitespace.
        TreeSet<User> sortedList = new TreeSet<>();
        sortedList.addAll(list);
        return sortedList;
    }

    List<User> sortnamelength (List<User> list) { //'(' is preceded with whitespace.
        Comparator<User> compar = new Comparator<User>() { // неправильное название
            @Override
            public int compare (User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        };
        list.sort(compar);
        return list;
    }

    List<User> sortboth (List<User> list) {//'(' is preceded with whitespace.
        Comparator<User> compar1 = new Comparator<User>() { // неправильное название
            @Override//'(' is preceded with whitespace.
            public int compare (User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<User> compar2 = new Comparator<User>() { // неправильное название
            @Override//'(' is preceded with whitespace.
            public int compare (User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        list.sort(compar1.thenComparing(compar2));
        return list;
    }
}