package com.itheima.demo01.demo06;

public class Demo01 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000 ; i++) {
            System.out.println("我爱黄焖鸡");
        }
        long end = System.currentTimeMillis();
        System.out.println("10000次循环需要的时间为" + (end - start));
    }
}
