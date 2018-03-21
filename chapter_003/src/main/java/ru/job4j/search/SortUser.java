package ru.job4j.search;

import java.util.*;

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

    /**
     * Method defines a Comparator for Collections.sort
     * and sorts a List<User> by name length
     * @param list - list to be sorted
     * @return the result
     */
    public List<User> sortNameLength(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User a, User b) {
                return Integer.compare(a.getName().length(), b.getName().length());
            }
        });
        return list;
    }
    /**
     * Method defines a Comparator for Collections.sort
     * and sorts a List<User> alphabetically and by age for matching names.
     * @param list - list to be sorted
     * @return the result
     */
    public List<User> sortByAllFields(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User a, User b) {
                int result = a.getName().compareTo(b.getName());
                if (result == 0) {
                    result = Integer.compare(a.age, b.age);
                }
                return result;
            }
        });
        return list;
    }
}
