package com.itheima.demo03;

import java.util.ArrayList;

//        1.这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒；
//        2.随机生成10个人，同时准备过此山洞，并且定义一个变量用于记录通过隧道的人数。
//        显示每次通过山洞人的姓名，和通过顺序；
//////未完成!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class Demo {
    private static ArrayList<Person> list = new ArrayList<>();
    public static void main(String[] args) {

        Cave shandong = new Cave();
        shandong.start();
        PassPerson passPerson = new PassPerson();
        passPerson.start();
    }
}
