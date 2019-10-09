package com.itheima.Homework05;

public class Clerk extends Employee{
    private String manager;

    public Clerk() {
    }

    public Clerk(String name, String id, String dept) {
        super(name, id, dept);
    }

    public Clerk(String manager) {
        this.manager = manager;
    }

    public Clerk(String name, String id, String dept, String manager) {
        super(name, id, dept);
        this.manager = manager;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
    public void showMsg(){
        super.showMsg();
        System.out.println("他的经理是:" + this.manager);
    }
}
