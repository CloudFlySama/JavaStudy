package com.itheima.Homework04;

public abstract class Shape {
    private int chang;
    private int kuan;
    private int r;

    public Shape() {
    }

    public Shape(int chang, int kuan, int r) {
        this.chang = chang;
        this.kuan = kuan;
        this.r = r;
    }

    public int getChang() {
        return chang;
    }

    public void setChang(int chang) {
        this.chang = chang;
    }

    public int getKuan() {
        return kuan;
    }

    public void setKuan(int kuan) {
        this.kuan = kuan;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public abstract double perimeter();

    public abstract double area();

}
