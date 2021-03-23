package com.github.hcsp.polymorphism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class User {
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

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
        return filter(users, new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.id % 2 == 0;
            }
        });
    }

    // 过滤姓张的用户
    public static List<User> filterZhangUsers(List<User> users) {
        return filter(users, user -> user.name.startsWith("张"));
    }

    // 过滤姓王的用户
    public static List<User> filterWangUsers(List<User> users) {
        return filter(users, new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.name.startsWith("王");
            }
        });
    }

    // 你可以发现，在上面三个函数中包含大量的重复代码。
    // 请尝试通过Predicate接口将上述代码抽取成一个公用的过滤器函数
    // 并简化上面三个函数
    public static List<User> filter(List<User> users, Predicate<User> predicate) {
        List<User> results = new ArrayList<>();
        for (User user : users) {
            if (predicate.test(user)) {
                results.add(user);
            }
        }
        return results;
    }

//    private interface 判断条件是否成立 {
//        boolean 这个用户是否满足条件(User user);
//    }
//
//    private static class 过滤姓王的用户 implements  判断条件是否成立{
//        @Override
//        public boolean 这个用户是否满足条件(User user) {
//            return user.name.startsWith("王");
//        }
//    }
//
//    public static List<User> filter(List<User> users, 判断条件是否成立 条件) {
//        System.out.println(条件 instanceof 过滤姓王的用户);
//        System.out.println(条件 instanceof  判断条件是否成立);
//        List<User> results = new ArrayList<>();
//        for (User user : users) {
//            if (条件.这个用户是否满足条件(user)) {
//                results.add(user);
//            }
//        }
//        return results;
//    }
//
//    // 过滤姓王的用户
//    public static List<User> filterWangUsers(List<User> users) {
//        return filter(users, new 过滤姓王的用户());
//    }

    public static void main(String[] args) {
        List<User> list = filterWangUsers(Arrays.asList(new User(1, "王"), new User(2, "王")));
        System.out.println(list);
    }

}
