package com.itheima.Demo01.Homework02;

public class Boy extends Person{
    private String girlFriend;

    @Override
    public void speak(String countent) {
        System.out.println(getName()+"用带有阳刚之气的声音对"+girlFriend+"说:"+countent);
    }

    public Boy(int age, double height, String name) {
        super(age, height, name);
    }

    public Boy() {
    }

    public Boy(int age, double height, String name, String girlFriend) {
        super(age, height, name);
        this.girlFriend = girlFriend;
    }

    public Boy(String girlFriend) {
        this.girlFriend = girlFriend;
    }

    public String getGirlFriend() {
        return girlFriend;
    }

    public void setGirlFriend(String girlFriend) {
        this.girlFriend = girlFriend;
    }

    public void walk(){
        System.out.println(getName()+"和"+girlFriend+"在河边的林荫小道上手牵着手散步");
    }
}
