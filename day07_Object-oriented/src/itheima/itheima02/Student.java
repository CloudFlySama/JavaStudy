package itheima.itheima02;

public class Student {
    //成员变量
    private String name;
    private int age;
    //构造方法    快捷键 Alt + insert  选择Constructer
    public Student(){
    }
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }
    //get和set方法  快捷键 Alt + insert  选择Getter and Setter
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    //成员方法
    public void show(){
        System.out.println("姓名为" + name + " ,年龄为" + age);
    }
    public void study(){
        System.out.println("姓名为" + name + " ,年龄为" + age + "的学生正在学习");
    }
}
