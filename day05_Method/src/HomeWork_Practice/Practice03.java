package HomeWork_Practice;

import java.util.Scanner;

/*题目3（训练）
        通过键盘录入两个整数n和m。n代表行数，m代表列数。定义一个方法，
        方法的功能是打印n行m列的@符号。执行效果如下：*/
public class Practice03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请您输入您要打印的行数");
        int n = sc.nextInt();
        System.out.println("请您输入您要打印的列数");
        int m = sc.nextInt();
        print(n,m);
    }
    public static void print(int n , int m){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m;j++){
                System.out.print("@");
            }
            System.out.println();
        }
    }
}
