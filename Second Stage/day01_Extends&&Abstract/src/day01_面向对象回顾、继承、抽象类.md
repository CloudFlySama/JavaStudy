# 今日内容 #
>* 面向对象回顾
>* 继承
>* 抽象类

## 1. 面向对象回顾

```markdown
1. 类对象的关系
	类是对同一类事物(具有相同属性和行为)的抽象描述，类是对象的数据类型，类是对象的抽象描述
	对象是一个具体的事物，它是类的具体实现

2. 如何定义类
	格式：
		public class 类名{
			// 成员变量 (属性)
			
			// 成员方法 (行为)
		}
		
	例如：
    	public class Student{
    		private String name;
    		prviate int age;
    	}

3. 创建对象
	格式：
		类名 对象名称 = new 类名();

4. 使用对象去访问类中的属性和行为
	在没有使用private对成员变量进行修饰的时候，我们可以直接通过 对象名称.成员变量或者对象名称.成员方法去操作！
	成员变量：
		获取值：对象名称.成员变量名称;
		设置值：对象名称.成员变量名称 = 数值;
	成员方法：
		对象名称.成员方法(参数列表); // 参数是实际参数！

5. private关键字
	作用：为了解决成员变量的安全！
	特点：但凡被private修饰的成员变量或者成员方法，只能在本类中使用！

6. 封装
	将某个功能的实现细节进行了隐藏！我们只关注它的功能，在java中体现的就是方法！(private关键字)

7. setter and getter 方法
	set基本格式：
		public void setName(String n){
			name = n;
		}
	get基本格式：
		public String getName(){
			return name;
		} 
	
8. this关键字
		public class Student{
    		private String name;
    		// 局部变量与成员变量重名，局部变量隐藏成员变量
    		public void setName(String name){
                name = name;
            }
    	}
	this的作用：解决成员变量与局部变量重名的问题！局部变量隐藏成员变量
	this代表什么？
		this它代表本类的一个对象，谁调用这个方法，那么这个方法中的this就代表谁！
		public class Student{
    		private String name;
    		// 局部变量与成员变量重名，局部变量隐藏成员变量
    		public void setName(String name){
                this.name = name;
            }
    	}
	被this修饰的变量它是成员变量！this还可以调用成员方法！

9. 构造方法
	作用：创建对象，还可以为对象中的成员变量进行赋值！====>>>必须通过有参构造才行！
	问题：
		构造方法什么时候被调用？
		构造方法不能手动调用，它是我们在创建类的对象的时候，由系统(JVM)它去调用构造方法！
	构造方法可以进行重载！

	构造方法的注意事项：
		★ 构造方法不能手动调用
		★ 在没有提供任何构造方法的时候，系统自动赠送一个无参构造方法
		★ 一旦提供了有参构造，那么系统不再提供无参构造 ====>>> 建议以后手动添加一个无参构造！
		★ 构造方法没有返回值，连void都不能写！

	前一天，我们都是自己定义类，创建类的对象，调用类中方法执行某个功能！ ====>>> 类是我们自己定义的！！！
	记下来的，类不是我们定义的，里面的方法也不是我们去实现的！
		那么我们想要进行面向对象开发，只需要创建对象，调用方法！
	
10. 如何使用API文档
	★ 这个类所在的包！
		可能存在类名重复的问题！避免导错包，导致最终没有对应的方法！
	★ 这个类的大致功能描述
		这个类大致是干什么用的？ 比如Random 它是用于生成随机数！
	★ 构造方法
		构造方法专门负责创建对象！！！！
	★ 方法摘要
    	这个类里面定义的各种方法的具体功能描述，我们需要使用这个类的对象去调用！
			
11. String类
	★ 这个类所在的包！
		在java.lang包下，我们使用这个类不用导包！【只要是在这个包下的类，我们使用都不用导包！】
	★ 这个类的大致功能描述
		代表一个字符串！
	★ 构造方法
		创建对象：
			❤构造方法：
				String() 初始化新创建的 String对象，以使其表示空字符序列。  
				String(byte[] bytes) 通过使用平台的默认字符集解码指定的字节数组来构造新的 String 。  
				String(char[] value) 分配一个新的 String以便它表示当前包含在字符数组参数中的字符序列。  
			❤直接赋值：【开发常用的！】
            	String str = "abc";
		特点：String类的对象一旦创建，那么里面的数据是不可修改的！
		上面2大类创建对象的方式的区别：
			构造方法创建：
				每次都要在堆内存中开辟一块新的空间！
			直接赋值：
				在堆内存中的字符串常量池中开发空间！
	★ 方法摘要
		char charAt(int index) 返回指定索引处的 char值。  
		boolean equals(Object anObject) 将此字符串与指定对象进行比较。  
		boolean equalsIgnoreCase(String anotherString) 将此 String与另一个 String比较，忽略大小写
		int length() 返回此字符串的长度。
        char[] toCharArray() 将此字符串转换为新的字符数组。  
		
		public static void main(String[] args) {
            // String类对象的创建
            String str1 = "a-b-c-d-e-f-g";

            // char charAt(int index) 返回指定索引处的 char值。
            for (int i = 0; i < str1.length(); i++) {
                char c = str1.charAt(i);
                System.out.println(c);
            }

            // String concat(String str) 将指定的字符串连接到该字符串的末尾。
            System.out.println(str1.concat("-xxxx")); //a-b-c-d-e-f-g-xxxx

            // boolean contains(String str) 当且仅当此字符串包含指定的char值序列时才返回true。
            String url = "http://www.itheima.com";
            boolean flag = url.contains("itheima");
            System.out.println(flag); // true

            //int indexOf(String str) 返回指定字符第一次出现的字符串内的索引。
            String str2 = "asdafasfasfasdfsdfsdfasfasdfas";
            System.out.println(str2.indexOf("sd")); //1

            //String[] split(String regex) 将此字符串拆分为给定的 regular expression的匹配。
            String str3 = "a1-b2-c3-d4-e5-f6-g7";
            String[] split = str3.split("-");
            for (int i = 0; i < split.length; i++) {
                System.out.println(split[i]);
            }

            //String substring(int beginIndex) 返回一个字符串，该字符串是此字符串的子字符串。
            System.out.println(str3.substring(3)); // b2-c3-d4-e5-f6-g7

            //String substring(int beginIndex,int endIndex) 截取从beginIndex到endIndex之间的数据
            System.out.println(str3.substring(4,9));// 2-c3-  【含头不含尾！】
    	}
12. StringBuilder类
	★ 所在的包
		在java.lang包下！
	★ 大致功能描述
		它是一个可变的字符串！	
	★ 构造方法
		StringBuilder() 构造一个没有字符的字符串构建器，初始容量为16个字符。 
		StringBuilder(String str) 构造一个初始化为指定字符串内容的字符串构建器。  
	★ 方法摘要
		public static void main(String[] args) {
            // 创建StringBuilder类的对象
            StringBuilder sb1 = new StringBuilder();
            System.out.println("sb1:"+sb1); // sb1:

            sb1.append("hello");
            System.out.println("sb1:"+sb1); //sb1:hello

            sb1.append("world");
            System.out.println("sb1:"+sb1); //sb1:helloworld

            sb1.append("java").append("javase").append("javaee");
            System.out.println("sb1:"+sb1); //sb1:helloworldjavajavasejavaee

            // StringBuilder reverse​() 导致该字符序列被序列的相反代替。
            sb1.reverse();
            System.out.println("sb1:"+sb1); //sb1:eeavajesavajavajdlrowolleh

            // 将StringBuilder转成字符串
            print(sb1.toString()); // String toString() 返回表示此顺序中的数据的字符串。

        }

        public static void print(String str){
            System.out.println(str);
        }

13. ArrayList类
	它是一个容器，它的底层就是一个数组(长度可变)！里面的元素是有索引值的！			
		添加和删除效率低！
    	查询和修改效率高！
	在java.util包下！		
		Class ArrayList<E>	
	<E> ： 泛型！ ====>>>对集合中的元素数据的类型进行限定！只能是引用类型！！！！		
		ArrayList<String> list = new ArrayList<>();	
		如果集合中要存放基本数据类型的数据，那么我们在泛型中需要定基本类型对应的包装类！		
			byte		Byte
			short		Short	
			int 		Integer
			long 		Long	
			float		Float
			double		Double
			char 		Character
			boolean		Boolean
			
	public static void main(String[] args) {
        //ArrayList​() 构造一个初始容量为十的空列表。  Class ArrayList<E>
        ArrayList<String> list1 = new ArrayList<>();

        //ArrayList​(int initialCapacity) 构造具有指定初始容量的空列表。
        ArrayList<String> list2 = new ArrayList<>(0);

        // 添加
        //boolean add​(E e) 将指定的元素追加到此列表的末尾。
        list1.add("hello");
        list1.add("world");
        //void add​(int index, E element) 在此列表中的指定位置插入指定的元素。
        list1.add(2,"xxx");
        //System.out.println(list1); //[hello, world, xxx]

        // 修改
        list1.set(1,"yyy");
        //System.out.println(list1); // [hello, yyy, xxx]

        // 删除
        //E remove​(int index) 删除该列表中指定位置的元素。
        //list1.remove(2);
        //System.out.println(list1); // [hello, yyy]
        //boolean remove​(Object o) 从列表中删除指定元素的第一个出现（如果存在）。
        //list1.remove("yyy");
        //System.out.println(list1); // [hello]

        // 查询(获取)
        System.out.println(list1);
        System.out.println(list1.get(0));
        System.out.println(list1.get(1));
        System.out.println(list1.get(2));
    }		
	
    ★ 为什么我们打印集合，得到的内容不是地址值呢？
		只要是引用类型，打印对象，绝对是一个地址值！但是如果它重写了toString方法，那么打印的就不再是地址值	
```

### (1) 类与对象

类是对同一类事物(具有相同属性和行为)的抽象描述，类是对象的数据类型，类是对象的抽象描述
对象是一个具体的事物，它是类的具体实现

### (2) 类的初始化过程

![1565768023897](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1565768023897.png)

### (3) 匿名对象

匿名对象是指创建对象时，只有创建对象的语句，却没有把对象地址值赋值给某个变量。它只能使用一次！

```java
public static void main(String[] args) {
        // 创建对象
        Student student = new Student(); // 创建了一个对象，对象有名字，叫student

    	// 匿名对象
        new Student(); // 也创建了一个对象，只不过它没有名字，所以我们称之为匿名对象！

        // 区别：有名称的对象可以使用多次！匿名对象只能使用一次！
        student.setName("jack");
        student.setAge(30);
        student.show();

        // 下面2个对象不是同一个！每次new都是一个新的！
        new Student().show();
        new Student().setName("rose");
    }
```

## 2. 继承

### (1) 继承概述

![1565769890183](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1565769890183.png)

### (2) 继承格式

父类：一个最基本的类，它里面有子类共有的内容！

``` java
// 员工！
public class Employee {

    String eid;

    String ename;

}
```

子类：去继承父类，通过extends关键字！

```java
// 讲师类
public class Teacher extends Employee{

}
```

此时，父类有的，子类也有了！

```java
public class Main {

    public static void main(String[] args) {

        // 创建子类对象
        Teacher teacher = new Teacher();
        teacher.ename="jack"; // 子类没有这个属性，但是它可以从父类继承过来！
        System.out.println(teacher.ename); // jack

    }
}
```

父类没有的，我子类也可以拥有(自己独特的功能！)

```java
// 讲师类
public class Teacher extends Employee{
	// 子类独有功能！
    public void teach(){
        System.out.println("讲课！");
    }
}
```

```java
public class Main {

    public static void main(String[] args) {

        // 创建子类对象
        Teacher teacher = new Teacher();
        teacher.ename="jack";
        teacher.teach(); // 调用自己独特的方法！
    }

}
```

我们还可以再定义一个类去继承父类Employee

```java
public class ZhuJiao extends Employee{

}
// 此时，子类ZhuJiao也拥有了父类Employee里面的成员变量！
```

> 子类(讲师)是一个父类(员工) ====>>> 子类和父类是一个 is-a的关系！

```markdown
继承的好处：
	★ 提高了代码的复用性！(父类有的，子类全都有！)
	★ 它是多态的前提！【明天学习】
```

### (3) 继承后的特点_成员变量

```markdown
1. 父类和子类的成员变量没有重名
	父类：只能访问父类自己的成员变量
	子类：可以访问自己的成员变量，也可以访问父类的成员变量
```

代码演示：

```java
// 父类
public class Fu {
    int fuNumber = 10;
}

// 子类
public class Zi extends Fu{
    int ziNumber = 20;
}

// 测试类
public class Main {

    public static void main(String[] args) {
        // 创建父类对象
        Fu fu = new Fu();
        System.out.println(fu.fuNumber); // 10
        System.out.println(fu.ziNumber); // 编译报错！

        // 创建子类对象
        Zi zi = new Zi();
        System.out.println(zi.ziNumber); // 20
        System.out.println(zi.fuNumber); // 10

    }
}
```

```markdown
2. 父类和子类成员变量重名
	使用谁的对象(看new的内容)，那么访问的就是谁的成员变量
	如果我们希望在子类中访问父类中的重名成员变量，可以使用super
```

```java
// 父类
public class Fu {
    int number = 10;
    public void show(){
        System.out.println(this.number);
    }
}

// 子类
public class Zi extends Fu {
    int number = 20;

    public void show(){
        //System.out.println(this.number); // 20
        System.out.println(super.number); // 10
    }
}

// 测试类
public class Main {

    public static void main(String[] args) {
        // 创建父类对象
        Fu fu = new Fu();
        fu.show(); // 10

        // 创建子类对象
        Zi zi = new Zi();
        zi.show(); // 10
    }

}
```

### (4) 继承后的特点_成员方法

```markdown
1. 父子类中的成员方法名称未重名
	父类只能访问自己的成员方法
	子类既可以访问自己的成员方法，也可以访问父类的成员方法
```

```java
// 父类
public class Fu {
    public void fuMethod(){
        System.out.println("父类方法执行了！");
    }
}

// 子类
public class Zi extends Fu {
    public void ziMethod(){
        System.out.println("子类方法执行了！");
    }
}

// 测试类
public class Main {

    public static void main(String[] args) {

        // 创建父类对象
        Fu fu = new Fu();
        fu.fuMethod(); // 父类方法执行了！
        //fu.ziMethod(); // 编译报错！

        // 创建子类对象
        Zi zi = new Zi();
        zi.ziMethod(); // 子类方法执行了！
        zi.fuMethod(); // 父类方法执行了！
    }
}
```

```markdown
2. 父子类中成员方法重名
	看new的是父类还是子类，new的是什么，那么调用的就是谁里面的成员方法！
	如果想要在子类中去调用父类重名的方法，可以使用super
```

```java
// 父类
public class Fu {
    public void method(){
        System.out.println("父类方法执行了！");
    }
}

// 子类
public class Zi extends Fu {
    public void method(){
        System.out.println("子类方法执行了！");
        //super.method();
    }
}

// 测试类
public class Main {

    public static void main(String[] args) {

        // 创建父类对象
        Fu fu = new Fu();
        fu.method(); // 父类方法执行了！

        // 创建子类对象
        Zi zi = new Zi();
        zi.method(); // 子类方法执行了！

    }
}
```

### (5) 继承中的方法覆盖重写

```markdown
1. 之前我们学习过方法的重载！
	必须在同一个类中！
	方法名称必须完全一样！
	参数列表不一样(个数、类型)

2. 方法覆盖重写
	发生在不同的类中！(存在继承关系或者实现关系)
	方法签名必须完全一致！(除了访问权限修饰符可以改动，子类的范围必须大于等于父类)
	父类的私有方法不能被子类覆盖重写！
		public protected default private 【从大到小】 
		
	作用：
    	子类对父类的方法进行覆盖重写，那么可以对父类方法里面的功能进行增强！
```

```java
// 老款手机(父类)
public class OldPone {

    public void call(){
        System.out.println("电话");
    }

    public void sendMessage(){
        System.out.println("发文字短信！");
    }

}

// 新手机(子类)
public class Phone extends OldPone{

    @Override
    public void sendMessage() {
        // 沿用父类发短信原始功能！
        super.sendMessage();
        // 对父类发短信功能进行增强！
        System.out.println("带有图片和视频的短信！！！");
    }
}

// 测试类
public class Main {

    public static void main(String[] args) {
        // 创建子类对象
        Phone phone = new Phone();
        //phone.call();
        phone.sendMessage(); // 从父类继承过来！[子类没有任何代码]

        // 在子类中重写父类的方法
    }

}
```

### (6) 继承后的特点_构造方法

```markdown
1. 创建子类对象的时候，会先创建一个父类的对象(会先去调用父类的一个构造方法)
// 父类
public class Fu {
    public Fu(){
        System.out.println("父类的构造方法执行了！");
    }
}

// 子类
public class Zi extends Fu {
    public Zi(){
        System.out.println("子类的构造方法执行了！");
    }
}

// 测试类
public class Main {
    public static void main(String[] args) {
        // 创建子类对象
        Zi zi = new Zi();  // 先执行父类构造方法，再执行子类的构造方法
    }
}

2. 在子类的构造方法中的第一行有一个隐式的super调用（父类的构造）
// 父类
public class Fu {
    public Fu(){
        System.out.println("父类的构造方法执行了！");
    }
}

// 子类
public class Zi extends Fu {
    public Zi(){
        // 子类的构造方法中默认有一个super()
        //super();
        System.out.println("子类的构造方法执行了！");
    }
}

// 测试类
public class Main {
    public static void main(String[] args) {
        // 创建子类对象
        Zi zi = new Zi();  // 先执行父类构造方法，再执行子类的构造方法
    }
}

3. 在子类的构造方法中去使用super调用父类的构造方法【super必须在第一行，而且只能出现一个super】
// 子类
public class Zi extends Fu {
    public Zi(){
        // 子类的构造方法中默认有一个super()
        super(); // 没有问题
        super("jack"); // 编译报错！【只能有一个】
        System.out.println("子类的构造方法执行了！");
        super(); // 编译报错！【位置不对！】
    }
}
```

### (7) super和this

```markdown
this：
	用途：区分本类中成员变量和局部变量的重名问题【局部变量会隐藏成员变量】
	this代表的是本类的一个实例对象，谁调用这个方法，那么这个方法中的this就代表谁！
		this可以操作本类中的成员变量和成员方法以及构造方法！		
super：
	用途：解决子类和父类成员变量和成员方法重名的访问问题
	super代表父类的对象！		
		super它可以操作父类的成员变量、成员方法、构造方法！
	
	System.out.println(super.number); // 父类的成员变量
	super.sendMessage(); // 父类的成员方法
	super("jack"); // 父类的构造方法！
```

![1565778140395](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1565778140395.png)

### (8) 继承的特点

```markdown
1. 在Java中，只能存在单继承！不存在多继承！
	class A extends B // 单继承没有问题
	class A extends B,C // 错误的！

	一个类只能有一个直接父类！

2. 在Java中，一个父类可以有多个子类
	class A extends B
	class C extends B

3. 在Java中，不存在多继承，但是存在多级继承！
	class A extends B
	class B extends C
```

## 3. 抽象类

### (1) 抽象类概述

![1565782981221](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1565782981221.png)

### (2) 抽象类的使用

```markdown
1. 抽象类
	抽象方法：只有方法的定义，没有方法体(实现)，这种方法就是抽象方法
	抽象类：一个类中有抽象方法，那么此时这个类就是一个抽象类
	
2. 抽象类的定义
	定义格式：
		public abstract class 类名{
		
		}
	
3. 抽象方法的定义
	定义格式：
		public abstract 返回值类型 方法名称(参数列表);

4. 抽象类的使用
		// 定义一个抽象类【父类】
        public abstract class Animal {

            // 定义一个抽象方法
            public abstract void eat();

        }	
		
		// 子类
		public class Cat extends Animal {  // alt+enter
            // 子类必须实现父类中的抽象方法！
            @Override
            public void eat() {
                System.out.println("喵星人吃鱼");
            }
        }

		// 子类
		public class Dog extends Animal {

            @Override
            public void eat() {
                System.out.println("汪星人吃骨头！");
            }
        }
        
        // 测试类
        public class Main {
            public static void main(String[] args) {
                // 创建对象
                Dog dog = new Dog();
                dog.eat();

                Cat cat = new Cat();
                cat.eat();

            }
        }
```

### (3) 抽象类和抽象方法的注意事项

```markdown
1. 一个类如果定义为抽象类，那么里面可以没有抽象方法
		public abstract class Animal {
            public void show(){
                System.out.println("show!");
            }
        }

2. 一个类中如果有抽象方法，那么这个类必定是一个抽象类！
		public class Person {  // 报错，需要将类声明为抽象类！
            public abstract void sayHello();
        }

3. 抽象类不能被实例化，可以实例化非抽象子类的对象！
        public class PersonDemo {
            public static void main(String[] args) {
                Person person = new Person(); // 报错！！！！
            }
        }
        
4. 抽象类的所有非抽象子类必须重写抽象类中的抽象方法

5. 抽象类中，可以有构造方法，是供子类创建对象时，初始化父类成员使用的。
		// 定义一个抽象类
        public abstract class Animal {

            private String name;

            public Animal(String name){
                this.name = name;
            }

            // 定义一个抽象方法
            public abstract void eat();

            public void show(){
                System.out.println("show!");
            }

        }
        
        // 非抽象子类
        public class Dog extends Animal {

            public Dog(String name) {
                super("jack");
            }

            @Override
            public void eat() {
                System.out.println("汪星人吃骨头！");
            }
        }
```

> 抽象类：
>
> 只要一个抽象类中有抽象方法，那么子类必须重写父类的抽象方法！！！

## 4. 综合案例_员工类系列定义

```markdown
1. 需求
	某IT公司有多名员工，按照员工负责的工作不同，进行了部门的划分（研发部员工、维护部员工）。研发部根据所需
研发的内容不同，又分为JavaEE工程师、Android工程师；维护部根据所需维护的内容不同，又分为网络维护工程
师、硬件维护工程师。

	公司的每名员工都有他们自己的员工编号、姓名，并要做它们所负责的工作。

	工作内容:
		JavaEE工程师： 员工号为xxx的 xxx员工，正在研发某宝网站
		Android工程师：员工号为xxx的 xxx员工，正在研发某宝手机客户端软件
		网络维护工程师：员工号为xxx的 xxx员工，正在检查网络是否畅通
		硬件维护工程师：员工号为xxx的 xxx员工，正在修复打印机

	请根据描述，完成员工体系中所有类的定义，并指定类之间的继承关系。进行XX工程师类的对象创建，完成工作方法
的调用。
```

```markdown
2. 分析
	类的继承关系！
```

![1565785091897](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1565785091897.png)

```markdown
3. 代码实现
```

```java
// 抽象的父类
public abstract class Employee {

    // 员工编号
    private String eid;

    // 员工姓名
    private String ename;

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    // 工作方法
    public abstract void work();

}
```

```java
public abstract class Developer extends Employee {

}
```

```java
public abstract class Maintain extends Employee {

}
```

```java
// JavaEE工程师
public class JavaEE extends Developer {

    @Override
    public void work() {
        System.out.println("员工号为"+super.getEid()+"的 "+super.getEname()+"员工，正在研发某宝网站");
    }
}
```

```java
// 安卓工程师
public class Android extends Developer {
    @Override
    public void work() {
        System.out.println("员工号为"+super.getEid()+"的 "+super.getEname()+"员工，正在研发某宝手机客户端软件");
    }
}
```

```java
// 网络工程师
public class NetWorker extends Maintain {
    @Override
    public void work() {
        // 自己写！
    }
}
```

```java
// 硬件维护工程师
public class Hardware extends Maintain {
    @Override
    public void work() {
        // 自己写！
    }
}
```

```java
// 测试类
public class Main {
    public static void main(String[] args) {
        // 创建JavaEE研发员工类的对象
        JavaEE javaEE = new JavaEE();
        // 调用方法
        javaEE.setEname("jack");
        javaEE.setEid("e001");
        javaEE.work();

        // 创建Android员工类的对象
        Android android = new Android();
        android.setEid("e002");
        android.setEname("rose");
        android.work();

    }
}
```

