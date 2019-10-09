package com.itheima.Demo01.Homework01;

public abstract class Carnivore extends Animal{
    private String name ;
    private String foodName;

    public Carnivore() {
    }

    public Carnivore(int age, int legs) {
        super(age, legs);
    }

    public Carnivore(String name, String foodName) {
        this.name = name;
        this.foodName = foodName;
    }

    public Carnivore(int age, int legs, String name, String foodName) {
        super(age, legs);
        this.name = name;
        this.foodName = foodName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public abstract void eat();
}
