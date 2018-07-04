package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class UserRunner {

    public static void main(String[] args) {
        User one = new User("Steve", 1, new GregorianCalendar(2000, 10, 20));
        User two = new User("Steve", 1, new GregorianCalendar(2000, 10, 20));

        Map<User, Object> map = new HashMap<>();
        map.put(one, new Object());
        map.put(two, new Object());

        for (Map.Entry<User, Object> m : map.entrySet()) {
            System.out.println(m);
        }
    }
}
