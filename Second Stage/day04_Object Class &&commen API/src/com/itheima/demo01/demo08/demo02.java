package com.itheima.demo01.demo08;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class demo02 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        Date d = new Date();
        String s = sdf.format(d);
        System.out.println(s);
    }


}
