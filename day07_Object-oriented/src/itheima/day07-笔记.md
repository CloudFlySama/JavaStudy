## 课堂知识点

### 一、面向对象

#### 1.类和对象

- 什么是类
  - 类是一种广泛的抽象的概念。具有相同属性和行为的对象的集合！
  - 例如：动物类、水果类、手机类....
  - 类中的组成部分
    - 属性(成员变量)：事物的描述信息
    - 行为(成员方法)：事物可以做的事情
- 什么是对象
  - 对象是某一类事物的具体的体现
  - 例如：动物类-猫、狗   水果类-苹果、香蕉    手机类-华为P30  小米NOTE3
- 类和对象之间的关系
  - 对象是根据类来创建出来的

#### 2.面向对象的三大特征

- 封装性
- 继承性
- 多态性

#### 3.类的定义

- 明确类名
  - 建议起到见名知意
- 明确属性(成员变量)
  - 数据类型 变量名;
- 明确行为(成员方法)
  - 和之前的方法定义没有区别。需要去掉static
- 示例代码

```java
public class Phone {
    //成员变量
    String brand;
    int price;

    //成员方法
    public void call() {
        System.out.println("打电话");
    }

    public void sendMessage() {
        System.out.println("发短信");
    }

}
```

#### 4.类的使用(对象的创建)

- 对象的创建格式
  - 类名 对象名 = new 类名()；
- 成员变量的使用格式
  - 对象名.成员变量名
- 成员方法的使用格式
  - 对象名.成员方法名
- 示例代码

```java
public class PhoneDemo {
    public static void main(String[] args) {
        //创建对象
        Phone p = new Phone();

        //使用成员变量
        System.out.println(p.brand);
        System.out.println(p.price);

        p.brand = "小米";
        p.price = 2999;

        System.out.println(p.brand);
        System.out.println(p.price);

        //使用成员方法
        p.call();
        p.sendMessage();
    }
}
```

#### 5.学生类的定义和使用

- 学生类

```java
public class Student {
    //成员变量
    String name;
    int age;

    //成员方法
    public void eat() {
        System.out.println(name + "是一个么得感情的吃货");
    }

    public void study() {
        System.out.println(name + "正在努力敲代码");
    }
}
```

- 测试类

```java
public class StudentTest {
    public static void main(String[] args) {
        //创建对象
        Student s = new Student();

        //为成员变量赋值
        s.name = "张三";
        s.age = 23;

        System.out.println("姓名：" + s.name);
        System.out.println("年龄：" + s.age);

        //调用成员方法
        s.eat();
        s.study();
    }
}
```

### 二、对象的内存图解

#### 1.一个对象的内存图解

![01](img\01.png)

#### 2.多个对象的内存图解

![02](img\02.png)

#### 3.多个对象引用相同内存空间

![03](img\03.png)

### 三、成员变量和局部变量

#### 1.成员变量和局部变量的区别

- 定义位置
  - 成员变量：定义在类中方法外
  - 局部变量：定义在方法内部或方法声明上
- 默认初始化值
  - 成员变量：有默认初始化值
  - 局部变量：没有默认初始化值，使用之前必须赋值
- 内存位置区别
  - 成员变量：在堆内存中
  - 局部变量：在栈内存中
- 生命周期区别
  - 成员变量：随着对象的创建而创建，随着对象的消失而消失
  - 局部变量：随着方法的调用而创建，随着方法的消失而消失

### 四、封装

#### 0.权限修饰符分类

- public->protected->default(默认)->private

#### 1.private关键字

- private是一个权限修饰符。可以修饰成员变量和成员方法
- 被private修饰的成员，只能在本类中使用。外界无法直接访问
- 如果想要访问，需要提供单独的get和set方法，来间接进行访问

#### 2.this关键字

- 区分成员变量和局部变量重名的问题
  - 带this的表示成员变量，不带this的就是局部变量
- this代表的是当前对象，谁调用的方法，this就代表谁

#### 3.封装的思想

- 将不想对外暴露的事物进行隐藏。提供公共的访问方式
- 体现一：private关键字，可以提高安全性。
- 体现二：方法，可以提高复用性和维护性。

### 五、构造方法

#### 1.构造方法的定义格式

```java
权限修饰符 方法(类)名(参数列表){
    
}
```

#### 2.构造方法的注意事项

- 构造方法没有返回值类型，连void也不能写
- 如果没有写任何构造方法，那么系统会提供一个无参的构造方法供我们创建对象使用
- 如果我们自己写了任意一个构造方法，那么系统就不会提供构造方法了
- 构造方法可以重载。方法名相同，参数列表不同
- **推荐：一个类中，一个空参构造方法，一个有参构造方法**

### 六、标准类的定义和使用

#### 1.定义类

- 明确类名
- 明确成员变量
  - 所有成员变量必须private修饰
- 提供私有成员变量的get和set方法
  - get方法：专门用于获取变量的值
  - set方法：专门用于设置变量的值
- 明确构造方法
  - 一个空参构造方法
  - 一个有参构造方法(参数根据成员变量而定)
- 明确成员方法

#### 2.示例代码

- 学生类

```java
public class Student {
    //成员变量
    private String name;
    private int age;

    //构造方法
    public Student() {

    }

    public Student(String name,int age) {
        this.name = name;
        this.age = age;
    }

    //get和set方法
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    //成员方法
    public void show() {
        System.out.println("姓名是：" + name + ",年龄是：" + age);
    }

    public void study() {
        System.out.println("姓名为：" + name + ",年龄为：" + age + "的学生正在努力学习");
    }
}
```

- 测试类

```java
public class StudentTest {
    public static void main(String[] args) {
        //空参构造方法  set方法赋值
        Student s1 = new Student();
        s1.setName("张三");
        s1.setAge(23);
        s1.show();
        s1.study();

        System.out.println("------------");

        //有参构造方法
        Student s2 = new Student("李四",24);
        s2.show();
        s2.study();
    }
}
```







## 练习题

1. 过一遍笔记
2. 练习作业题





## 面试题

- 什么是类？
- 什么是对象？
- 类和对象的关系？
- 类的定义标准步骤
- 成员变量和局部变量的区别
- private关键字的作用？
- this关键字的作用？
- 构造方法的定义格式和注意事项？