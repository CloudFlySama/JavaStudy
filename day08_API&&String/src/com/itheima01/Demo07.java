package com.itheima01;

//字符串的反转
//通过一个方法，将用户输入的字符串进行反转
// 例如 用户输入：abc  得到结果 cba
import java.util.Scanner;

public class Demo07 {
    public static void main(String[] args) {
        //键盘录入一个字符串 用Scanner实现
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String s = sc.nextLine();
        //调用方法，用一个变量接收结果
        String ss = reverse(s);
        //输出结果
        System.out.println(ss);
    }
    //定义一个方法，实现字符串的反转
    public static String reverse(String s){
        //定义一个空字符串来储存反转后的字符串
        String ss = "";
        //将原字符串进行倒着遍历，然后把每一个得到的值进行拼接
        for(int i = s.length()-1 ; i >= 0; i--){
            ss += s.charAt(i);
        }
        //返回最终得到的字符串
        return ss;
    }
}
