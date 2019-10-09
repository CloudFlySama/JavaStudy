package com.itheima.demo02;

import java.util.ArrayList;

public class Test {
    private static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {

        BaoZiPu baoZiPu = new BaoZiPu("包子铺",list);
        baoZiPu.start();
        ChiHuo chiHuo = new ChiHuo("吃货",list);
        chiHuo.start();
    }
}
