package com.itheima.demo01.demo05;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//案例 获取任意年份的2月有多少天
public class Demo02 {
    public static void main(String[] args) {
        //获取键盘录入的年份
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份");
        int yearInput = sc.nextInt();
        //设置日历的年月日
        Calendar cal = Calendar.getInstance();
        cal.set(yearInput,2,1);
        //3月1日前推一天就是2月
        cal.add(Calendar.DATE,-1);
        //获取这一天输出
        int d = cal.get(Calendar.DATE);
        System.out.println(yearInput + "的2月有" + d + "天");
    }
}
