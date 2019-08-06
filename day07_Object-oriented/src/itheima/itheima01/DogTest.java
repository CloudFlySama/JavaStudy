package itheima.itheima01;

public class DogTest {
    public static void main(String[] args) {
        //创建对象
        Dog d = new Dog();
        //使用成员对象
        d.name = "哈士奇";
        d.age = 2;
        d.color = "黑白色";
        System.out.println("狗的名字" + d.name);
        System.out.println("狗的颜色" + d.color);
        System.out.println("狗的年龄" + d.age);
        //使用成员方法
        d.eat();
        d.sleep();
        d.lookHome();
    }
}
