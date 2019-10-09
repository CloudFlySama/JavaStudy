package com.itheima.demo01.demo05;

import java.util.Calendar;
import java.util.Date;

public class Demo01 {
    public static void main(String[] args) {
        //public static Calendar getInstance() ：使用默认时区和语言环境获得一个日历
        //创建Canendar对象
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);
        //获取年
        int year = cal.get(Calendar.YEAR);
        //设置时间为2020年
        cal.set(Calendar.YEAR,2020);
        //修改时间为2000年(-20年)
        cal.add(Calendar.YEAR,-20);
        //将Calendar对象转化为Date对象
        Date d = cal.getTime();
        System.out.println(d);

    }

}
