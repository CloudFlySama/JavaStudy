package com.itheima.demo01.demo05;

public class Demo {
    public static void main(String[] args) {
        MyThread m = new MyThread("yyf");
        System.out.println(m.getName());
        m.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main线程执行了！" + i);
         }

    }
}
