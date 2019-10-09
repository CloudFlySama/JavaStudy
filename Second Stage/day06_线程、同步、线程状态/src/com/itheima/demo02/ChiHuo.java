package com.itheima.demo02;

import java.util.ArrayList;

public class ChiHuo extends Thread{
    private ArrayList<Integer> list;

    public ChiHuo(String name, ArrayList<Integer> list) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        int i = 0;
        while (true){
            synchronized (list){
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (list.size() == 0){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {

                    list.remove(0);
                    System.out.println("包子数量吃" + list.size());
                    list.notify();
                }
            }
        }
    }
}
