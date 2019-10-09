package com.itheima.Demo01.Homework01;

public abstract class Herbivore extends Animal{
    private String name ;
    private String foodName;

    public Herbivore() {
    }

    public Herbivore(int age, int legs) {
        super(age, legs);
    }

    public Herbivore(String name, String foodName) {
        this.name = name;
        this.foodName = foodName;
    }

    public Herbivore(int age, int legs, String name, String foodName) {
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
