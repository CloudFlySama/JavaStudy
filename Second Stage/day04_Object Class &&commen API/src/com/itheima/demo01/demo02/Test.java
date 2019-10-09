package com.itheima.demo01.demo02;

public class Test {
    public static void main(String[] args) {
        Demo01 d1 = new Demo01();
        d1.setAge(18);
        Demo01 d2 = new Demo01();
        d2.setAge(17);
        //判断d1.age与d2的age比较结果
        System.out.println(d1.equals(d2));
    }
}
