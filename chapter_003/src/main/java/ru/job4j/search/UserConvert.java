package ru.job4j.search;

import java.util.HashMap;
import java.util.List;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class UserConvert {
    /**
     * Method takes a list of Users and converts it to a Map
     * with key Integer id and the corresponding User.
     * @param list - list to be converted
     * @return - result
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
