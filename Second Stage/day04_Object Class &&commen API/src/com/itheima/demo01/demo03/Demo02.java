package com.itheima.demo01.demo03;

import java.util.Date;

public class Demo02 {
    public static void main(String[] args) {
        Date d = new Date();
        //public long getTime() 把日期对象转换成对应的时间毫秒值。
//        System.out.println(d.getTime());
//        System.out.println(d.getTime() * 1.0 / 1000 / 60 / 60 / 24 / 365 + "年");

        long time = System.currentTimeMillis();
        d.setTime(time);
        System.out.println(d);
    }


}
