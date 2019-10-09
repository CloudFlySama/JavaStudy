package com.itheima.Homework03;

public class Student extends Person{
    private int Score;

    public Student() {
    }

    public Student(int score) {
        Score = score;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
    public void exam(){
        System.out.println(super.getName() + "同学考试得了" + this.Score + "分");
    }
}
