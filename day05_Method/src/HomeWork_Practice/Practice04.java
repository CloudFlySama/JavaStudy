package HomeWork_Practice;
/*题目4（训练）

        我们知道数学中有九九乘法表。请定义一个方法，
        方法的功能是打印nn乘法表。在主方法中键盘录入取值范围为[1-9]的变量n，测试方法*/

import java.util.Scanner;
public class Practice04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要打印的行数");
        int n = sc.nextInt();
        jiujiu(n);
    }
    public static void jiujiu(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i;j++){
                System.out.print(i + "x" + j + "=" + (j*i) + "  ");
            }
            System.out.println();
        }
    }
}
