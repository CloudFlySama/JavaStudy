package com.itheima.demo02;

import java.util.ArrayList;
import java.util.Collection;

public class Demo {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("c");
        list.add("c");
        System.out.println("a:" + listTest(list,"a"));
        System.out.println("c:" + listTest(list,"c"));
        System.out.println("b:" + listTest(list,"b"));

    }
    public static int listTest(Collection<String> list , String s ){
        int count = 0;
        for (String s1 : list) {
            if (s1.equals(s))
                count++;
        }
        return count;
    }
}
