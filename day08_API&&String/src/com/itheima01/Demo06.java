package com.itheima01;

//字符串的拼接
//将数组{1,2,3}拼接，并以[1,2,3] 的形式进行拼接
public class Demo06 {
    public static void main(String[] args) {
        //定义一个int类型数组，用静态初始化方法
        int arr[] = {1, 2, 3};
        //调用方法，用一个变量来接收
        String s = ArrayToString(arr);
        //输出结果
        System.out.println(s);
    }

    //定义一个方法，用于把int数组中的数据按照要求进行拼接成一个字符串并返回
    public static String ArrayToString(int arr[]) {
        //在方法中进行遍历数组，按照要求进行拼接
        String s = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1)
                s += arr[i];
            else {
                s += arr[i] + ", ";
            }
        }
        s += "]";
        return s;
    }
}
