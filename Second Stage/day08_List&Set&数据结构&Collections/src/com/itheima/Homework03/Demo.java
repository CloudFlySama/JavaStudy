package com.itheima.Homework03;

import java.util.ArrayList;
import java.util.HashSet;

/*
* 训练描述
ArrayList有以下元素: "a","f","b","c","a","d"
利用HashSet对ArrayList集合去重(最终结果: ArrayList中没有重复元素)

操作步骤描述
	1.创建ArrayList
	2.使用add方法往ArrayList添加元素
	3.创建HashSet.用于将ArrayList中重复的元素去除
	4.调用HashSet的addAll方法,将ArrayList中的元素添加到HashSet中
	5.清空list的所有元素
	6.将set集合中的元素再添加回ArrayList集合
* */
public class Demo {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("f");
        list1.add("b");
        list1.add("c");
        list1.add("a");
        list1.add("d");
        HashSet<String> list2 = new HashSet<>();
        list2.addAll(list1);
        list1.clear();
        list1.addAll(list2);
        System.out.println(list1);
    }
}
