package com.itheima;

/*
    需求：
        已知一个数组 arr = {19, 28, 37, 46, 50}; 键盘录入一个数据，查找该数据在数组中的索引，并在控制台输出找到的索引值。

    思路：
        1:定义一个数组，用静态初始化完成数组元素的初始化
        2:键盘录入要查找的数据，用一个变量接收
        3:定义一个索引变量，初始值为-1
        4:遍历数组，获取到数组中的每一个元素
        5:拿键盘录入的数据和数组中的每一个元素进行比较，如果值相同，就把该值对应的索引赋值给索引变量,并结束循环
        6:输出索引变量
 */

import java.util.Scanner;

public class Demo08 {
    public static void main(String[] args) {
        int arr[] =  {19, 28, 37, 46, 50};
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数据");
        int a = sc.nextInt();
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if(a == arr[i]){
                index = i;
                break;
            }
        }
        System.out.println("您要查找的值得索引为" + index);
    }
}
