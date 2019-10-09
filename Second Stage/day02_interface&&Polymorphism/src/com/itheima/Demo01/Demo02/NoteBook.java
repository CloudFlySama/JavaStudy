package com.itheima.Demo01.Demo02;

public class NoteBook {
    public void start(){
        System.out.println("开机");
    }
    public void useUSB(USB usb){
        if(usb instanceof KeyBoard){
            KeyBoard keyBoard = (KeyBoard)usb;
            keyBoard.open();
            keyBoard.close();
        }else{
            Mouse mouse = (Mouse)usb;
            mouse.open();
            mouse.close();
        }
    }
    public void off(){
        System.out.println("关机");
    }
}
