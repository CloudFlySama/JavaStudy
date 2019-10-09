package com.itheima.demo05;

import java.util.LinkedHashSet;
    //LinkedHashSet 保证有序和不重复
public class Demo {
    public static void main(String[] args) {
        LinkedHashSet<String > list = new LinkedHashSet<>();
        list.add("java");
        list.add("javaee");
        list.add("javase");
        list.add("javaee");
        list.add("Hello");
        System.out.println(list);
    }
}
