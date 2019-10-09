package com.itheima.Demo01.Homework02;

public class Girl extends Person{
    private String face;
    private String boyFriend;

    @Override
    public void speak(String countent) {
        System.out.println(getName()+"脸红着用于娇媚的声音对"+boyFriend+"说:" + countent);
    }

    public Girl(int age, double height, String name) {
        super(age, height, name);
    }

    public Girl() {
    }

    public Girl(int age, double height, String name, String face, String boyFriend) {
        super(age, height, name);
        this.face = face;
        this.boyFriend = boyFriend;
    }

    public Girl(String face, String boyFriend) {
        this.face = face;
        this.boyFriend = boyFriend;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getBoyFriend() {
        return boyFriend;
    }

    public void setBoyFriend(String boyFriend) {
        this.boyFriend = boyFriend;
    }

    public void wash(Clothes clothes){
        System.out.println(super.getName() + "在洗一件" +clothes.getColor() + "的" +clothes.getBrand() + "牌子的衣服");
    }
}
