package com.itheima.Homework03;

public class Teacher extends Person{
    private String subject;

    public Teacher() {
    }

    public Teacher(String subject) {
        this.subject = subject;
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void teach(){
        System.out.println(super.getName() + "老师正在讲授" +this.subject + "课程");
    }
}
