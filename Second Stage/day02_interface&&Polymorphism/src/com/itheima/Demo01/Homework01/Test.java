package com.itheima.Demo01.Homework01;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Tiger tiger = new Tiger(2,4,"老虎","羊");
        Pecker pecker = new Pecker(1,2,"啄木鸟","昆虫");
        Giraffe giraffe = new Giraffe(3,4,"长颈鹿","树叶");
        Rabbit rabbit = new Rabbit(1,4,"兔子","狗尾草");
        tiger.eat();
        pecker.eat();
        giraffe.eat();
        rabbit.eat();
    }
}
