package com.itheima.Homework01;

public class C extends B{
    private String numc = "30";

    public void showA(){
        super.showA();
        System.out.println("A类中numa:" + super.getNuma());
    }
    public  void showB(){
        super.showB();
        System.out.println("B类中numb:" + super.getNumb());
    }
    public void showC(){
        System.out.println("C类中numc:" + this.numc);
    }
}
