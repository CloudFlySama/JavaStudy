package com.itheima01;

public class Demo03 {
    public static void main(String[] args) {
        isEvenNumber(10);
        int number = 10;
        isEvenNumber(number);
    }
    public static void isEvenNumber(int number){
        if (number%2 == 0){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
