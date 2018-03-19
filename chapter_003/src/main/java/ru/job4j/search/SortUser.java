package ru.job4j.search;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import static java.lang.Integer.compare;

public class SortUser {

    public Set<User> sort(List<User> users) {
        Comparator<User> comp = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.age > o2.age ? 1 : o1.age < o2.age ? -1 : 0;
            }
        };
        TreeSet<User> result = new TreeSet<>(comp);
        for (User user : users) {
            result.add(user);
        }
        return result;
    }
}
