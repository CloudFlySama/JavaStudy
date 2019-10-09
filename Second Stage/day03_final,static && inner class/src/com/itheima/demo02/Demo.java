package com.itheima.demo02;

//如果一个成员变量被final修饰，那么它只能赋值一次！
public class Demo {
   int num1 = 10;
   final int num2 = 10;
   public void show(){
       num1 = 20;
   }
   public void showw(){
//       num2 = 30;  编译报错
   }
}
