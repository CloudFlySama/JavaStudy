package com.itheima.demo01.Homework01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*需求：
1.使用代码完成：获取系统的当前时间并输出，输出格式：2017年11月24日
2.使用代码完成：获取键盘录入的时间转换成Date对象并输出，录入格式：2017年11月24日，如格式不正确需提示日期格式异常并打印异常信息
3.使用代码完成：使用Calendar类获取系统的当前日期并输出，输出格式：2017年11月24日

* */
public class homework01 {
    public static void main(String[] args) throws ParseException {
        //使用代码完成：获取系统的当前时间并输出，输出格式：2017年11月24日
        Date d = new Date();
        System.out.println(d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String s = sdf.format(d);
        System.out.println(s);
//        使用代码完成：获取键盘录入的时间转换成Date对象并输出，录入格式：2017年11月24日
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入时间,录入格式：2017年11月24日");
        String s1 = sc.next();
        SimpleDateFormat sdf2 = new SimpleDateFormat(s1);
        Date parse = sdf.parse(s1);
        System.out.println(parse);
//        使用Calendar类获取系统的当前日期并输出，输出格式：2017年11月24日
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH ,+ 1);
        System.out.println(calendar.get(Calendar.YEAR) + "年" + calendar.get(Calendar.MONTH ) + "月" + calendar.get(Calendar.DAY_OF_MONTH) + "日");
    }
}

