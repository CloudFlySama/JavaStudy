package itheima.itheima01;

public class StudentTest {
    public static void main(String[] args) {
        Student s = new Student();
        s.setAge(18);
        s.setName("张三");
        s.show();
        s.study();
        System.out.println(s.getName() + ", " + s.getAge());
    }
}
