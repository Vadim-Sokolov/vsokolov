package ru.job4j.search;

import static java.lang.Integer.compare;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class User implements Comparable<User> {

    private int id;
    private String name;
    private String city;
    protected int age;

    public User(int id, String name, String city, int age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(User o) {
        return compare(this.age, o.age);
    }
}
