package com.itheima01;
/*判断数组中的字符串是否对称
    例如：abc不是对称的
    aba是对称的
    强强打强强是对称的
    我爱黑马不是对称的
    上海自来水来自海上是对称的

    分析：
    1.定义数组
    2.遍历数组，拿到每一个字符串
    3.将字符串反转，借助StringBuilder类中的reverse（）进行反转
    4.运用equals方法比较两个字符串中的内容是否相同
    5.输出结果
*/

public class Demo11 {
    public static void main(String[] args) {
//        1.定义数组
        String arr[] = {"abc", "aba", "强强打强强", "我爱黑马","上海自来水来自海上"};
//        2.遍历数组，拿到每一个字符串
        for (int i = 0; i < arr.length; i++) {
            String s1 = arr[i];
            StringBuilder sb = new StringBuilder(s1);
//            3.将字符串反转，借助StringBuilder类中的reverse（）进行反转
            sb.reverse();
//            4.运用equals方法比较两个字符串中的内容是否相同
            if (s1.equals(sb.toString())){
                System.out.println(s1 + "是对称的");
            }else{
                System.out.println(s1 + "不是对称的");
            }
        }
    }
}
