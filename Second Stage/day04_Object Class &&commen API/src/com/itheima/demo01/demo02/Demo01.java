package com.itheima.demo01.demo02;

import java.util.Objects;

//public boolean equals(Object obj) ：指示其他某个对象是否与此对象“相等”。
public class Demo01 {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demo01 demo01 = (Demo01) o;
        return age == demo01.age &&
                Objects.equals(name, demo01.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}
