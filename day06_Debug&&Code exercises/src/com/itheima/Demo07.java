package com.itheima;

/*
    需求：
        设计一个方法，用于比较两个数组的内容是否相同

    思路：
        1:定义两个数组，分别使用静态初始化完成数组元素的初始化
        2:定义一个方法，用于比较两个数组的内容是否相同
        3:比较两个数组的内容是否相同，按照下面的步骤实现就可以了
            首先比较数组长度，如果长度不相同，数组内容肯定不相同，返回false
            其次遍历，比较两个数组中的每一个元素，只要有元素不相同，返回false
            最后循环遍历结束后，返回true
        4:调用方法，用变量接收
        5:输出结果
 */

public class Demo07 {
    public static void main(String[] args) {
//        定义两个数组，分别使用静态初始化完成数组元素的初始化
        int arr[] = {11,12,14,15,66};
        int brr[] = {11,12,14,15,65};
//      输出结果
        System.out.println(compare(arr,brr));
    }
//    定义一个方法，用于比较两个数组的内容是否相同
    public static boolean compare(int arr[] , int brr[]){

//        判断不为空
        if(arr == null || brr == null){
            return false;
        }
//        比较数组长度，如果长度不相同，数组内容肯定不相同，返回false
        if (arr.length != brr.length){
            return false;
        }else{
//           遍历，比较两个数组中的每一个元素，只要有元素不相同，返回false
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != brr[i]){
                    return false;
                }
            }
//            循环遍历结束后，返回true
            return true;
        }
    }
}
