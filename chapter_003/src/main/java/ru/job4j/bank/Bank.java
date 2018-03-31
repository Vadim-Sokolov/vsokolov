package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Bank {

    private TreeMap<User, ArrayList<Account>> treemap = new TreeMap<>();

    public void addUser(User user) {
        this.treemap.put(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.treemap.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        this.treemap.get(getUserByPassport(passport)).add(account);
    }

    private Account getActualAccount(User user, Account account) {
        ArrayList<Account> list = this.treemap.get(user);
        return list.get(list.indexOf(account));
    }

    public void deleteAccountFromUser(String passport, Account account) {
        this.treemap.get(getUserByPassport(passport)).remove(account);
    }

    public List<Account> getUserAccounts(String passport) {
        return this.treemap.get(getUserByPassport(passport));
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dstRequisite, double amount) {
        return this.treemap.get(getUserByPassport(srcPassport)).contains(getAccountByRequisites(srcRequisite))
                && this.treemap.get(getUserByPassport(destPassport)).contains(getAccountByRequisites(dstRequisite))
                && getActualAccount(getUserByPassport(srcPassport), getAccountByRequisites(srcRequisite)).transfer(
                getActualAccount(getUserByPassport(destPassport), getAccountByRequisites(dstRequisite)), amount);
    }

    public User getUserByPassport(String passport) {
        User result = new User("not found", "not found");
        for (Map.Entry<User, ArrayList<Account>> entry : this.treemap.entrySet()) {
            User key = entry.getKey();
            if (key.getPassport().equals(passport)) {
                result = key;
            }
        }
        return result;
    }

    public Account getAccountByRequisites(String requisites) {
        Account result = new Account(0, "not found");
        for (Map.Entry<User, ArrayList<Account>> entry : this.treemap.entrySet()) {
            for (Account acc : entry.getValue()) {
                if (acc.getRequisites().equals(requisites)) {
                    result = acc;
                }
            }
        }
        return result;
    }
    public String toString() {
        return "Bank{" + "accounts=" + treemap + "}";
    }
}