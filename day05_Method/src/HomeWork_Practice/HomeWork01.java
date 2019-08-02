package HomeWork_Practice;

import java.util.Scanner;

/*
    第一题：
    请定义一个方法，该方法的功能是对键盘录入的一个整数，可以判断这个数是否是奇数（isOdd），
    如果是返回true，否则返回false。方法定义完毕，请在主方法中调用方法，并输出结果。
 */
public class HomeWork01 {
    public static void main(String[] args) {
        System.out.println("请输入一个数字");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(isOdd(num));
    }
    public static boolean isOdd(int num1){
        if(num1 % 2 != 0){
            return true;
        }else{
            return false;
        }
    }
}
