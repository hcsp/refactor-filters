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

    //判断条件是否成立的接口
    public interface ConditionInterface {
        boolean conditionWay(User user);

    }

    //根据传入的不同过滤方法来过滤数组
    public static List<User> filter(List<User> users, Predicate<User> ci) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (ci.test(user)) {
                result.add(user);
            }
        }
        return result;
    }

    // 过滤ID为偶数的用户
    public static List<User> filterUsersWithEvenId(List<User> users) {
        List<User> results = filter(users, new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.id % 2 == 0;
            }
        });
        return results;
    }

    public static void main(String[] args) {
        List<User> results = filterZhangUsers (Arrays.asList(new User(1, "a"), new User(2, "a"), new User(3, "a")));
        System.out.println(Arrays.toString(results.toArray()));
    }

    // 过滤姓张的用户
    public static List<User> filterZhangUsers(List<User> users) {
        List<User> results = filter(users, new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.name.startsWith("张");
            }
        });
        return results;
    }

    // 过滤姓王的用户
    public static List<User> filterWangUsers(List<User> users) {
        List<User> results = filter(users, new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.name.startsWith("王");
            }
        });
        return results;
    }
    // 你可以发现，在上面三个函数中包含大量的重复代码。
    // 请尝试通过Predicate接口将上述代码抽取成一个公用的过滤器函数
    // 并简化上面三个函数
//    public static List<User> filter(List<User> users, Predicate<User> predicate) {}
}
