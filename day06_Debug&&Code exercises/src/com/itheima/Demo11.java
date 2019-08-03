package com.itheima;

/*
    需求：
        在编程竞赛中，有6个评委为参赛的选手打分，分数为0-100的整数分。
        选手的最后得分为：去掉一个最高分和一个最低分后 的4个评委平均值 (不考虑小数部分)。

    思路：
        1:定义一个数组，用动态初始化完成数组元素的初始化，长度为6
        2:键盘录入评委分数
        3:由于是6个评委打分，所以，接收评委分数的操作，用循环改进
        4:定义方法实现获取数组中的最高分(数组最大值)，调用方法
        5:定义方法实现获取数组中的最低分(数组最小值) ，调用方法
        6:定义方法实现获取数组中的所有元素的和(数组元素求和) ，调用方法
        7:按照计算规则进行计算得到平均分
        8:输出平均分
 */

import java.util.Scanner;

public class Demo11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[6];
        //由于是6个评委打分，所以，接收评委分数的操作，用循环改进
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第" + (i+1) + "个评委的分数");
            arr[i] = sc.nextInt();
        }
        //调用方法求最大值
        int max = getMax(arr);
        //调用方法求最小值
        int min = getMin(arr);
        //调用方法求分数和
        int sum = getsum(arr);
        //7:按照计算规则进行计算得到平均分
        int avg = (sum - max - min ) / (arr.length - 2);
        //输出平均分
        System.out.println("该选手的平均分为" + avg);
    }
    //求出评委分数数组中的最大值
    public static int getMax(int arr[]){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    //求出评委分数数组中的最小值
    public static int getMin(int arr[]){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
    //求出评委分数的总和
    public static int getsum(int arr[]){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
