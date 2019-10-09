package com.itheima.Homework02;

public class Duck extends Poultry{
    public Duck() {
    }

    public Duck(String name, String symptom, int age, String illness) {
        super(name, symptom, age, illness);
    }

    public void showSymptom(){
        super.showSymptom();
        System.out.println("入院原因:" + super.getIllness());
    }
}
