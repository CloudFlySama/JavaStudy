package com.itheima.demo01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

//List接口的常用方法
//list的特点: 有序性 有索引值 可重复
public class Demo{
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("javaee");
        list.add("javase");
        list.add("hello");
        System.out.println(list);
        list.remove("java");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.get(0));
        list.set(0,"666");
        System.out.println(list);
    }

}
