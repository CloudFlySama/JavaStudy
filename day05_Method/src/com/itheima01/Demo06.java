package com.itheima01;

public class Demo06 {
    public static void main(String[] args) {
        int result = sum(1,2);
        System.out.println(result);

        double sum = sum(1.0,2.0);
        System.out.println(sum);

        int summer = sum(1,2,3);
        System.out.println(summer);
    }
    public static int sum(int a,int b){
        return a + b;
    }
    public static double sum(double a,double b){
        return a + b;
    }
    public static int sum(int a,int b,int c){
        return a + b + c;
    }
}
