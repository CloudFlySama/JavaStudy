package com.itheima.demo01.demo07;

import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        Student stu1 = new Student("赵云帆",18);
        System.out.println(stu1);
        Student stu2 = new Student("孙志良",22);
        Student stu3 = new Student("孙志良",22);
        boolean flag1 = stu1.equals(stu2);
        boolean flag2 = stu3.equals(stu2);
        System.out.println(flag1);
        System.out.println(flag2);
    }
}
