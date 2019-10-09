package com.itheima.Homework04;
/*
* 1.定义父类形状Shape,该类具有如下成员:
(1)属性
①长（chang,int类型）
②宽（kuan,int类型）
③半径(r,int类型)
(2)方法
①空参构造和满参数构造
②属性的Get/set方法
③方法perimeter,方法没有形参，方法的返回值类型是double,方法是求形状的面积
④方法area，方法没有形参，方法的返回值类型是double,方法是求形状的周长
2.定义子类矩形Rectangle和子类圆形Circle继承Shape类
3.Rectangle编写有参构造方法(长,宽),重写计算周长和面积的方法（矩形的周长:2*（长+宽），矩形的面积:长*宽）
4.Circle编写有参构造方法(半径),重写计算周长和面积的方法（圆的周长:2π*r,圆的面积:π*r*r）
5.π可以使用3.14表示，也可以使用Math.PI获取（Math这个类中的成员变量PI）
6.创建Test类，在测试类中创建main方法，在main方法中创建矩形对象，长为20，宽为5，分别调用矩形的perimeter方法和area方法，然后创建圆对象，半径为5，分别调用圆的perimeter方法和area方法
* */
public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setR(5);
        circle.area();
        circle.perimeter();
        Rectangle rectangle = new Rectangle();
        rectangle.setChang(20);
        rectangle.setKuan(5);
        rectangle.area();
        rectangle.perimeter();
    }
}
