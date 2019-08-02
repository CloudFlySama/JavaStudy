package com.itheima01;

public class Demo08{
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        int result = getMax(arr);
        System.out.println(result);
    }
    public static int getMax(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }

        }
        return max;
    }
}
