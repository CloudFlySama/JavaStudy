package HomeWork_Practice;

import java.util.Scanner;

/*请定义一个方法，对正数的小数进行四舍五入的操作(不考虑负数情况)。
        四舍五入之后的结果是一个int整数类型并返回。最后对方法进行测试。*/
public class Practice07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个小数");
        double num = sc.nextDouble();

        System.out.println(printNum(num));
    }
    public static int printNum(double num){
        double num1 = num*10;
        int a = 0;
        if(num % 10 >=5){
            return a = (int)num + 1;
        }else{
            return a = (int)num;
        }
    }
}
