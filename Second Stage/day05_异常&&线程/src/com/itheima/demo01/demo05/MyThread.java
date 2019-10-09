package com.itheima.demo01.demo05;

public class MyThread extends Thread{
    public MyThread(String target) {
        super(target);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("杨云飞");
        }
    }
}
