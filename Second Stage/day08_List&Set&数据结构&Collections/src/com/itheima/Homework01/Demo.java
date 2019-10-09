package com.itheima.Homework01;

import java.util.ArrayList;
import java.util.HashSet;

/*
训练考核知识点：

1.使用代码完成：往HashSet中添加字符串"zhangsan", "lisi", "wangwu", "zhangsan".使用迭代器获取HashSet中的元素
	   操作步骤提示：
		1.创建HashSet集合
		2.使用add方法往HashSet添加元素
		3.使用迭代器获取HashSet中的元素

2.请简述HashSet去除重复元素的原理
3.使用代码完成：向HashSet集合添加姓名{张三,李四,王五,二丫,钱六,孙七},将二丫删除,添加王小丫
4.简述List与Set集合的区别
5.请简述ArrayList、LinkList和HashSet的特点
* */
public class Demo {
    public static void main(String[] args) {
        /*HashSet<String> list = new HashSet<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        list.add("zhangsan");
        for (String s : list) {
            System.out.println(s);
        }*/
        //2.请简述HashSet去除重复元素的原理:Hashcode 和 equals
//        使用代码完成：向HashSet集合添加姓名{张三,李四,王五,二丫,钱六,孙七},将二丫删除,添加王小丫
        HashSet<String> list = new HashSet<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("二丫");
        list.add("钱六");
        list.add("孙七");
        list.remove("二丫");
        list.add("王小丫");
//        4.简述List与Set集合的区别
        /*
        * List:有序性,有索引,可重复
        * 而set以某种规则规定其中元素不可重复
        * */
//        请简述ArrayList、LinkList和HashSet的特点
        /*ArrayList:其内部原理为数组:查找快,增删慢
        LinkdeList:其原理内部为链表:增删快,查找慢
        HashSet:以Hashmap为基础,具有良好的存储和查找功能,保证了数据不可重复性
        * */
    }
}
