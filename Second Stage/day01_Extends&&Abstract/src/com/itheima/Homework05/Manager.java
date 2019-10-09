package com.itheima.Homework05;

public class Manager extends Employee {
    private String clerk;

    public Manager() {
    }

    public Manager(String name, String id, String dept) {
        super(name, id, dept);
    }

    public Manager(String clerk) {
        this.clerk = clerk;
    }

    public Manager(String name, String id, String dept, String clerk) {
        super(name, id, dept);
        this.clerk = clerk;
    }

    public String getClerk() {
        return clerk;
    }

    public void setClerk(String clerk) {
        this.clerk = clerk;
    }

    public void showMsg() {
        super.showMsg();
        System.out.println("他的职员是" + this.clerk);
    }
}
