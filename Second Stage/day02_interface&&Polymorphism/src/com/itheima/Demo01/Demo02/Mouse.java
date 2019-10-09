package com.itheima.Demo01.Demo02;

public class Mouse implements USB{
    @Override
    public void open() {
        System.out.println("鼠标开");
    }

    @Override
    public void close() {
        System.out.println("鼠标关");
    }
}
