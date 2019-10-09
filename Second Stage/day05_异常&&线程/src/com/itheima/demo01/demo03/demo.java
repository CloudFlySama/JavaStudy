package com.itheima.demo01.demo03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) throws ParseException {
        //用户输入生日
        System.out.println("请输入你的生日 输入格式 例:1997-12-17");
        Scanner sc = new Scanner(System.in);
        String birthday = sc.next();
        //创建sdf对象 将用户输入的生日String转化为date类型
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        Date bir = sdf.parse(birthday);
        System.out.println(bir);
        //日期对象转化为毫秒
        long l1 = bir.getTime();
        //获取当前系统的毫秒值
        Date now = new Date();
        long l2 = now.getTime();
        //计算差值
        long day = l2 - l1;
        double lifeDay = day /1000 /60 /60 /24;
        System.out.println("你活了" + lifeDay + "天");

    }
}
