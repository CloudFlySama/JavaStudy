package com.itheima.Homework04;

public class Rectangle extends Shape {
    @Override
    public double perimeter() {
        double p = (super.getChang() + super.getKuan()) * 2;
        System.out.println("长方形周长:" + p);
        return p;
    }

    @Override
    public double area() {
        double a = super.getChang() * super.getKuan();
        System.out.println("长方形面积:" + a);
        return a;
    }
}
