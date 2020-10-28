package com.github.hcsp.polymorphism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class User {
    /**
     * 用户ID，数据库主键，全局唯一
     */
    private final Integer id;

    /**
     * 用户名
     */
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

    // 过滤ID为偶数的用户
    public static List<User> filterUsersWithEvenId(List<User> users) {
        return filter(users, user -> user.id % 2 == 0);
    }

    public static List<User> filter(List<User> users, Predicate<User> predicate) {
        List<User> results = new ArrayList<>();
        for (User user : users) {
            if (predicate.test(user)) {
                results.add(user);
            }
        }
        return results;
    }

}
