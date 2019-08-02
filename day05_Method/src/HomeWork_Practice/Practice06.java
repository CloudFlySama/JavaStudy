package HomeWork_Practice;

import java.util.Scanner;

/*题目6（训练）
        数字是有绝对值的，负数的绝对值是它本身取反，
        非负数的绝对值是它本身。请定义一个方法，方法能够得到小数类型数字的绝对值并返回。
        请定义方法并测试。*/
public class Practice06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个小数");
        double num = sc.nextDouble();
        System.out.println("绝对值为" + getNum(num));
    }
    public static double getNum(double num){
        if (num < 0){
            return -num;
        }else
            return num;
    }
}
