package com.itheima.Homework03;

/*
* 1.定义Person类，具有如下成员:
(1)属性：姓名(name,字符串类型)、年龄(age,int类型)
(2)构造方法：无参构造方法，有参构造方法
(3)成员方法：getXxx方法，setXxx方法，显示基本信息的showMsg方法
2.定义Teacher类，继承Person，该类具有如下成员:
(1)属性：学科(变量名自取，字符串类型)
(2)构造方法：无参构造方法，有参构造方法
(3)成员方法：getXxx方法，setXxx方法，讲课方法teach，方法没有形参，返回值类型是void，方法内打印xx老师讲授yy课（xx是变量，yy也是变量）
3.定义Student类，继承Person,该类具有如下成员:
(1)属性：分数(score,int类型)
(2)构造方法：无参构造方法，有参构造方法
(3)成员方法：getXxx方法，setXxx方法，考试方法kaoshi，方法没有形参，返回值类型是void，方法内打印xx学生考试得了yy分（xx是变量，yy也是变量）
4.创建Test测试类，测试类中创建main方法，在main方法中创建Teacher对象和Student对象，并分别赋值，分别调用Teacher对象的teach方法和Student对象的kaoshi方法

* */
public class Test {
    public static void main(String[] args) {
        Teacher t = new Teacher();
        Student s = new Student();
        t.setName("王小平");
        t.setSubject("Java");
        s.setScore(90);
        s.setName("李小乐");
        t.teach();
        s.exam();
    }
}
