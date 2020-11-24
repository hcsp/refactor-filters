package com.github.hcsp.polymorphism;

import java.util.ArrayList;
import java.util.Arrays;
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

    // 过滤ID为偶数的用户
    public static List<User> filterUsersWithEvenId(List<User> users) {
        return filter( users, new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.id % 2 == 0;
            }
        } );
    }

    // 过滤姓张的用户
    public static List<User> filterZhangUsers(List<User> users) {
        return filter( users, new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.name.startsWith( "张" );
            }
        } );
    }

    // 过滤姓王的用户
    public static List<User> filterWangUsers(List<User> users) {
        //在使用时传入匿名内部类 以及实现条件表达式
        return filter( users, new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.name.startsWith( "王" );
            }
        } );
    }
    // 你可以发现，在上面三个函数中包含大量的重复代码。
    // 请尝试通过Predicate接口将上述代码抽取成一个公用的过滤器函数
    // 并简化上面三个函数
    public static List<User> filter(List<User> users, Predicate<User> predicate) {
        List<User> result = new ArrayList<>();
        //函数式方法接口提供test表达式判断方法 外部调用方法可直接使用函数表达式入参
        users.forEach( user -> {
            if(predicate.test( user )) {
                result.add( user );
            }
        } );
        return result;
    }
}
