package com.itheima01;
//equals(str)  比较字符串内容是否相同

public class Demo02 {
    public static void main(String[] args) {
        char[] chs = {'a', 'b', 'c'};
        String s1 = new String(chs);
        String s2 = new String(chs);
        System.out.println(s1 == s2);

        String s3 = "abc";
        String s4 = "abc";
        System.out.println(s3 == s4);
        System.out.println(s1 == s3);
        System.out.println("------------------");

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s3.equals(s4));

    }
}
