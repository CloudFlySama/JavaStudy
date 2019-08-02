package HomeWork_Practice;

import java.util.Scanner;

//键盘录入为数组元素赋值
public class Practice04 {
    public static void main(String[] args) {
        int arr[] = new int[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请您输入第" + (i+1) + "个数字");
            arr[i] = sc.nextInt();

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
