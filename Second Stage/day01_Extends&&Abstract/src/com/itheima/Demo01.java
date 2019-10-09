package com.itheima;
/*
*
*
* String 类相关知识的复习
*
*
*
* */
public class Demo01 {
    public static void main(String[] args) {
        //String 类对象的创建
        String str1 = new String();

        //String (byte[] bytes)通过使用平台的默认字符解码指定的字节数组来创建新的String


        //boolean contains(String str) 判断字符串中是否有相同部分
        str1 = "123456789";
        boolean flag = str1.contains("789");
        System.out.println(flag);

        //int indexOf()返回指定字符第一次出现的字符串内的索引
        String str2 = "asdasdasdasd";
        int i = str2.indexOf("sd");
        System.out.println(i);

    }
}
