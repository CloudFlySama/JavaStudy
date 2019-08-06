package com.itheima01;
//字符串的拼接
//将数组{1,2,3}拼接，并以[1,2,3] 的形式进行拼接 要求使用StringBuilder
public class Demo09 {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        //使用方法进行字符串的拼接
        String s = arrayToString(arr);
        //输出结果
        System.out.println(s);
    }
    //定义一个方法用于拼接字符串
    public static String arrayToString(int arr[]){
        //在方法中用StringBuilder进行拼接操作，并在最后转化成String返回
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        //字符串的遍历
        for (int i = 0; i < arr.length; i++) {
            if(arr.length - 1 == i){
                sb.append(arr[i]);
            }else
            {
                sb.append(arr[i]).append(", ");
            }
        }
        sb.append("]");
        //用toString方法将StringBuilder转化成String
        String s = sb.toString();
        //返回结果
        return s;
    }
}
