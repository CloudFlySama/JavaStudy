```

```

# 今日内容 #
>* 接口
>* 多态
>* 综合练习

## 1. 接口

### 1.1 概述

```markdown
接口它是一种引用类型！【引用类型：数组、类、接口】
之前我们学习了类，我们知道类中有成员变量、成员方法、构造方法，今天学习的接口着重关注的方法！
接口与类一样，也是一个java文件，最终也会编译成字节码文件(.class文件)，只不过在定义的格式上面有差别！在JDK7以及以前，接口中只能定义抽象方法；在JDK8中还可以定义默认方法、静态方法；在JDK9中已经提供定义私有方法！

接口使用的关键字： interface 【类的关键字是class】
我们定义一个接口之后，是不能创建对象的！(抽象类也不能创建对象)，我们可以单独去定义一个类实现(implements)这个接口；那么，这个类(接口的子类)必须去重写接口中所有的抽象方法(子类是非抽象的)，如果这个子类不想去重写接口里面所有的抽象方法，那么这个子类就必须定义为抽象类！子类可以直接继承接口里面的默认方法和静态方法！

```

### 1.2 定义格式和使用

#### (1) 含有抽象方法 ★★★★★

```markdown
1. 定义格式：
		public interface 接口名称{
			// 定义方法
			public abstract 返回值类型 方法名称();
		}
		
2. 例如：
		public interface Demo01 {
            // 定义抽象方法
            public abstract void method();
        }
		
3. 使用
	单独定义一个子类去实现(implements)接口
		// 这是接口Demo01的一个实现类(子类)
		// 这个子类不是抽象的，那么必须重写接口中所有的抽象方法
        public class Demo01Impl implements Demo01 { 
            @Override
            public void method() {
                System.out.println("重写接口Demo01的方法！");
            }
        }
        // 如果子类不想去重些接口中所有的抽象方法，那么这个子类必须定义抽象类
        public abstract class Demo01Impl1 implements Demo01 {

		} 
	后面创建的是这个接口的实现类(子类)的对象！！！！
```

#### (2) 含有静态方法 【了解】

```markdown
1. 定义格式
		public interface 接口名称{
			public static 返回值类型 方法名称(参数列表){
				// 方法体
			}
		}

2. 例如
		public interface Demo1 {
            // 定义静态方法
            public static void method(){
                System.out.println("接口中的方法！");
            }
        }

3. 使用
	我们可以定义一个类去实现这个接口，但是不能在这个类中去重写接口中的静态方法！
	直接使用接口名称.方法名称();
		public static void main(String[] args) {
           Demo01.method();
        }
   	如果定义了一个类去实现这个接口，那么这个类不用(不允许)重写接口中的静态方法！！！！     
```

#### (3) 含有默认方法

```markdown
1. 定义格式：
        public interface 接口名称{
            public default 返回值类型 方法名称(参数列表){
                // 方法体
            }
        }
2. 例如：
		public interface Demo01 {
            // 定义一个默认方法
            public default void method(){
                System.out.println("接口中的默认方法");
            }
        }
3. 使用：
	定义一个类去实现接口
		public class Demo01Impl implements Demo01 {

		}
	我们在这个实现类中不重写父接口中的默认方法(可以继承父接口的默认方法)
		public static void main(String[] args) {
            Demo01Impl demo01 = new Demo01Impl();
            demo01.method(); // 接口中的默认方法
        }

	我们在实现类中去重写父接口中的默认方法
		public class Demo01Impl implements Demo01 {
            @Override  
            // 上面是一个注解，它的功能是：在编译阶段检查当前这个方法是否重写了父类或者父接口的方法
            //【重写的格式有问题，那么就会编译报错】
            public void method(){
                System.out.println("重写父接口中的默认方法！");
            }
        }
	此时，我们测试，调用的是实现类(子类中的方法)
		public static void main(String[] args) {
            Demo01Impl demo01 = new Demo01Impl();
            demo01.method(); // 重写父接口中的默认方法！
        }
```

#### (4) 含有私有方法 【扩展_了解】

```markdown
在JDK9版本中，接口里面可以定义私有方法！
        public interface Demo01{
            // 定义默认方法1
            public default void method1(){
                System.out.println("abc1");
                /*System.out.println("abc2");
                System.out.println("abc2");
                System.out.println("abc2");*/
                method();
            }
            // 定义默认方法2
            public default void method2(){
                System.out.println("abc1");
                /*System.out.println("abc2");
                System.out.println("abc2");
                System.out.println("abc2");*/
                method();
            }

            // 定义默认方法3
			public default void method3(){
                System.out.println("abc1");
                /*System.out.println("abc2");
                System.out.println("abc2");
                System.out.println("abc2");*/
                method();
            }
            ……
            // 上面定义了很多默认方法，在默认方法中有很多重复的代码，那么可以想到了封装！
            // 我们可以单独定义一个方法，去封装那些重复的代码，提高代码的复用性！
            // 而这个方法，我们只希望在当前的接口中使用，那么我们可以将这个方法定义为private
            private void method(){
            	System.out.println("abc2");
                System.out.println("abc2");
                System.out.println("abc2");
            }
            
            // 上面那个方法，就是JDK9提供的新特性，允许接口中定义私有方法！
        }
```

通过上面知识的学习，我们知道接口中可以定义抽象方法、默认方法、静态方法、私有方法。而这些方法中，我们开发基本上使用的都是**抽象方法**！

```markdown
1. 我们将接口中的方法定义为抽象的目的？
	我们知道，一个类中或者接口中，一旦有抽象方法，那么它的子类就必须重写这个抽象方法！
	抽象方法：只有这个方法的定义，没有这个方法的实现(方法体)，那么此时这个抽象方法就相当于是一个规定！====>>规范
	也就是说，我们可以将接口理解为一套规范！

	使用的好处：
		1. 方便团队开发 (我编写的代码需要调用你负责编写的功能，但是你还没有完成，我不可能等着你；我们可以将这个功能定义在接口中，成为一个抽象方法，我就可以不用等你实现，直接去调用这个方法，你后面有时间了再去实现！)
		2. 能够实现解耦和 【后面讲！】	
		3. 方便扩展 【后面讲！】
		
2. 一个抽象方法可以定义在抽象类中，为什么还要将其定义到接口中呢？
	类与接口是有区别滴！
		类可以继承，但是只能单继承！占用了继承位！
			public abstract class A{
				public abstract void method();
			}
			
			public class B extends A{
				public void method(){
				
				}
			}
			那么此时，类B就不能再继承其它类了，现在有一个类C里面有一个非常Niubility的方法！
		
		接口是可以多实现
			public interface A{
				public abstract void method();
			}
		
			public class B implements A{
				public void method(){
				
				}
			}
			现在有一个类C里面有一个非常Niubility的方法，我们可以直接去继承这个类C！
			public class B extends C implements A{
				
			}
```

> 接口可以解决Java中类的单继承问题！

### 1.3 接口的多实现

#### (1) 格式

```java
public class A implements B,C,D,……{
	
}
// 当然，一个类在实现多个接口的同时，还可以去继承一个父类！
public class A extends B implements C,D,E,……{

}

注意：接口是可以进行多继承的！
	public interface A extends B,C{ // B,C都是接口
	
	}
```

#### (2) 多个接口中含有抽象方法 ★★★★★

```markdown
1. 现在有2个接口，里面所有的抽象方法没有重名，一旦有一个类同时去实现这2个接口，那么这个类就必须重写2个接口中所有的抽象方法！


2. 2个父接口中都是抽象方法，而且抽象方法存在重名的问题，那么这个子类只需要重写一次重名的抽象方法！
```

#### (3) 多个接口中含有默认方法

```markdown
1. 2个父接口中都是默认方法(没重名)，那么子类可以一个不重写父接口的方法！【直接继承过来使用！】

2. 2个父接口中都是默认方法(有重名)，那么子类就必须重写这个重名的方法，其它的方法可以选择性的重写！
```

#### (4) 多个接口中含有静态方法

```markdown
1. 子类中不能重写父接口中的静态方法，也不需要！即使多个父接口中的静态重名了，我们也可以区分(接口名称)！
```

#### (5) 继承实现的优先级问题

```markdown
一个类去继承一个父类和实现一个父接口，这个父类和父接口中有相同的方法，那么在调用子类这个方法的时候，它执行的是父类中的方法！
	public class B {
        // 普通类中的成员方法
        public void show(){
            System.out.println("么么哒！");
        }
    }

	public interface C {
        // 接口中的默认方法
        public default void show(){
            System.out.println("呵呵哒！");
        }
    }

	public class A extends B implements C{
        public static void main(String[] args) {
            A a = new A();
            a.show(); // 么么哒！
        }
    }
```

#### (6) 继承和实现的问题

```markdown
class A 
class B
interface C
interface D

1. 类与类直接是继承关系！
		public class A extends B { // 正确!
		}
		public class A implements B { // 错误！
		}
2. 类与接口之间是实现关系！
		public class B implements C { // 正确!
		}	
		public class B extends C { // 错误！
		}
3. 接口与接口之间继承关系！
		public interface C extends D {  // 正确！

		}		
		public interface C implements D { // 错误！

		}
```

#### (7) 接口中的其它成员

```markdown
1. 接口中不能定义构造方法！
        public interface A {
            public A(){  // 编译报错！

            }
        }

2. 接口中定义的变量我们一般这么写：
		// public static final 数据类型 变量名称 = 数值; 【将变量名称全部大写，此时它其实是一个常量！】
		public static final int NUMBER = 10;  // 常量！

3. 接口中不能书写静态代码块
	静态代码块的格式：
		static{
			// java代码
		}
	
	类中可以：
		public class A extends B {
            static{

            }
        }
  
  	接口中不能写：
  		public interface A { 
            static{  // 错误！

            }
        }
 
 
接口中有很多抽象方法，有一个抽象类去实现这个接口，那么它可以不用重写任何抽象方法！也可以选择性的重写部分抽象方法
那么我们可以编写一个非抽象类去继承这个抽象类，我们就只需要重写那些还没有重写的抽象方法！
 demo11代码演示！
```

## 2. 多态

### 2.1 多态概述

```markdown
1. 多态它是面向对象的三大特征之一(封装、继承、多态)
2. 多态指的就是一个事物的多种形态！
	比如： 我，在孩子的面前，我是一个父亲(父亲的形态)；在妻子的面前，我是一个丈夫(丈夫的形态)
3. 多态使用的前提
		必须存在继承或者实现关系！
4. 多态的体现
	有2个地方：
		★ 创建对象：  父类/接口名 对象名称 = new 子类名();
		★ 方法的形参位置： 
			// 定义方法
			public void show(父类名 变量){}
			// 调用方法
			show(子类对象);
```

### 2.2 多态体现代码演示

```java
// 父接口
public interface Animal {
    public abstract void eat();
}

// 子类
public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("狗吃骨头！");
    }
}

// 测试类
public class Main {
    public static void main(String[] args) {
        // 以前这么干！
       /* Dog dog = new Dog();
        dog.eat();*/

       // 现在使用多态
       Animal animal = new Dog(); // 父类引用指向子类对象！
       animal.eat();
    }
}
```

### 2.3 向下转型

> 一旦调用子类独有的方法，那么使用多态，必须向下转型！

> ★★★★  多态操作，编译看左边、运行看右边！

```java
1. 格式：
	子类类名 对象名称 = (子类类名)父类对象;

// 父接口
public interface Animal {
    public abstract void eat();
}

// 子类
public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("狗吃骨头！");
    }
    
    // 子类自己独有功能！
    public void houseKeeping(){
        System.out.println("狗狗看家");
    }
}

// 测试类
public class Main {
    public static void main(String[] args) {
       //使用多态
       Animal animal = new Dog(); // 父类引用指向子类对象！
       animal.eat(); // 没问题！
       
        // 编译报错，编译看左边！左边是Animal,它里面没有这个方法，所以报错！
        // animal.houseKeeping(); // 编译报错！
       
        // 向下转型
        Dog dog = (Dog)animal; // 向下转型！
        dog.houseKeeping(); // 没问题！
    }
}
```

### 2.4 向下转型安全问题

```java
// 父接口
public interface Animal {
    public abstract void eat();
}

// 子类
public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("狗吃骨头！");
    }
    
    // 子类自己独有功能！
    public void houseKeeping(){
        System.out.println("狗狗看家");
    }
}

// 子类
public class Cat implements Animal {

    @Override
    public void eat() {
        System.out.println("猫吃鱼！");
    }

    public void catchMouse(){
        System.out.println("猫捉老鼠！");
    }

}

// 测试类
public class Main {
    public static void main(String[] args) {
        // 使用多态
        Animal animal = new Dog(); // 父类引用指向子类对象！
        animal.eat();
        // animal.catchMouse(); // 编译报错！

        // 向下转型！【狗是动物，猫也是动物】
        Cat cat = (Cat)animal;
        // 编译不报错！编译看左边！左边是cat,cat里面有catchMouse方法！
        cat.catchMouse(); // 运行看右边！右边是dog,dog里面没有这个方法，运行报错！
    }
}	
```

### 2.5 向下转型安全处理

```markdown
我们使用instanceof来对类型进行判断！

    if(animal instanceof Cat){
        Cat cat = (Cat)animal;
        cat.catchMouse();
    }else{
        Dog dog = (Dog)animal;
        dog.houseKeeping();
    }

结论：向下转型慎用！
```

> 多态的体现，本身就是一个向上转型！  不存在问题！

### 2.6 多态的好处

> 实际开发的过程中，父类类型作为方法形式参数，传递子类对象给方法，进行方法的调用，更能体现出多态的扩展性与便利。

```java
// 父接口
public interface Animal {
    public abstract void eat(Animal animal);
}

// 子类
public class Dog implements Animal {
    @Override
    public void eat(Animal animal) { // 定义方法是形参，父类类型作为方法形式参数
        System.out.println("汪星人吃骨头！！！！！");
    }
}

// 子类
public class Cat implements Animal {
    @Override
    public void eat(Animal animal) { // 定义方法是形参，父类类型作为方法形式参数
        System.out.println("喵星人吃鱼！！！！！！");
    }
}

// 测试类
public class Main {
    public static void main(String[] args) {
        //创建Dog对象
        //Animal animal = new Dog();

        //创建Cat对象
        Animal animal = new Cat();
        animal.eat(animal); // 传递子类对象cat给方法
    }
}
```

## 3. 综合练习

```markdown
1. 需求
	定义笔记本类，具备开机，关机和使用USB设备的功能。具体是什么USB设备，笔记本并不关心，只要符合USB规格
的设备都可以。鼠标和键盘要想能在电脑上使用，那么鼠标和键盘也必须遵守USB规范，不然鼠标和键盘的生产出来
无法使用;
	进行描述笔记本类，实现笔记本使用USB鼠标、USB键盘
		USB接口，包含开启功能、关闭功能
		笔记本类，包含运行功能、关机功能、使用USB设备功能
		鼠标类，要符合USB接口
		键盘类，要符合USB接口

2. 分析：
	USB接口：有方法 开启open 关闭close
	鼠标类：需要实现USB接口(重写USB接口里面的2个方法)
	键盘类：需要实现USB接口(重写USB接口里面的2个方法)
	笔记本类：有方法 开机start 关机stop 使用usb设备useUSB
```

```java
// USB接口
public interface USB {

    // 开启功能
    public abstract void open();

    // 关闭功能
    public abstract void close();

}

// 键盘类 
public class KeyBoard implements USB {
    @Override
    public void open() {
        System.out.println("键盘开启，绿灯亮了！");
    }

    @Override
    public void close() {
        System.out.println("键盘关闭，绿灯灭了！");
    }
}

// 鼠标类
public class Mouse implements USB {

    @Override
    public void open() {
        System.out.println("鼠标开启，红灯亮了！");
    }

    @Override
    public void close() {
        System.out.println("鼠标关闭，红灯灭了！");
    }
}

// 笔记本类
public class NoteBook {

    // 开机
    public void start(){
        System.out.println("开机");
    }

    // 使用设备
    public void useUSB(USB usb){ // 多态体现(定义方法使用父类类型)
        // 判断
        if(usb instanceof KeyBoard){
            KeyBoard keyBoard = (KeyBoard)usb;
            keyBoard.open();
            keyBoard.close();
        }else if(usb instanceof Mouse){
            Mouse mouse = (Mouse)usb;
            mouse.open();
            mouse.close();
        }
    }

    // 关机
    public void stop(){
        System.out.println("关机！");
    }
}

// 测试类
public class Main {

    public static void main(String[] args) {
        // 创建笔记本类的对象
        NoteBook noteBook = new NoteBook();
        // 开机
        noteBook.start();

        // 使用设备
        //USB usb = new KeyBoard(); // 键盘
        USB usb = new Mouse();
        noteBook.useUSB(usb);

        // 关机
        noteBook.stop();
    }

}
```

