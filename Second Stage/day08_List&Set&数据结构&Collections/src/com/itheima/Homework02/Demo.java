package com.itheima.Homework02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
训练知识点：HashSet

训练描述
	定义一个Student类,包含名称,年龄,性别(姓名,年龄,性别完全相同视为同一学生)
	创建10个Student对象,至少有两个学生姓名,年龄,性别完全相同. 把这10个学生添加到Set集合中,
	不可以重复,遍历Set集合打印学生信息,使用两种方式

操作步骤描述
	1.定义一个Student类,包含名称,年龄,性别重写hashCode()和equals()方法
	2.创建HashSet集合
	3.使用Student类创建10个学生,把这10个学生添加到Set集合中
	4.使用迭代器遍历HashSet
	5.使用增强for遍历集合
* */
public class Demo {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>();
        students.add(new Student("赵云帆",22,"男"));
        students.add(new Student("孙志良",22,"男"));
        students.add(new Student("周满仓",22,"男"));
        students.add(new Student("职鹏宇",22,"男"));
        students.add(new Student("赵云帆",22,"男"));
        students.add(new Student("杨云飞",21,"女"));
        students.add(new Student("周满仓",22,"男"));
        students.add(new Student("张昭",23,"男"));
        students.add(new Student("张超",22,"未知"));
        students.add(new Student("霍周林",20,"男"));
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()){
            Student s = iterator.next();
            System.out.println(s);
        }
        System.out.println("--------------------------------------");
        for (Student student : students) {
            System.out.println(student);
        }

    }
}
