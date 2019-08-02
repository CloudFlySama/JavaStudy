package com.itheima01;

public class Demo05 {
    public static void main(String[] args) {
        boolean flag = isEvenNumber(10);
        System.out.println(flag);

        System.out.println(isEvenNumber(10));
    }
    public static boolean isEvenNumber(int number){
        if(number%2 == 0){
            return true;
        }else{
            return false;
        }
    }
}
