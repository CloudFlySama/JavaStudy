package com.itheima.Homework01;

public class B extends A{
    private String numb = "20";

    public String getNumb() {
        return numb;
    }

    public void setNumb(String numb) {
        this.numb = numb;
    }

    public void showB(){
        System.out.println(numb);
    }
}
