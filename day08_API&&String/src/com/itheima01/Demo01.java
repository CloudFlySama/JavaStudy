package com.itheima01;

public class Demo01 {
    public static void main(String[] args) {
        //创建一个空白字符串对象
        String s1 = new String();
        System.out.println(s1);
        //根据字符数组内容，来创建字符串对象
        char[] chs = {'a', 'b', 'c'};
        String s2 = new String(chs);
        System.out.println(s2);
        //根据字节数组内容，来创建字符串对象
        byte[] bys = {97, 98, 99};
        String s3 = new String(bys);
        System.out.println(s3);
        //直接赋值的方式来创建字符串对象
        String s4 = "a,b,c";
        System.out.println(s4);
        //String(String str)
        String s5 = new String("hello");
        System.out.println(s5);
    }
}
