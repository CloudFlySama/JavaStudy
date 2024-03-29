package com.itheima.Homework02;

/*
* 1.定义家禽类(Poultry)
2.家禽类具有如下成员
(1)私有成员变量：动物种类(name，字符串类型)，症状(symptom，字符串类型)，年龄(age,int类型)， 病因（illness，字符串类型）
(2)提供空参和带参构造方法
(3)成员方法
①方法showSymptom，展示症状
②方法showMsg，展示家禽类的信息
③提供setXxx和getXxx方法
3.定义普通鸭子类(Duck)
(1)继承家禽类
(2)提供空参和带参构造方法
(3)重写showSymptom方法，打印症状信息
4.创建Test测试类，测试类中创建main方法,在main方法中创建Duck对象，赋值，调用对象的showMsg方法和showSymptom方法
* */
public class Test {
    public static void main(String[] args) {
        Duck d = new Duck("鸭子","发烧",2,"感冒");
        d.showMsg();
        d.showSymptom();
    }
}
