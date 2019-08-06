package com.itheima01;

import java.util.Scanner;

//用户登录练习
public class Demo03 {
    public static void main(String[] args) {
        //定义已知的用户名和密码，定义两个字符串表示
        String username = "itheima";
        String password = "czbk";
        //键盘录入要登录的用户名和密码，用Scanner实现
        Scanner sc = new Scanner(System.in);
        //用循环实现多次机会
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入您的用户名");
            String name = sc.nextLine();
            System.out.println("请输入您的密码");
            String pwd = sc.nextLine();
            //拿键盘录入的数据与已知的数据进行比较，用equals()方法实现
            if (username.equals(name) && password.equals(pwd)) {
                System.out.println("登录成功");
                break;
            } else {
                if ((2 - i) == 0)
                    System.out.println("您的账户已经被冻结，请联系管理员");
                else
                    System.out.println("登录失败，你还有" + (2 - i) + "次机会");
            }
        }
    }
}
