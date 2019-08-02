package HomeWork_Practice;

import java.util.Scanner;

//有一个数组，其中有十个元素从小到大依次排列 {12,14,23,45,66,68,70,77,90,91}。再通过键盘录入一个整数数字。
// 要求：把数字放入数组序列中，生成一个新的数组，并且数组的元素依旧是从小到大排列的。执行效果如下：
public class HomeWork05 {
    public static void main(String[] args) {
        int arr[] = {12, 14, 23, 45, 66, 68, 70, 77, 90, 91};
        int arr2[] = new int[11];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int num = sc.nextInt();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < num) {
                arr2[i] = arr[i];
                index = i + 1;
            } else {
                arr2[i + 1] = arr[i];
            }
        }
        arr2[index] = num;
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}
