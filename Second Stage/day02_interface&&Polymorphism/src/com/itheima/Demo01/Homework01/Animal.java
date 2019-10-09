package com.itheima.Demo01.Homework01;

public abstract class Animal {
    private int age;
    private int legs;

    public Animal() {
    }

    public Animal(int age, int legs) {
        this.age = age;
        this.legs = legs;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }
    public abstract void eat();
}
