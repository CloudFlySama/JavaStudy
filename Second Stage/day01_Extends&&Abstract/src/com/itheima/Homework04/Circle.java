package com.itheima.Homework04;

public class Circle extends Shape {
    @Override
    public double perimeter() {
        double p = super.getR() * 2 * 3.14;
        System.out.println("圆形周长:" + p);
        return p;
    }

    @Override
    public double area() {
        double a = 3.14 * super.getR() * super.getR();
        System.out.println("圆形面积:" + a);
        return a;
    }
}
