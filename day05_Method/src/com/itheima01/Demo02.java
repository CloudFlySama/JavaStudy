package com.itheima01;

public class Demo02 {
    public static void main(String[] args) {
        getMax(10,20);

        int a = 30;
        int b = 40;
        getMax(a,b);
    }
    public static void getMax(int a,int b){
        if(a > b){
            System.out.println(a);
        }else{
            System.out.println(b);
        }
    }
}
