package com.github.hcsp.polymorphism;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
public class User {
    private final Integer id;
    private final String name;
    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public static List<User> filter(List<User> users, Predicate<User> predicate) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (predicate.test(user)) {
                result.add(user);
            }
        }
        return result;
    }
}
