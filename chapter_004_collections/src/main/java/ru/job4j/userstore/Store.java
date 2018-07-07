package ru.job4j.userstore;

import java.util.HashMap;
import java.util.List;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Store {

    public HashMap<String, Integer> getChanges(List<User> previous, List<User> current) {
        HashMap<Integer, String> prev = new HashMap<>();
        HashMap<Integer, String> curr = new HashMap<>();
        int newUsers = 0;
        int changedUsers = 0;
        int deletedUsers = 0;
        for (User u : previous) {
            prev.put(u.getId(), u.getName());
        }
        for (User u : current) {
            curr.put(u.getId(), u.getName());
        }
        for (Integer i : prev.keySet()) {
            if (!curr.keySet().contains(i)) {
                deletedUsers++;
            } else if (!prev.get(i).equals(curr.get(i))) {
                changedUsers++;
            }
        }
        for (Integer i : curr.keySet()) {
            if (!prev.keySet().contains(i)) {
                newUsers++;
            }
        }
        HashMap<String, Integer> result = new HashMap<>();
        result.put("New Users:", newUsers);
        result.put("Changed Users:", changedUsers);
        result.put("Deleted Users:", deletedUsers);
        return result;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
