package com.github.hcsp.polymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        return filter(users, x -> x.id % 2 == 0);
        //return users.stream().filter(x -> x.id % 2 == 0).collect(Collectors.toList());
    }

    // 过滤姓张的用户
    public static List<User> filterZhangUsers(List<User> users) {
        return filter(users, x -> x.name.startsWith("张"));
        //return users.stream().filter(x -> x.name.startsWith("张")).collect(Collectors.toList());
    }

    // 过滤姓王的用户
    public static List<User> filterWangUsers(List<User> users) {
        return filter(users, x -> x.name.startsWith("王"));
        //return users.stream().filter(x -> x.name.startsWith("王")).collect(Collectors.toList());
    }

    // 你可以发现，在上面三个函数中包含大量的重复代码。
    // 请尝试通过Predicate接口将上述代码抽取成一个公用的过滤器函数
    // 并简化上面三个函数
    public static List<User> filter(List<User> users, Predicate<User> predicate) {
        return users.stream().filter(predicate::test).collect(Collectors.toList());
    }
}
