package com.itheima01;


//判断用户输入的字符串属于大写，小写和数字的哪种类型
//并输出每种字符的个数

import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串");
        //定义Scanner 用于接收用户输入的字符串
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        //定义三个统计变量 用来统计三种字符的数量 初始值为0
        int bigcount = 0;
        int smallcount = 0;
        int numcount = 0;
        //遍历字符串
        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            //判断每个字符属于那种，并进行统计
            if (a >= 'A' && a <= 'Z') {
                bigcount++;
            } else if (a >= 'a' && a <= 'z') {
                smallcount++;
            } else if (a >= '0' && a <= '9')
                numcount++;
        }
        //最后输出结果
        System.out.println("小写字符有：" + smallcount);
        System.out.println("大写字符有：" + bigcount);
        System.out.println("数字字符有：" + numcount);
    }
}
