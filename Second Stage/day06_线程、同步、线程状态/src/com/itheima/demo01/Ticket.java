package com.itheima.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable{
    int ticket = 100;

    @Override
    public void run() {
        Lock lock = new ReentrantLock();
        while(true){
            synchronized (this){
                if(ticket > 0){
                   //
                        //Thread.sleep(200);
                        System.out.println(Thread.currentThread().getName() + "号窗口正在卖出第" + ticket-- + "张票");
                    //} catch (InterruptedException e) {
                    //    e.printStackTrace();
                    //}
                }else{
                    break;
                }
            }
        }
    }
}

