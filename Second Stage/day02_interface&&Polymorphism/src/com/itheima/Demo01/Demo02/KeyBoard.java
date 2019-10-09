package com.itheima.Demo01.Demo02;

public class KeyBoard implements USB{
    @Override
    public void open() {
        System.out.println("键盘开");
    }

    @Override
    public void close() {
        System.out.println("键盘关");
    }
}
