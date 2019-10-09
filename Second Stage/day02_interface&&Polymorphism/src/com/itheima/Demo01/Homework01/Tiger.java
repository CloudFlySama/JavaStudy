package com.itheima.Demo01.Homework01;

public class Tiger extends Carnivore{

    @Override
    public void eat() {
        System.out.println("年龄为" + super.getAge() + "岁的" + super.getLegs() + "条腿的"+super.getName()+"正在吃"+super.getFoodName());
    }

    public Tiger() {
    }

    public Tiger(int age, int legs) {
        super(age, legs);

    }

    public Tiger(String name, String foodName) {
        super(name, foodName);
    }

    public Tiger(int age, int legs, String name, String foodName) {
        super(age, legs, name, foodName);
    }
}
