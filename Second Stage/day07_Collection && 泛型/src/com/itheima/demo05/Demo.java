package com.itheima.demo05;

import java.util.ArrayList;
import java.util.Collection;

//定义一个方法listTest
//tring s),要求使用contains()方法判断al集合里面是否包含s。
public class Demo {
    private static Collection<String> list = new ArrayList<>();
    public static void main(String[] args) {

        list.add("a");
        list.add("a");
        list.add("s");
        list.add("v");
        list.add("s");
        System.out.println(judgeList("b"));
    }
    public static boolean judgeList(String s ){
        return list.contains(s);
    }
}
