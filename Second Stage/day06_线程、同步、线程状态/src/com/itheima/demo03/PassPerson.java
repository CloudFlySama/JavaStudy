package com.itheima.demo03;

import java.util.ArrayList;

public class PassPerson extends Thread implements Runnable{
    private ArrayList<Person> list = new ArrayList();
    private int person;
    Person p = new Person();
    int i = 1;
    @Override
    public void run() {
        Person p1 = new Person("孙志良");
        Person p2 = new Person("周满仓");
        Person p3 = new Person("赵云帆");
        Person p4 = new Person("职鹏宇");
        list.add(p1);
        list.add(p4);
        list.add(p2);
        list.add(p3);
        while(true){
            synchronized (list){
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (person > 0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    list.add(i,p);
                    System.out.println("第" + (i++) + "通过的人是"  +  Thread.currentThread().getName());
                    list.notify();
                }
                System.out.println(list);
            }

        }

    }
}
