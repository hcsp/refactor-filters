package com.github.hcsp.polymorphism;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

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




/*    public static class 偶数 implements 判断条件 {
        @Override
        public boolean 判断用户满足条件(User user) {
            return user.id % 2 == 0;
        }
    }*/
/*    public static class 姓张 implements 判断条件 {
        @Override
        public boolean 判断用户满足条件(User user) {
            return user.name.startsWith("张");
        }
    }*/

    // 过滤ID为偶数的用户
    public static List<User> filterUsersWithEvenId(List<User> users) {
        return filter(users, new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.id % 2 == 0 ;
            }
        });
    }
 /*       List<User> results = new ArrayList<>(); //结果接收器
        for (User user : users) {               // for遍历查找
            if (user.id % 2 == 0) {
                results.add(user);              //符合条件 结果+到列表中去
            }
        }
        return results;                        //返回新的列表
    }*/

        // 过滤姓张的用户
    public static List<User> filterZhangUsers (List<User> users) {
        return filter(users, new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.name.startsWith("张");
            }
    });
    }

        // 过滤姓王的用户
        public static List<User> filterWangUsers (List < User > users) {
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
        public static List<User> filter(List<User> users, Predicate<User> predicate){
            List<User> results = new ArrayList<>();
            for (User user : users) {
                if (predicate.test(user)) {
                    results.add(user);
                   // System.out.println(user.id);
                }
            }
            return results;
        }

/*    public static void main(String[] args) {
        filterUsersWithEvenId(Arrays.asList(new User(1,"李"),new User(2,"王")));
    }*/
}
