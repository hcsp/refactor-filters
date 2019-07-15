package com.github.hcsp.polymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class User {
    /** 用户ID，数据库主键，全局唯一 */
    private final Integer id;

    /** 用户名 */
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

        public static List<User> filterUsersWithEvenId(List<User> users) {
        return filter(users, new filterUsersWithEvenId());
    }
    static class filterUsersWithEvenId implements Predicate<User> {
        @Override
        public boolean test(User o) {
            return user.getId() % 2 == 0;
        }
    }
    public static List<User> filterZhangUsers(List<User> users) {
        return filter(users, new filterZhangUsers());
    }
    static class filterZhangUsers implements Predicate<User> {
        @Override
        public boolean test(User o) {
            return o.getName().startsWith("张");
        }
    }
    public static List<User> filterWangUsers(List<User> users) {
        return filter(users, new filterWangUsers());
    }
    static class filterWangUsers implements Predicate<User> {
        @Override
        public boolean test(User o) {
            return o.getName().startsWith("王");
        }
    }
    
    public static List<User> filter(List<User> users, Predicate<User> predicate) {
        List<User> results = new ArrayList<>();
        for (User user : users) {
            if (predicate.test(user)) { // 此处应用多态
                results.add(user);
            }
        }
        return results;
    }
}
