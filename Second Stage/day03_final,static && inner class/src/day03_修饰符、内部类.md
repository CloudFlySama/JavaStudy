```
昨日内容回顾
★ 接口
	定义：
		public interface 接口名称{
			// 抽象方法 ★★★★★
			public abstract void method();
			// 默认方法
			public default void method(){}
			// 静态方法
			public static void method(){}
			// 私有方法
			private void method(){}
		}
	使用：
		我们使用接口，一般都需要定义一个子类去实现接口，需要重写接口中所有的抽象方法！
		
★ 多态
	多态的前提：存在继承或者实现关系
	多态的体现：
		创建对象：父类引用指向子类对象
		方法(形参或者返回值类型)：定义方法的时候，将返回值类型或者形参指定为父接口类型，调用方法传递子类对象
```

# 今日内容 #
>* final关键字
>* static关键字
>* 访问权限修饰符
>* 内部类
>* 引用类型的使用小结

## 1. final关键字

### 1.1 概述

```markdown
之前，我们学过一些类(不是我们自己定义的，而是JDK提供的)，比如String类，在API文档中有声明：
```

![1566024900735](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566024900735.png)

```
这个final是java中的一个关键字(被赋予了特殊含义)，final关键字可以修饰类、成员变量、成员方法！
针对修饰的内容不同，所赋予的含义也不一样！
★ 修饰类，那么这个类不能被继承！
★ 修饰成员变量，那么这成员变量只能赋值一次！
★ 修饰成员方法，那么这个成员方法不能被重写！
```

### 1.2 修饰类

```markdown
一个类如果被final修饰，那么这个类不能被继承！【一般一个类被final修饰，它在设计上面是不希望你去改动这个类(JDK)】
	public class A extends String{}  // 编译报错！ 【String类被final修饰】
	public class B extends Random{}  // 编译通过！ 【Random类未被final修饰】
```

### 1.3 修饰变量

```markdown
如果一个成员变量被final修饰，那么它只能赋值一次！
    public class Demo01{
        int number = 10;
        public void show(){
            // 第二次赋值
            number = 20; // 编译通过！
        }
    }
    
     public class Demo01{
        final int number = 10;
        public void show(){
            // 第二次赋值
            number = 20; // 编译报错！ 【被final修饰的成员变量只能赋值一次！】
        }
    }
    
  	针对引用类型
    	public void show(){
    		final User user = new User(); // user对象的值是一个地址值(已经赋值一次了)
    		user = new User(); // new的是一个新的对象，产生一个新的地址值，所以编译报错！
    		user.setName("jack"); // 编译通过，它没有改变对象的数据，只是改变这个对象内部成员变量的数值
    	}   	
```

### 1.4 修饰方法

```markdown
如果一个成员方法被final修饰，那么它不能被重写！
1. 父类方法未被final修饰：	
        // 父类
        public class Demo02 {
            public void showw(){
                System.out.println("么么哒！");
            }
        }

        // 子类
        public class Demo03 extends Demo02{
            // 覆盖重写父类的方法，编译通过！
            @Override
            public void showw(){
                System.out.println("萌萌哒！");
            }
        }

2. 父类方法被final修饰
		// 父类
        public class Demo02 {
            // 成员方法使用final修饰
            public final void method(){
                System.out.println("呵呵哒！");
            }
        }

        // 子类
        public class Demo03 extends Demo02{
            // 覆盖重写失败！父类这个方法被final修饰了 【编译报错！】
            @Override
            public void method(){
                System.out.println("晕晕哒！");
            }
        }
```

> 针对final关键字，我们开发一般使用在变量上面(常量)！我们自己很少使用在方法和类上面(别人提供的API)

## 2. static关键字

### 2.1 概述

```markdown
之前，我们定义过类(Student),每个学生对象都有自己的属性值
	public class Student{
		// 属性，几乎每一个学生对象的值都不一样
		private String name;
		private int age;		
	}
但是他们都有一个共同的属性值,他们是同班同学，那么所在的教室是同一个！
	public class Student{
		// 属性，几乎每一个学生对象的值都不一样
		private String name;
		private int age;	
        // 特殊属性，每个学生的取值都一样
        private String classRoom;
	}
我们通过代码如何表示呢？直接在成员变量的前面使用static进行修饰！

static它也是一个关键字，一旦使用static修饰的内容，它就属于类级别！不再属于某个对象！！！！
static是静态修饰符，一般修饰成员。被static修饰的成员属于类，不属于单个这个类的某个对象。static修饰的成员
被多个对象共享。static修饰的成员属于类，但是会影响每一个对象。被static修饰的成员又叫类成员，不叫对象的成
员
```

### 2.2 类变量

```java
// 学生类
public class Student {
    // 属性，几乎每一个学生对象的值都不一样 【下面的2个属性应该是属于某个对象的，对象级别】
    private String name;
    private int age;
    // 特殊属性，所在班级 [这个属性作为类级别的]
    private static String classRoom = "综合楼316";  // 类变量
    ..... 此处省略getter and setter
}

// 测试类
public class Main {

    public static void main(String[] args) {
        // 创建学生对象
        Student s1 = new Student();
        s1.setName("jack");
        s1.setAge(30);

        Student s2 = new Student();
        s2.setName("rose");
        s2.setAge(18);
        
        // 下面打印2个学生对象，均能够得到学生所在的教室！  【static修饰的成员被多个对象共享】
        System.out.println(s1.getName()+", "+s1.getAge()+", " + s1.getClassRoom());
        System.out.println(s2.getName()+", "+s2.getAge()+", " + s2.getClassRoom());
    }

}


// 测试类
public class Main {

    public static void main(String[] args) {
        // 创建学生对象
        Student s1 = new Student();
        s1.setName("jack");
        s1.setAge(30);
		s1.setClassRoom("201"); // 虽然只修改了s1对象的classRoom的值，但是它会影响所有对象！
        
        Student s2 = new Student();
        s2.setName("rose");
        s2.setAge(18);
        
        // 2个学生对象所在教室全都变成了201  【会影响每一个对象】
        System.out.println(s1.getName()+", "+s1.getAge()+", " + s1.getClassRoom());
        System.out.println(s2.getName()+", "+s2.getAge()+", " + s2.getClassRoom());
    }

}
```

### 2.3 静态方法

```markdown
如果使用static修饰成员方法，那么这个方法我们又称之为静态方法！【静态方法也是属于类级别的！】

1. 静态方法不能直接调用非静态方法，需要通过对象去调用非静态方法
		public class Demo01 {
            // 定义方法【非静态方法】
            public void sayHello(){
                System.out.println("Hello!");
            }

            // 定义一个main方法
            public static void main(String[] args) {
                sayHello(); // 编译报错！ 一个静态方法不能调用一个非静态方法

                // 我们可以通过对象来调用费静态方法
                Demo01 demo01 = new Demo01();
                demo01.sayHello();
            }
		}

2. 静态方法可以直接调用静态方法
        public class Demo01 {
            // 定义一个静态方法
            public static void show(){
                System.out.println("hi!");
            }

            // 定义一个main方法
            public static void main(String[] args) {
                // 静态方法去调用另外一个静态方法
                show();
            }
        }


3. 非静态方法可以直接调用静态方法，也可以直接调用非静态方法
        public class Demo03 {
            // 定义一个费静态方法
            public void sayHello(){
                // 非静态方法可以直接调用静态方法，也可以直接调用非静态方法
                show();
                method();
            }

            // 定义一个静态方法
            public static void show(){
                System.out.println("hi!");
            }

            // 定义一个费静态方法
            public void method(){
                System.out.println("xxxx");
            }

        }
        
4. 静态方法中，不能使用this关键字。
		this代表的是本类的某个对象！====>>> this是对象级别！(this每个对象都不一样！)
		静态方法是属于类的 ========>>> 类级别 (被static修饰的是被多个对象共享的！)
		
5. 调用
	全部都是用类名去调用
		类变量：类名.变量名称
		静态方法：类名.方法名称(参数列表);
	注意：以后如果我们操作的是别人的类，它里面提供的方法是静态的，那么我们就不用再创建对象了	
```

### 2.4 静态内存图

```java
public class Student {

    // 属性，几乎每一个学生对象的值都不一样 【下面的2个属性应该是属于某个对象的，对象级别】
    private String name;
    private int age;
    // 特殊属性，所在班级 [这个属性作为类级别的]
    private static String classRoom = "综合楼316";
    .... 省略 setter and  getter
}

public class Main {
    public static void main(String[] args) {   
        Student s1 = new Student();
        s1.setName("jack");
        s1.setAge(30);
        s1.setClassRoom("xxxx");

        Student s2 = new Student();
        s2.setName("rose");
        s2.setAge(18);

        System.out.println(s1.getName()+", "+s1.getAge()+", " + s1.getClassRoom());
        System.out.println(s2.getName()+", "+s2.getAge()+", " + s2.getClassRoom());
    }
}
```

![1566032450878](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566032450878.png)

### 2.5 静态代码块

```markdown
代码块：
	// 代码块
    {
        int number = 10;
    }

静态代码块：在类中方法外
	public class Demo01 {
        // 静态代码块 [类中方法外]
        static{
            System.out.println("静态代码块的内容执行了！");
        }
    }

特点：
	静态代码块是在类对应的字节码加载到内存就会执行，优先于构造方法之前执行，并且只执行一次！
	
	public class Demo01 {
        public Demo01(){
            System.out.println("构造方法执行了！");
        }

        // 静态代码块 [类中方法外]
        static{
            System.out.println("静态代码块的内容执行了！");
        }
    }
    
    public class Main {
        public static void main(String[] args) {
            Demo01 demo01 = new Demo01();
            Demo01 demo02 = new Demo01();
        }
    }
 	测试结果：
    	静态代码块优先于构造方法执行，而且只执行一次！
```

![1566032960720](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566032960720.png)

> 静态代码块我们以后使用最多的地方就是：抽取工具类，读取配置文件！

## 3. 权限修饰符

```markdown
权限修饰符：指定就是我们编写的代码的一个访问权限问题！
	权限：
		总经理：添加一个新的员工、查看某个员工、修改某个员工的信息、删除某个员工
		小王(员工)：查看某个员工
	那么此时，总经理具有操作员工的4个权限！小王只有1个权限！

在java中，我们使用不同的权限修饰符对成员和类进行修饰，那么这个修饰的内容就具备不同的访问权限！
public		公共的
protected	受保护的
default		默认的
private		私有的

比如：使用private修饰的内容，只能在本类中使用！
```

![1566033538895](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566033538895.png)

```markdown
结论：
	虽然我们学习的权限修饰符有4个，但是开发常用的仅仅只有2个而已！【public private】
	权限修饰符可以修饰的内容很多(类、成员变量、成员方法、构造方法)
	
	注意：以后我们开发，对于成员变量都使用private修饰！对于其它的内容都使用public
```

## 4.内部类

```markdown
Demo01.java
在这个java文件中创建了3个平级的类！
    public class Demo01 {

    }

    class Demo02{

    }

    class Demo03{

    }
只有那个类名与文件名称一致的那个类才能被public修饰！
```

### 4.1概述

```markdown
内部类：在一个类的内部再定义一个类，那么此时这个类就称之为内部类！
	将一个类A定义在另一个类B里面，里面的那个类A就称为内部类，B则称为外部类。
    public class Demo04 {
        // 在Demo04这个类的内部再定义一个类
        public class Demo05{ // 内部类！

        }
    }	
```

### 4.2 成员内部类

```markdown
1. 成员内部类 ：定义在类中方法外的类。
        class A{  // 外部类！
            // 定义成员变量
            private int number = 10;
            // 定义一个成员内部类
            class B{ // 成员内部类

            }
        }
2. 内部类访问成员的特点
	★ 内部类可以直接访问外部类的成员，包括私有成员。
		public class Demo6 {
            // 外部的成员变量
            private int number = 100;

            // 内部类
            class A{
                public void show(){
                    // 在内部类中直接访问外部的成员(成员变量，成员方法)，包括私有成员
                    number = 200;
                    method();
                }
            }

            public void method(){
                System.out.println("xxx");
            }
        }
	★ 外部类要访问内部类的成员，必须要建立内部类的对象
		创建内部类的对象的格式：外部类名.内部类名 对象名 = new 外部类型().new 内部类型()； 
		
		public class Outer {

            class Inner{
                private int number = 10;
                public void show(){
                    System.out.println("内部类！");
                }
            }

            // 外部类要访问内部类的成员
            public static void main(String[] args) {
                // 创建内部类的对象
                Outer.Inner inner = new Outer().new Inner();
                // 外部类去访问内部类的成员变量
                System.out.println(inner.number);
                inner.show();
            }
        }
```

### 4.3 匿名内部类 ★★★★★

```markdown
前面我们已经学习了内部类，它是在另外一个类的内部，而且是成员位置，类是有名字的！
匿名内部类：它也是一个内部类，只不过，它们没有名字而已！
不管是外部类，还是内部类，我们最终的目的是为了通过这个类去创建对象，然后访问成员(通过对象调用成员方法)
之前，我们学习了接口，我们使用接口最终的目的是为了使用接口的方法！！！！！我们就必须去创建这个接口的实现类对象，然后去调用方法！！！！！！【关键字：我们要的是类的对象，而不是类！】

	// 接口
    public interface Animal {
        public abstract void eat();
    }

	// 实现类
    public class Dog implements Animal {
        @Override
        public void eat() {
            System.out.println("狗吃骨头！");
        }
    }

	// 测试类
    public class Main {
        public static void main(String[] args) {
            // 多态
            Animal animal = new Dog();
            animal.eat();
        }
    }

同上面的代码，其实我们就是为了调用接口的方法！【就是为了创建类去重写方法，并调用方法】
这种情况，我们可以不用去定义实现类！【只需要重写接口的方法并调用】
	// 接口
	public interface Animal {
        public abstract void eat();
    }
	
	// 不用再定义类去明确实现接口
	// 通过匿名内部类的方式去完成
	public class Main {
        public static void main(String[] args) {
            // 通过匿名内部类的方式来完成
            Animal am = new Animal(){
                // 方法是定义在类中的，现在类没有名字，它又在类Main的内部，所以它是一个内部类【匿名内部类】
                @Override
                public void eat() { // 通过匿名内部类去重写接口中的方法
                    System.out.println("猫吃鱼！");
                }
            };
            am.eat();
        }
    }

使用匿名内部类的场合：接口和抽象类！！！！ 【匿名内部类一般只操作一次比较适合】
```

## 5.引用类型使用小结

引用类型在实际开发中非常常见的！尤其是作为方法的参数和返回值以及类的成员变量

### 5.1引用类型作为方法的参数和返回值

```markdown
1. 引用类型作为方法的形式参数！【传递的是地址值】

        public class Student {
            private String name;
            private int age;
            .... 省略setter and getter
        }

        public class Demo01 {
            public static void main(String[] args) {
                // 创建学生对象
                Student student = new Student();
                student.setName("jack");
                student.setAge(30);
                print(student);
            }
            // 定义方法(打印学生对象的数据,姓名、年龄)
            public static void print(Student student){ // 形参：数据类型 变量名称
                System.out.println(student.getName()+", "+student.getAge());
            }
        }


2. 引用类型作为方法的返回值
		public class Demo01 {
            public static void main(String[] args) {      
                // 调用方法获得一个学生对象
                Student studet = getStudet();
                // 调用方法打印学生对象
                print(studet);
            }

            // 定义方法(打印学生对象的数据,姓名、年龄)
            public static void print(Student student){ // 形参：数据类型 变量名称
                System.out.println(student.getName()+", "+student.getAge());
            }

            // 定义方法(返回一个学生对象)
            public static Student getStudet(){
                // 返回一个匿名对象
                return new Student("rose",18);
            }
        }
```

### 5.2 引用类型作为成员变量

```markdown
1. 需求：
	定义一个类去描述一个人(姓名、年龄、身份证)

2. 分析：
	姓名和年龄好处理，姓名给一个字符串，年龄给一个int类型的数值即可！
	身份证：
		它里面有签发机关、个人信息、身份证号码  =====>>> 它是没有办法使用基本数据类型来描述的！
	那么我们可以使用一个类去描述身份证信息，我们需要将类(引用类型)作为另外一个类的成员变量么！	
```

```java
// 身份证
public class Card {

    // 省份证号
    private String cardId;

    // 签发机关
    private String address;

    public Card() {

    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

// 人类
public class Person {

    // 姓名
    private String name;

    // 年龄
    private int age;

    // 身份证
    private Card card; // 将引用类型(类)作为类的成员变量

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}

// 测试类
public class Main {
    public static void main(String[] args) {
        // 创建人所在类的对象
        Person person = new Person();
        // 为3个成员变量赋值
        person.setName("jack");
        person.setAge(30);
        //person.setCard(); // 不好弄！需要创建的Car类的对象

        // 创建省份证所在类的对象
        Card card = new Card();
        // 为成员变量赋值
        card.setCardId("110120119114888888");
        card.setAddress("北京");

        person.setCard(card);

        // 打印数据
        System.out.println(person.getName()+", "+person.getAge()+", "+ person.getCard().getCardId()+", "+person.getCard().getAddress());
    }
}

```

