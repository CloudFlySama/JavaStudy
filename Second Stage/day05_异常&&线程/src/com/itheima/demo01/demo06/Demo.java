package com.itheima.demo01.demo06;

public class Demo {
    public static void main(String[] args) {
        MyThread thread = new MyThread("main线程");
        thread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("main线程执行");
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + i);
                }
            }
        },"xinxiancheng").start();
    }
}
