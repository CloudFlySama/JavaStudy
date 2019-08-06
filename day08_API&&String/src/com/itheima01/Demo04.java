package com.itheima01;

// 字符串长度的获取以及字符串的遍历
public class Demo04 {
    public static void main(String[] args) {
        String s = "HelloWorld";
        //int length（） 获取字符串长度
        int length = s.length();
        System.out.println(length);
        // char charAt(int index)  获取指定索引上的字符
        char ch = s.charAt(5);
        System.out.println(ch);
        System.out.println("-------------");
        //遍历字符串的标准格式
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c);
        }
    }
}
