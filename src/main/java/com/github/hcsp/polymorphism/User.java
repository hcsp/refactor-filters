
package com.github.hcsp.polymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//建立一个User类，包涵Id和Name两个参数。
//实现predicate接口，用以过滤User中Id为偶数，以及name姓张的，和姓王的。
//首先需要抽取出其中相通的方法，形成一个过滤器函数
//接下来去写每一种过滤器函数
//最后获取所有的过滤结果
public class User{
    private final Integer id;
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
    //定义好User对象，以及对象中的参数的构造器
    public static List<User> filterUserWithEvenId(List<User> list){
        return filter(list, user -> (user.id %2==0));
    }//实现对偶数进行过滤

    public static List<User> filterUserNameStartwithWang(List<User> list) {
        return filter(list, user -> user.name.startsWith("王"));
    }//实现对姓王的进行过滤

    public static List<User> filterUserNameStartwithZhang(List<User> list) {
        return filter(list, user -> user.name.startsWith("张"));
    }//实现对姓张的进行过滤



    //下面这个函数用以实现过滤器方法
    public static List<User> filter(List<User> list, Predicate<User> predicate){
        List<User> Result =new ArrayList<>();
        for (User user:list
             ) {
            if (predicate.test(user)){
                Result.add(user);
            }
        }
        return Result;
    }
}