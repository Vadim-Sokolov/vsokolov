package ru.job4j.functional_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class UserConvert {

    public static class User {
        private final String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public List<User> convert(List<String> names, Function<String, User> op ) {
        List<User> users = new ArrayList<>();
        //для каждого имени выполнить функцию op.apply и результат записать в список Users
        names.forEach(n -> users.add(op.apply(n)));
        return users;
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Peter", "Nick", "Ben");
        UserConvert users = new UserConvert();
        List<User> data = users.convert(names, User::new);//User::new - преобразуется в конструктор new User(String name)
        data.forEach(System.out::println);
    }
}
