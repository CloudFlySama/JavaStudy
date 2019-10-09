package com.itheima.demo01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Demo {
    public static void main(String[] args) {
        ArrayList<String> PokeFace = new ArrayList<>();
        ArrayList<String> Huase = new ArrayList<>();
        ArrayList<String> Shuzi = new ArrayList<>();
        String huase1 = "♠";
        String huase2 = "♥";
        String huase3 = "♣";
        String huase4 = "♦";
        Huase.add(huase1);
        Huase.add(huase2);
        Huase.add(huase3);
        Huase.add(huase4);
        for (int i = 2; i < 11; i++) {
            Shuzi.add(i+"");
        }
        Shuzi.add("A");
        Shuzi.add("J");
        Shuzi.add("Q");
        Shuzi.add("K");
        for (String s : Shuzi) {
            for (String s1 : Huase) {
                String pokeface = s + s1;
                PokeFace.add(pokeface);
            }
        }
        PokeFace.add("(≖ᴗ≖)✧");
        PokeFace.add("ಠᴗಠ");
        Collections.shuffle(PokeFace);
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();
        for (int i = 0; i < PokeFace.size(); i++) {
            String pokerFace = PokeFace.get(i);
            if (i>=51){
                dipai.add(pokerFace);
            }else{
                if(i%3 ==0){
                    player1.add(pokerFace);
                }else if(i%3 ==1){
                    player2.add(pokerFace);
                }else if(i%3 ==2){
                    player3.add(pokerFace);
                }
            }
        }
        System.out.println("秦文强的牌面是" + player1);
        System.out.println("周向东的牌面是" + player2);
        System.out.println("成铭杰的牌面是" + player3);
        System.out.println(dipai);
    }
}
