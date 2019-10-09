package com.itheima.demo01.demo04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
* 需求：
1.使用代码完成：获取系统的当前时间并输出，输出格式：2017年11月24日
2.使用代码完成：获取键盘录入的时间转换成Date对象并输出，录入格式：2017年11月24日，如格式不正确需提示日期格式异常并打印异常信息
3.使用代码完成：使用Calendar类获取系统的当前日期并输出，输出格式：2017年11月24日
* */
public class demo {
    public static void main(String[] args) {
        //需求1
        Date d= new Date();
        d.getTime();
        System.out.println(d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd天");
        String s = sdf.format(d);
        System.out.println(s);
        //需求2
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入时间 格式为xxxx年xx月xx日");
        String s2 = sc.next();
        Date d3 = null;
        try {
            d3 = sdf.parse(s2);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("格式为xxxx年xx月xx日");
            String s3 =e.getMessage();
            System.out.println(s3);
        }
        System.out.println(d3);
        //需求3
        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime());
    }
}
