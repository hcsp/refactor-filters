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
//    public static void main(String[] args) {
//        filterUsersWithEvenId(Arrays.asList(new User(1, "a"), new User(2, "b")));
//    }

    // 过滤ID为偶数的用户
    // 对过滤后的处理进行了剥离
    public static List<User> filterUsersWithEvenId(List<User> users) {
//        Predicate接口
        return filter(users, new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.id % 2 == 0;
            }
        });
        // 使用匿名类的代码
//        return filter(users,
//                new 接口_判断() {
//                    @Override
//                    public boolean 方法_多态_是否满足(User user) {
//                        return user.id % 2 == 0;
//                    }
//                });
        // 使用内部类的代码
//        return filter(users, new class_偶数());
    }

    public static List<User> filter(List<User> users, Predicate<User> userPredicate) {
        List<User> results = new ArrayList<>();
        for (User user :
                users) {
            if (userPredicate.test(user)) {
                results.add(user);
                // 打印出过滤出来的
                System.out.println(user.id + user.name);
            }
        }
        return results;
    }

//     filter函数的实现 用我自己建的接口和类的方法
//    public static List<User> filter(List<User> users, 接口_判断 条件) {
//        List<User> results = new ArrayList<>();
//        for (User user :
//                users) {
//            if (条件.方法_多态_是否满足(user)) {
//                results.add(user);
//                // 打印出过滤出来的
//                System.out.println(user.id + user.name);
//            }
//        }
//        return results;
//    }

//    private interface 接口_判断 {
//        boolean 方法_多态_是否满足(User user);
//    }

//    private static class class_偶数 implements 接口_判断 {
//
//        @Override
//        public boolean 方法_多态_是否满足(User user) {
//            return user.id % 2 == 0;
//        }
//
//    }

}
