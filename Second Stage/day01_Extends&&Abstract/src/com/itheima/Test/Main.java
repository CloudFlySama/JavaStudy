package com.itheima.Test;

public class Main {
    public static void main(String[] args) {
        Android a = new Android();
        a.setId("id001");
        a.setName("赵云帆");
        a.work();

        JavaEE j = new JavaEE();
        j.setId("id002");
        j.setName("周满仓");
        j.work();

        Hardware h = new Hardware();
        h.setId("id003");
        h.setName("孙志良");
        h.work();

        Networker n = new Networker();
        n.setId("id004");
        n.setName("职鹏宇");
        n.work();
    }
}
