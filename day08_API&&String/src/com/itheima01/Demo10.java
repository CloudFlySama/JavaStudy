package com.itheima01;

import java.util.Scanner;
//字符串的反转
//通过一个方法，将用户输入的字符串进行反转
// 例如 用户输入：abc  得到结果 cba  要求使用StringBuilder进行操作
public class Demo10 {
    public static void main(String[] args) {
        //运用Scanner进行获取用户输入字符串操作
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
//        运用函数
        String line = sc.nextLine();
        String s = myReverse(line);
//        输出结果
        System.out.println(s);

    }
    //定义一个方法来进行字符串反转
    public static String myReverse(String s){
        //使用StringBuilder来进行字符串的反转操作
        StringBuilder sb = new StringBuilder(s);
        //反转
        sb.reverse();
        //将StringBuilder转变成String
        String ss = sb.toString();
        //返回结果
        return ss;

        //链式结构
//        return  new StringBuilder(s).reverse().toString();
    }
}
