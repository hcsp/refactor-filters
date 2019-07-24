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

    public static List<User> filter(List<User> users,Predicate<User> predicate){
        List<User> results = new ArrayList<>();
        for (User user : users){
            if (predicate.test(user)){
                results.add(user);
            }
        }
        return results;
    }//抽象的过滤器函数

//    public static List<User> filter(List<User> users,Judge condition){
//        List<User> results = new ArrayList<>();
//        for (User user : users){
//            if (condition.MeetTheConditions(user)){
//                results.add(user);
//            }
//        }
//        return results;
//    }


//    private interface Judge{//一个类里面没有方法体，就是一个接口
//        boolean MeetTheConditions(User user);
//
//    }
//    private static class IdIsEvenNumber implements Judge{
//
//        @Override
//        public boolean MeetTheConditions(User user) {
//            return user.id % 2 == 0;
//        }
//    }

    // 过滤ID为偶数的用户
    public static List<User> filterUsersWithEvenId(List<User> users) {
        return filter(users, (Predicate<User>) user -> user.id % 2 == 0);//匿名内部类
//        List<User> results = new ArrayList<>();
//        for (User user : users) {
//            if (user.id % 2 == 0) {
//                results.add(user);
//            }
//        }
//        return results;
    }

    // 过滤姓张的用户
    public static List<User> filterZhangUsers(List<User> users) {
        return filter(users, new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.name.startsWith("张");
            }
        });
//        List<User> results = new ArrayList<>();
//        for (User user : users) {
//            if (user.name.startsWith("张")) {
//                results.add(user);
//            }
//        }
//        return results;
    }

    // 过滤姓王的用户
    public static List<User> filterWangUsers(List<User> users) {
        return filter(users, new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.name.startsWith("王");
            }
        });
//        List<User> results = new ArrayList<>();
//        for (User user : users) {
//            if (user.name.startsWith("王")) {
//                results.add(user);
//            }
//        }
//        return results;
    }
    // 你可以发现，在上面三个函数中包含大量的重复代码。
    // 请尝试通过Predicate接口将上述代码抽取成一个公用的过滤器函数
    // 并简化上面三个函数
    //判断是否满足一个条件使用Predicate
//    public static List<User> filter(List<User> users, Predicate<User> predicate) {
//
//    }
}
