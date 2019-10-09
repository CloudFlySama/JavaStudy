package com.itheima.Demo01.Homework02;

public class Test {
    public static void main(String[] args) {
        Boy boy = new Boy(23,1.8,"职鹏宇","杨云飞");
        Girl girl = new Girl(18,1.65,"杨云飞","瓜子脸","职鹏宇");
        Clothes clothes = new Clothes("黑色","耐克");
        boy.walk();
        boy.speak("要傻死了");
        girl.wash(clothes);
        girl.speak("哥哥,你真的好强");
    }
}
