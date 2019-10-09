package com.itheima.demo03;

import java.util.ArrayList;

public class Cave extends Thread implements Runnable{
    private static ArrayList<Person> list = new ArrayList();
    private int person;
    private String personName;
    private int ThroughOrder;
    int i = 1;
    Person p = new Person();
    @Override
    public void run() {
        Person p = new Person("孙志良");
        Person p1 = new Person("周满仓");
        Person p2 = new Person("赵云帆");
        Person p3 = new Person("职鹏宇");
        list.add(p);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        while(true){
            synchronized (list){
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (person == 0){
                    list.add(i,p);
                    System.out.println("山洞正在过第" + i++ + "个人");
                    list.notify();
                }else{
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }
}
