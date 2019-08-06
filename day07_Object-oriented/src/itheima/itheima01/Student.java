package itheima.itheima01;

public class Student {
    private String name;
    private  int  age;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int a){
        age = a;
    }
    public int getAge(){
        return age;
    }
    public void study(){
        System.out.println("好好学习");
    }
    public void show(){
        System.out.println(name + ", " + age);
    }
}
