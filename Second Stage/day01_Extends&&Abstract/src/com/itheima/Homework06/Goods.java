package com.itheima.Homework06;

public class Goods {
    private int num;
    private String name;
    private String id;
    private double price;

    public Goods() {
    }

    public Goods(int num, String name, String id, double price) {
        this.num = num;
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void show() {
        System.out.println("商品序列为:" + this.num);
        System.out.println("商品名称:" + this.name);
        System.out.println("id:" + this.id);
        System.out.println("价格:" + this.price);
    }
}
