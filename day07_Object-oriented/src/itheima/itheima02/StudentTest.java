package itheima.itheima02;

public class StudentTest {
    public static void main(String[] args) {
        //空参构造方法，set方法赋值
        Student s1 = new Student();
        s1.setName("张三");
        s1.setAge(22);
        s1.show();
        s1.study();
        //有参构造方法
        Student s2 = new Student("张三" , 23);
        s2.show();
        s2.study();
    }
}
