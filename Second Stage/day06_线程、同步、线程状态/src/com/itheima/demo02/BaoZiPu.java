package com.itheima.demo02;

import java.util.ArrayList;

public class BaoZiPu extends Thread{
    private ArrayList<Integer> list;
    public BaoZiPu(String name, ArrayList<Integer> list) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        int i = 0;
        while (true){
            synchronized (list){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (list.size() > 0){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    list.add(i++);
                    System.out.println("包子数量" + list.size());
                    list.notify();
                }
            }
        }
    }
}
