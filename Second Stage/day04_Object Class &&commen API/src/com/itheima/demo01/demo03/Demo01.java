package com.itheima.demo01.demo03;
//java.util.Date 类 表示特定的瞬间，精确到毫秒。
import java.util.Date;

public class Demo01 {
    public static void main(String[] args) {
        //public Date() ：从运行程序的此时此刻到时间原点经历的毫秒值,转换成Date对象
        System.out.println(new Date());
        System.out.println(new Date(0L));
    }
}
