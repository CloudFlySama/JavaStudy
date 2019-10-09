package com.itheima.demo02.demo03;
/*以下需求需要使用代码实现
        需求：
        1.请写出成员内部类的定义格式和访问成员内部类的方式；
    内部类定义格式
    public class Demo{//外部类
    外部类若想使用内部类的成员变量和方法
    需要创建内部类对象
    Demo.Demo01 d = new Demo().new Demo01();
    d.xxxxx
        private int name;
        class Demo01{
            //内部类
            并且内部类可以直接使用外部类的方法和成员变量
        }
    }
    */
//

//                2.使用代码完成：定义一个类，类中包含1个成员内部类，测试：类中调用成员内部类的方法；
public class Demo01 {
   private int num=10;
   class inner{
       public void show() {
           System.out.println(num + "内部类");
       }
   }

    public static void main(String[] args) {
        //   在外部类中调用内部类的方法
        Demo01.inner i = new Demo01().new inner();
        i.show();
    }


}
//        3.请写出匿名内部类的格式；
/*
Demo d = new Demo(){
//
}
* */