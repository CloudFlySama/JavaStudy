package com.itheima01;

import java.util.Random;

public class Demo02 {
    public static void main(String[] args) {
        int arr[] = new int[5];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100) + 1;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
