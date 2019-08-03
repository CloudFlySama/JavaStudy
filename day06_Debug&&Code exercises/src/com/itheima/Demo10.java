package com.itheima;
/*
可变参数的应用
格式 int...nums
需求 求多个整数的和
注意 可变参数的后面不能再放其他参数
 如果需要多个参数，只能把参数放在int...nums的前面，放在后面则会报错
 */
public class Demo10 {
    public static void main(String[] args) {
        int sum = getsum(1,2,3,4,5,6,7,8,9);
        System.out.println(sum);
    }
    public static int getsum(int...nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
    /*//注意 如果需要多个类型的参数，只能把参数放在int...nums的前面，放在后面则会报错
    public static int getsum(double d,int...nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }*/
}
