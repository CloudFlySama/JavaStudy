package com.itheima.Homework06;

import java.util.ArrayList;
import java.util.Scanner;

public class GouWuChe extends Goods {
    ArrayList<Goods> list = new ArrayList<>();

    public GouWuChe(ArrayList<Goods> list) {
        this.list = list;
    }

    public GouWuChe() {
    }

    public ArrayList<Goods> getList() {
        return list;
    }

    public void setList(ArrayList<Goods> list) {
        this.list = list;
    }

    public void addGoods(Goods goods) {
        list.add(goods);
    }

    public void showGoods() {
        System.out.println("您选购的商品为:");
        for (int i = 0; i < list.size(); i++) {
            list.get(i).show();
        }
        System.out.println("总计:" + total());
    }

    public void removeGoods() {
        System.out.println("请输入您要移除的商品的序列号");
        Scanner sc = new Scanner(System.in);
        Goods g = new Goods();
        int n = sc.nextInt();
        for (int i = 0; i < list.size(); i++) {
            g = list.get(i);
            if (g.getNum() == n) {
                System.out.println("==========移除" + g.getName() + "==========");
                list.remove(g);
            }
        }

    }

    public double total() {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            Goods goods = list.get(i);
            sum += goods.getPrice();
        }
        return sum;
    }
}
