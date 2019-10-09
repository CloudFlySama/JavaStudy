package com.itheima.demo07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo {
    public static void main(String[] args) {
        Student student1 = new Student("jack",18);
        Student student2 = new Student("rose",15);
        Student student3 = new Student("Tom",22);
        Student student4 = new Student("jerry",21);
        ArrayList<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        System.out.println(list);
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //年龄降序排列
                return o1.getAge()-o2.getAge();
                //升序排列
//                o2.getAge()-o1.getAge();
            }
        });
    }
}
