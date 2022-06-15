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
        return filter(users, new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.id % 2 == 0;
            }
        });
    }

    // 过滤姓张的用户
    public static List<User> filterZhangUsers(List<User> users) {
        return filter(users, new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.name.startsWith("张");
            }
        });
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
    /**
     * 由于老师没有在UserTest中写测试用例，我便自己写了个测试用例
     */
    public static void main(String[] args) {
        List<User> users =
                Arrays.asList(
                        new User(1, "张三"), new User(2, "李四"), new User(3, "王五"));

        System.out.println("过滤出的ID为偶数的用户："+ User.filterUsersWithEvenId(users));
        System.out.println("过滤出的张姓用户："+ User.filterZhangUsers(users));
        System.out.println("过滤出的王姓用户："+ User.filterWangUsers(users));
    }
    /**
     * 重写User类型的toString方法
     */
    @Override
    public String toString(){
        return "id:"+this.id + ",name:"+this.name;
    }
}
