package com.itheima01;
//StringBuilder 类
public class Demo08 {
    public static void main(String[] args) {
        String sc = "hello";
        StringBuilder sb = new StringBuilder(sc);
        //原字符串基础上拼接 world java 100 8.8
        sb.append("world").append("java").append(100).append(8.8);
        //反转
        sb.reverse();
        //StringBuilder -> String 1.调用toString方法
        String result = sb.toString();
        System.out.println(result);
    }
}
