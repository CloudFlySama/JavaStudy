package com.itheima.demo01;

public class Test {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket,"1");
        Thread thread2 = new Thread(ticket,"2");
        Thread thread3 = new Thread(ticket,"3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
