package com.itheima.demo06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Collections类常用功能
//public static void shuffle(List<?> list) :打乱集合顺序。
// public static <T> void sort(List<T> list) :将集合中元素按照默认规则排序。 【自然排序】
// public static <T> void sort(List<T> list，Comparator<? super T> ) :将 集合中元素按照指定规则排序
public class Demo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("java");
        list.add("javaee");
        list.add("javase");
        list.add("Hello");
        list.add("World");
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
