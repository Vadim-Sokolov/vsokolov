package ru.job4j.monitoresynchronized;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vsokolov
 * @version $iD$
 * @since 0.1
 */
@ThreadSafe
public class UserStorage {

    @GuardedBy("this.users")
    private final List<User> users = new ArrayList<>();

    public boolean add(User user) {
        boolean result = true;
        synchronized (this.users) {
            if (!this.users.contains(user)) {
                this.users.add(user);
            } else {
                result = false;
            }
        }
        return result;
    }

    public boolean update(User user) {
        boolean result = true;
        synchronized (this.users) {
            if (this.users.contains(user)) {
                getUserById(user.getId()).setAmount(user.getAmount());
            } else {
                result = false;
            }
        }
        return result;
    }

    public boolean delete(User user) {
        boolean result = true;
        synchronized (this.users) {
            if (this.users.contains(user)) {
                this.users.remove(user);
            } else {
                result = false;
            }
        }
        return result;
    }

    public void transfer(int fromId, int toId, int amount) {
        synchronized (this.users) {
            if (getUserById(fromId) != null && getUserById(toId) != null) {
                User from = getUserById(fromId);
                User to = getUserById(toId);
                from.setAmount(from.getAmount() - amount);
                to.setAmount(to.getAmount() + amount);
            }
        }
    }

    public List<User> getUsers() {
        return this.users;
    }

    public User getUserById(int id) {
        User result = null;
        synchronized (this.users) {
            for (User u : this.users) {
                if (id == u.getId()) {
                    result = u;
                }
            }
        }
        return result;
    }
}
