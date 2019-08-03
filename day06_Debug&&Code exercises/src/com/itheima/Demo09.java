package com.itheima;

/*
    需求：
        已知一个数组 arr = {19, 28, 37, 46, 50}; 用程序实现把数组中的元素值交换，
        交换后的数组 arr = {50, 46, 37, 28, 19}; 并在控制台输出交换后的数组元素。

    思路：
        1:定义一个数组，用静态初始化完成数组元素的初始化
        2:循环遍历数组，这一次初始化语句定义两个索引变量，判断条件是开始索引小于等于结束索引
        3:变量交换
        4:遍历数组
 */
public class Demo09 {
    public static void main(String[] args) {
        //定义一个数组，用静态初始化完成数组元素的初始化
        int arr[] = {19, 28, 37, 46, 50};
        //调用反转的方法
        reverse(arr);
        //遍历数组
        printArray(arr);
    }
    public static void reverse(int arr[]){
        int temp;
        //循环遍历数组，这一次初始化语句定义两个索引变量，判断条件是开始索引小于等于结束索引
        for (int start = 0,end = arr.length-1;start < end; start++,end--) {
            //变量交换
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
    public static void printArray(int arr[]){
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1){
                System.out.print(arr[i]);
            }else{
                System.out.print(arr[i] + ", ");
            }

        }System.out.print(" ]");
    }
}


// 数组的排序
/*public class Demo09 {
    public static void main(String[] args) {
        int arr[] = {19, 28, 37, 46, 50};
        int brr[] = printArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(brr[i]);
        }
    }

    public static int[] printArray(int arr[]){
        int temp;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] < arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

        }
        return arr;
    }
}*/
