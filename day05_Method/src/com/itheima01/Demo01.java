package com.itheima01;

public class Demo01 {
    public static void main(String[] args) {
        System.out.println("开始");
        isEvenNumber();
        System.out.println("结束");
    }
    public static void isEvenNumber(){
        int number = 10;
        if(number % 2 ==0){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
