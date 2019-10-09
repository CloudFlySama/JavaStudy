package com.itheima.Homework05;

/*
* 1.定义员工Employee类,该类具有如下成员:
(1)属性：姓名(name,字符串类型)，工号(workId,字符串类型)，部门(dept,字符串类型),属性私有
(2)方法:
①空参数构造和满参数构造
②提供属性的set/get方法
③定义showMsg方法，方法没有形参，方法的返回值类型是void,方法内打印depart和name和id
2.定义经理Manager类继承Employee类，该类具有如下成员:
(1)属性:职员Clerk(该经理的职员)
(2)方法:
①空参数构造方法和满参数构造方法
②属性的get和set方法
③重写父类的showMsg方法，方法内先调用父类的showMsg方法，然后打印经理中的职员的名字
3.定义职员Clerk类继承Employee类，该类具有如下成员:
(1)属性:经理Manager(该职员的经理)
(2)方法:
①空参数构造方法和满参数构造方法
②属性的get和set方法
③重写showMsg方法，方法内先调用父类的showMsg方法，然后打印经理的名字
4.创建Test测试类，测试类中创建main方法，main方法中创建经理对象和职员对象，信息分别如下:
设置经理的职员为李小亮，设置职员的经理为张小强

分别调用经理的showMsg方法和职员的showMsg方法
* */
public class Test {
    public static void main(String[] args) {
        Clerk clerk = new Clerk("李小亮", "C001", "销售部");
        Manager manager = new Manager("张小强", "M001", "销售部");
        clerk.setManager("张小强");
        manager.setClerk("李小亮");
        clerk.showMsg();
        manager.showMsg();
    }
}
