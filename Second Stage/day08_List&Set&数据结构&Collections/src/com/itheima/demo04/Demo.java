package com.itheima.demo04;

import java.util.HashSet;

public class Demo {
    //HashSet练习 : 无序的,不能重复
    public static void main(String[] args) {
        HashSet<String> list = new HashSet<>();
        list.add("Java");
        list.add("Javaee");
        list.add("Javase");
        list.add("Hello");
        System.out.println(list);
        list.add("Java");
        System.out.println(list);
        HashSet<Student> list1 = new HashSet<>();
        list1.add(new Student("jack",12));
        list1.add(new Student("rose",14));
        list1.add(new Student("jack",12));
        list1.add(new Student("lucy",22));
        list1.add(new Student("tom",21));
        for (Student student : list1) {
            System.out.println(student);
        }
    }
}
