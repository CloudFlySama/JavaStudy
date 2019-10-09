package com.itheima.Demo01.Demo02;

public class Test {
    public static void main(String[] args) {
        NoteBook noteBook = new NoteBook();
        noteBook.start();

        USB usb = new KeyBoard();
        noteBook.useUSB(usb);
        noteBook.off();
    }
}
