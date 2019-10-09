package com.itheima.Homework05;

public class Employee {
    private String name;
    private String id;
    private String dept;

    public Employee() {
    }

    public Employee(String name, String id, String dept) {
        this.name = name;
        this.id = id;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void showMsg() {
        System.out.println(this.dept + "的:" + this.name + ",员工编号:" + this.id);
    }
}
