package com.itheima01;

public class Demo01 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
//          max = max > arr[i] ? max : arr[i];
            a += arr[i];
        }System.out.println("和为" + a);
    }
}
