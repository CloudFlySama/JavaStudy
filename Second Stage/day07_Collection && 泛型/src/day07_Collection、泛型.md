```markdown
昨日内容回顾
	★ 多线程实现方式
		1. 继承Thread类
			// 编写线程类去继承Thread类，重写run方法
			public class MyThread extends Thread {
                public MyThread(String name) {
                    super(name);
                }

                @Override
                public void run() {
                    for (int i = 1; i <= 20; i++) {
                        // 调用从父类继承过来getName方法获得当前线程的名称
                        System.out.println(this.getName()+"我爱黄焖鸡:"+ i);
                    }
                }
            }
            
            // 创建线程对象，调用start方法
            public class Main {
                public static void main(String[] args) {
                    // 创建自定义线程类对象
                    MyThread myThread = new MyThread("新线程：");
                    // 启动这个新线程
                    myThread.start();

                    // 主线程的功能！
                    for (int i = 1; i <= 10; i++) {
                        System.out.println("main线程："+i);
                    }
                }
            }
		
		2. 实现Runnable接口
			// 编写一个类去实现Runnable接口
			 public class MyThread implements Runnable{
                @Override
                public void run() {
                    for (int i = 0; i < 20; i++) {
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
            
            // 创建自定义线程类的对象作为Thread构造方法的参数
            public static void main(String[] args) {
                // 创建MyThread线程类的对象
                MyThread myThread = new MyThread();

                // Thread​(Runnable target) 分配一个新的 Thread对象。
                //Thread thread = new Thread(myThread);

                // Thread​(Runnable target, String name) 分配一个新的 Thread对象。
                Thread thread = new Thread(myThread,"新线程");

                thread.start();
            }
		
		3. 匿名内部类方式
			public static void main(String[] args) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 20; i++) {
                            System.out.println(Thread.currentThread().getName()+":"+i);
                        }
                    }
                },"新线程").start();
            }
	
    ★ 线程安全
    	1. 导致线程安全问题的原因
    		多个线程对成员变量进行了写(修改)操作！
    	
    	2. 线程安全问题处理_同步代码块
    		public void run() {
    			synchronized(任意对象锁){
			
				}
    		}
    	
    	3. 线程安全问题处理_同步方法
    		public synchronized void 方法名称(){
                // 执行具体任务功能的代码
            }
    	
    	4. 线程安全问题处理_Lock锁
    		获得锁：
                void lock​() 获得锁。  
            释放锁：
                void unlock​() 释放锁。
    	
	★ 线程状态
		1. 线程状态
			当线程被创建并启动以后，它既不是一启动就进入了执行状态，也不是一直处于执行状态
			新建、可运行、锁阻塞、无限等待、计时等待、被终止
		
		2. 睡眠sleep方法
			Thread.sleep(1000);
		
		3. 等待和唤醒
			public void wait() : 让当前线程进入到等待状态 此方法必须锁对象调用
			public void notify() : 唤醒当前锁对象上等待状态的线程 此方法必须锁对象调用.
			
			public static void main(String[] args) {

                Object obj = new Object();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (obj){
                            try {
                                System.out.println("start....");
                                obj.wait();
                                System.out.println("end.....");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();

                // 沉睡3秒
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 开启新线程，唤醒
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (obj){
                            System.out.println("唤醒.....");
                            obj.notify();
                        }
                    }
                }).start();

            }
```

# 今日内容介绍

> - Collection集合(常用集合类体系结构以及Collection集合常用方法)
> - 迭代器Iterator(Iterator接口和实现原理以及增强for循环)
> - 泛型
> - 集合综合案例

## 1. Collection集合

### 1.1 集合概述

```markdown
前面我们学习了数组，数组它是一个容器，可以存放多个元素数据！数组可以存放任意类型的数据，同一个数组中所有元素数据的类型必须相同！ 
集合：它也是一个容器，里面可以存放多个数据！它是一种引用类型！

集合与数组的区别？
	1. 数组里面可以存放任意类型的数据(基本类型和引用类型)，只要同一个数组里面的元素数据类型一致即可！
		集合中只能存放引用类型！！！！
	2. 数组一旦定义，它的长度就固定了！集合的长度是可变的！
	
集合是通过一些对象来体现的 ！
	Collection是整个单列集合的顶层对象(接口)！
		单列：像我们之前学习的ArrayList它就是一个单列的集合对象！
			ArrayList<String> list = new ArrayList<String>();
			list.add("java"); // 直接向list集合中添加数值java！
		双列：后面我们会学习一个map集合，它就是一个双列的
			Map<String,String> map = new HashMap<String,String>();
			map.put("name","jack");	// 添加数值jack的同时，取了一个名字name 
```

### 1.2 集合常用类的继承体系

```markdown
Collection是整个单列集合的顶层对象(接口)！ public interface Collection
在这个接口中有2个常用的直接子接口：List和Set
	public interface List extends Collection
	public interface Set extends Collection
List:有序的！元素可以重复！
	List接口中有2个常用的实现类：
		LinkedList
		ArrayList
Set：无序的，元素不能重复！
	Set接口有2个常用的实现类：
		TreeSet
		HashSet

今天我们主要学习Collection顶层父接口的方法，那么后面再学习这个接口的子接口或者子实现类的时候，就不用再关注这些学过的方法，只需要关注自己特有的功能即可！

以后学习一个对象的体系结构，先从顶层开始，最终使用底层的对象！
```

![1566543782883](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566543782883.png)

### 1.3 Collection常用功能

Collection是所有**单列集合的父接口**，因此在Collection中定义了单列集合(List和Set)通用的一些方法，这些方法可用于操作所有的单列集合。方法如下：

```java
public boolean add(E e) ： 把给定的对象添加到当前集合中 。
public void clear() :清空集合中所有的元素。
public boolean remove(E e) : 把给定的对象在当前集合中删除。
public boolean contains(Object obj) : 判断当前集合中是否包含给定的对象。
public boolean isEmpty() : 判断当前集合是否为空。
public int size() : 返回集合中元素的个数。
public Object[] toArray() : 把集合中的元素，存储到数组中
```

**代码演示：**

```java
public static void main(String[] args) {

        // 创建Collection接口的子类对象
        Collection<String> coll = new ArrayList<>(); // 父接口的引用指向子类对象[多态]

        //public boolean isEmpty() : 判断当前集合是否为空。
        System.out.println(coll.isEmpty()); // true

        //public int size() : 返回集合中元素的个数。
        System.out.println(coll.size()); // 0
        System.out.println(coll); // []

        //public boolean add(E e) ： 把给定的对象添加到当前集合中 。
        coll.add("itheima");
        coll.add("itcast");
        coll.add("hello");
        coll.add("java");
        System.out.println(coll.size()); // 4
        System.out.println(coll); // [itheima, itcast, hello, java]

        //public boolean contains(Object obj) : 判断当前集合中是否包含给定的对象。
        System.out.println(coll.contains("java")); // true
        System.out.println(coll.contains("javaee")); // false

        System.out.println(coll.isEmpty()); // false


        //public boolean remove(E e) : 把给定的对象在当前集合中删除。
        coll.remove("hello");
        System.out.println(coll); // [itheima, itcast, java]

        //public Object[] toArray() : 把集合中的元素，存储到数组中
        Object[] array = coll.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]); // itheima itcast java
        }

        //public void clear() :清空集合中所有的元素。
        coll.clear();
        System.out.println(coll); // []

    }
```

> **Tips：tips: 有关Collection中的方法可不止上面这些，其他方法可以自行查看API学习。**

## 2. Iterator迭代器

### 2.1 Iterator接口

在程序开发中，经常需要遍历集合中的所有元素。针对这种需求，JDK专门提供了一个接口 java.util.Iterator 。
想要遍历Collection集合，那么就要获取该集合迭代器完成迭代操作，下面介绍一下获取迭代器的方法：

```java
Iterator<E> iterator​() 返回此集合中元素的迭代器。  // 通过Collection接口对象的iterator方法获得迭代器  
```

**迭代：**即Collection集合元素的通用获取方式。在取元素之前先要判断集合中有没有元素，如果有，就把这个元
素取出来，继续再判断，如果还有就再取出来。一直把集合中的所有元素全部取出。这种取出方式专业术语称
为迭代。

Iterator接口的常用方法如下：

```java
public E next() :返回迭代的下一个元素。
public boolean hasNext() :如果仍有元素可以迭代，则返回 true。
```

**代码演示：**

```java
public static void main(String[] args) {

    // 创建Collection接口的子类对象
    Collection<String> coll = new ArrayList<>(); // 父接口的引用指向子类对象[多态]

    //public boolean add(E e) ： 把给定的对象添加到当前集合中 。
    coll.add("itheima");
    coll.add("itcast");
    coll.add("hello");
    coll.add("java");

    // 原始for循环的方式遍历集合中的元素数据
    /*for (int i = 0; i < coll.size(); i++) {
            // 使用的是多态，调用方法，编译看左边！Collection中没有这个方法！
            ArrayList list = (ArrayList) coll;
            System.out.println(list.get(i));
        }*/

    // 使用Iterator迭代器获得集合中的元素数据

    // Iterator<E> iterator​() 返回此集合中元素的迭代器。
    Iterator<String> iterator = coll.iterator();
    //public boolean hasNext() :如果仍有元素可以迭代，则返回 true。
    while (iterator.hasNext()){
        //public E next() :返回迭代的下一个元素。
        String next = iterator.next();
        System.out.println(next);
    }
}
```

> Tips:
>
> 1. 在进行集合元素获取时，如果集合中已经没有元素了，还继续使用迭代器的next方法，将会抛出
>    java.util.NoSuchElementException没有集合元素异常。
>
> 2. 在进行集合元素获取时，如果添加或移除集合中的元素 , 将无法继续迭代 , 将会抛出
>    ConcurrentModificationException并发修改异常.

**代码演示：**

```java
public static void main(String[] args) {

    // 创建Collection接口的子类对象
    Collection<String> coll = new ArrayList<>(); // 父接口的引用指向子类对象[多态]

    // 使用迭代器获得元素
    Iterator<String> iterator = coll.iterator();
    //System.out.println(coll); // []
    System.out.println(iterator.next());

}
```

```java
public static void main(String[] args) {

    // 创建Collection接口的子类对象
    Collection<String> coll = new ArrayList<>(); // 父接口的引用指向子类对象[多态]

    //public boolean add(E e) ： 把给定的对象添加到当前集合中 。
    coll.add("itheima");
    coll.add("itcast");
    coll.add("hello");
    coll.add("java");

    // 使用迭代器获得元素
    Iterator<String> iterator = coll.iterator();

    // 获得迭代器之后，如果对集合中的元素进行的添加和删除(修改)操作，那么也会出现异常：ConcurrentModificationException
    coll.remove("hello");

    // 迭代获取集合中的每个元素
    while (iterator.hasNext()){
        System.out.println(iterator.next());
    }
}
```

### 2.2 迭代器的实现原理

```markdown
我们在之前案例已经完成了Iterator遍历集合的整个过程。当遍历集合时，首先通过调用集合的iterator()方法获得迭
代器对象，然后使用hashNext()方法判断集合中是否存在下一个元素，如果存在，则调用next()方法将元素取出，否
则说明已到达了集合末尾，停止遍历元素。
```

![1566547221481](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566547221481.png)

### 2.3 增强for

增强for循环(也称for each循环)是JDK1.5以后出来的一个高级for循环，**专门用来遍历数组和集合的**。它的内部原理
其实是个Iterator迭代器，所以在遍历的过程中，不能对集合中的元素进行增删操作。

**格式：**

```java
for(数据类型 变量名称:被遍历的数据){
    // 业务操作代码！
}
// 数据类型：集合中存放元素的数据类型
// 被遍历对象：集合对象或者数组对象
```

**代码演示：**

```java
public static void main(String[] args) {

    // 创建Collection接口的子类对象
    Collection<String> coll = new ArrayList<>(); // 父接口的引用指向子类对象[多态]

    //public boolean add(E e) ： 把给定的对象添加到当前集合中 。
    coll.add("itheima");
    coll.add("itcast");
    coll.add("hello");
    coll.add("java");

    // 增强的for循环
    for(String str:coll){
        System.out.println(str);
    }

}

// 小技巧：增强for循环的快捷键：被遍历对象.iter+回车
```

> Tips：
>
> 1. 增强for循环必须有被遍历的目标，目标只能是Collection或者是数组；
> 2. 增强for（迭代器）仅仅作为遍历操作出现，不能对集合进行增删元素操作，否则抛出
>    ConcurrentModificationException并发修改异常

## 3. 泛型

### 3.1 泛型概述

在前面学习集合时，我们都知道集合中是可以存放任意对象的，只要把对象存储集合后，那么这时他们都会被提升成Object类型。当我们在取出每一个对象，并且进行相应的操作，这时必须采用类型转换。

**代码演示：**

```java
public static void main(String[] args) {

    // 创建Collection接口的子类对象
    Collection coll = new ArrayList(); // 父接口的引用指向子类对象[多态]

    // 向集合中添加元素
    coll.add("itheima");
    coll.add("itcast");
    coll.add("hello");
    coll.add("java");
    // 向集合中添加一个数字 【在没有指定集合中存放元素的数据类型时，它就是Object类型】
    coll.add(5);

    // 使用Iterator迭代器获取集合中的元素
    Iterator iterator = coll.iterator();
    while (iterator.hasNext()){
        // 只要把对象存储集合后，那么这时他们都会被提升成Object类型
        Object obj = iterator.next();
        // 向下转型！
        String str = (String)obj;

        System.out.println(str.length());
    }
}
```

> 程序在运行时发生了问题java.lang.ClassCastException。 为什么会发生类型转换异常呢？

```markdown
在没有指定集合中元素的数据类型时，它里面存放数据的类型就是Object,我们是可以将一个数字给它添加到集合中！
在代码：String str = (String)obj;出现类型转换异常！ 不能将数字直接强转为String类型！
```

> Tips:一般在创建对象时，将未知的类型确定具体的类型。当没有指定泛型时，默认类型为Object类型。

### 3.2 泛型的好处

```markdown
★ 将运行时期的ClassCastException，转移到了编译时期变成了编译失败。
★ 避免了类型强转的麻烦。
```

**代码演示：**

```java
public static void main(String[] args) {

    // 创建Collection接口的子类对象
    Collection<String> coll = new ArrayList<>(); // 父接口的引用指向子类对象[多态]

    // 向集合中添加元素
    coll.add("itheima");
    coll.add("itcast");
    coll.add("hello");
    coll.add("java");
    // 向集合中添加一个数字
    //coll.add(5);  // 编译报错！
    // 一旦集合指定了泛型的类型，那么就会将运行时期的ClassCastException，转移到了编译时期变成了编译失败

    // 使用Iterator迭代器获取集合中的元素
    Iterator<String> iterator = coll.iterator();
    while (iterator.hasNext()){
        /*Object obj = iterator.next();
            // 向下转型！
            String str = (String)obj;*/
        String str = iterator.next();
        System.out.println(str.length());
    }

}
```

### 3.3 泛型的定义与使用

我们在集合中会大量使用到泛型。泛型是数据类型的一部分，我们将类名与泛型合并一起看做数据类型。

泛型，用来灵活地将数据类型应用到不同的**类、方法、接口**当中。将数据类型作为参数进行传递。

#### 3.3.1 定义和使用含有泛型的类

**定义格式：**

```java
修饰符 class 类名<代表泛型的变量> { }  // 查阅ArrayList的源码
```

查看ArrayList的源代码: 

```java
// ctrl+shift+t 搜索框输入你要查看的源代码对应的类名 回车
// alt+7查看类中的所有方法的描述

public class ArrayList<E>{
    public boolean add(E e) {}
    
    public E remove(int index) {}
    
    .....其它方法的描述！
}

```

**使用：在创建对象的时候确定泛型**

```java
// 在创建类的对象的时候，指定泛型的类型
ArrayList<String> list1 = new ArrayList<>(); 
// 相当于之前定义ArrayList类的写法为：
// public class ArrayList<E>{}
public class ArrayList<String>{
    
}

// 如果创建对象指定泛型类型为Integer
ArrayList<Integer> list2 = new ArrayList<>();
// 那么此时，定义ArrayList类的写法为：
public class ArrayList<Integer>{
    
}
```

#### 3.3.2 含有泛型的方法

**定义格式：**

```java
修饰符 <代表泛型的变量> 返回值类型 方法名(参数){ } 
```

```java
// 定义含有泛型的方法
public static <E> void show1(E e){
	System.out.println(e.getClass());
}

// 定义含有泛型的方法
public static <Mvp> Mvp show2(Mvp mvp){
	return mvp;
}
```

**使用：调用方法时，确定泛型的类型**

```java
public static void main(String[] args) {
    // 在调用方法的时候，确定泛型的类型[本身泛型的类型是任意类型的，必须是引用类型]
    show1("abc"); // class java.lang.String 【此时泛型的类型就是字符串】
    show1(1); // class java.lang.Integer

    String s = show2("abc");
    Integer integer = show2(1);
}

// 定义含有泛型的方法
public static <E> void show1(E e){
    System.out.println(e.getClass());
}

// 定义含有泛型的方法
public static <Mvp> Mvp show2(Mvp mvp){
    return mvp;
}
```



#### 3.3.3 含有泛型的接口

**定义格式：**

```java
修饰符 interface 接口名<代表泛型的变量> { } // 例如 List接口的定义为：public interface List<E>{}
```

```java
public interface Demo05<E> {

    public abstract void show1(E e);

    public abstract E getElement();

}
```

**使用1：定义类时确定泛型的类型**

```java
// 定义类的时候没有确定泛型类型，类型就是Object
public class Demo5Impl implements Demo05 {
    @Override
    public void show1(Object obj) {
        
    }

	// 定义类的时候没有确定泛型类型，类型就是Object
    @Override
    public Object getElement() {
        return null;
    }
}
```

```java
// 定义类的时候确定泛型的类型为String
public class Demo5Impl2 implements Demo05<String> {

    @Override
    public void show1(String str) {

    }

    // 定义类已经指定泛型类型，所以这里返回值类型就是String
    @Override
    public String getElement() {
        return null;
    }
}
```

**使用2：始终不确定泛型的类型，直到创建对象时，确定泛型的类型**

```java
public class Demo5Impl3<E> implements Demo05<E> {

    public static void main(String[] args) {
        Demo5Impl3<String> demo5Impl3 = new Demo5Impl3<>();
        demo5Impl3.show1("123"); // class java.lang.String
    }


    @Override
    public void show1(E e) {
        System.out.println(e.getClass());
    }

    @Override
    public E getElement() {
        return null;
    }

}
```

### 3.4 泛型通配符

当使用泛型类或者接口时，传递的数据中，泛型类型不确定，可以通过通配符<?>表示。但是一旦使用泛型的通配符后，只能使用Object类中的共性方法，集合中元素自身方法无法使用。

#### 3.4.1 通配符基本使用

泛型的通配符:**不知道使用什么类型来接收的时候,此时可以使用表示未知通配符?**

> ★ 此时只能接受数据,不能往该集合中存储数据。
>
> ★ 泛型不存在继承关系

```java
public static void main(String[] args) {
    // 创建一个Collection对象，泛型类型指定为String
    Collection<String> coll1 = new ArrayList<>();
    // 调用方法
    getElement(coll1); // 此时在方法getElement的形参Collection的泛型类型就为String

    // 创建一个Collection对象，泛型类型为Integer
    Collection<Integer> coll2 = new ArrayList<>();
    // 调用方法
    getElement(coll2); // 此时在方法getElement的形参Collection的泛型类型就为Integer

    // 创建一个Collection对象，泛型类型为User
    Collection<User> coll3 = new ArrayList<>(); // 需要单独定义一个User类！
    // 调用方法
    getElement(coll3); // 此时在方法getElement的形参Collection的泛型类型就为User
}


// 定义方法 [?代表可以接受任意类型！]  不知道使用什么类型来接收的时候,此时可以使用表示未知通配符?
public static void getElement(Collection<?> collection){
    // 注意：此时只能接受数据,不能往该集合中存储数据
    // collection.add("str"); // 报错！
}
```

#### 3.4.2 通配符高级使用----受限泛型

之前设置泛型的时候，实际上是可以任意设置的，只要是类就可以设置。但是在JAVA的泛型中可以指定一个泛型的**上限**和**下限**。

**泛型的上限：**

```java
类型名称<? extends 类 > 对象名称    // 只能接收该类型及其子类
```

**泛型的下限：**

```java
类型名称<? super 类 > 对象名称  // 只能接收该类型及其父类型
```

**代码演示：**

```
现已知Object类，String 类，Number类，Integer类，其中Number是Integer的父类
```

```java
// 现已知Object类，String 类，Number类，Integer类，其中Number是Integer的父类
public static void main(String[] args) {
    // 定义Collection集合对象
    Collection<Object> coll1 = new ArrayList<>();
    Collection<String> coll2 = new ArrayList<>();
    Collection<Number> coll3 = new ArrayList<>();
    Collection<Integer> coll4 = new ArrayList<>();

    //getElement1(coll1); // Object
    //getElement1(coll2); // String
    getElement1(coll3); // Number
    getElement1(coll4); // Integer

    getElement2(coll1); // Object
    //getElement2(coll2); // String
    getElement2(coll3); // Number
    //getElement2(coll4); // Integer

}

// 定义方法：使用泛型的上限 【只能接受Number类型或者它的子类】
public static void getElement1(Collection<? extends Number> collection){

}


// 定义方法：使用泛型的下限 【只能接受Number类型或者它的父类】
public static void getElement2(Collection<? super Number> collection){

}
```

## 4. 集合综合案例

### 4.1 案例需求

```
按照斗地主的规则，完成洗牌发牌的动作。 
具体规则：
	使用54张牌打乱顺序,三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌。
```

### 4.2 案例分析

大体三个步骤：**准备牌操作、洗牌、发牌、看牌**

```markdown
★准备牌操作
	1. 创建牌盒集合，将来存储牌面的
	2. 创建花色集合
	3. 创建数字集合
	4. 分别给花色(红桃、黑桃、方片、梅花) 以及 数字集合添加元素(2-10 J Q K A 大王 小王)
	5. 创造牌拼接牌操作
		拿出每一个花色 然后跟每一个数字 进行结合 存储到牌盒中 (嵌套遍历)
			牌是由花色和数字组合(拼接)，添加到牌盒中
		牌盒需要添加 大王和小王

★洗牌
	Collections类的shuffle方法进行随机排序。

★发牌
	1. 创建三个玩家集合和一个底牌集合ArrayList<String>
	2. 遍历牌盒必须知道索引(传统遍历) 
	3. 获取牌面(list的get方法)
	4. 留三种牌面保存到底牌集合(i>=51)，其余添加到三个玩家(对3取余)集合	

★ 看牌
	打印3个玩家集合
```

### 4.3 代码实现

```java
public class Poker {

    public static void main(String[] args) {
        // 1. 准备牌操作
        // 1.1 创建牌盒集合，将来存储牌面的
        ArrayList<String> pokerBox = new ArrayList<>();
        // 1.2 创建花色集合
        ArrayList<String> colors = new ArrayList<>();
        // 1.3 创建数字集合
        ArrayList<String> numbers = new ArrayList<>();
        // 1.4 分别给花色(红桃、黑桃、方片、梅花)
        colors.add("♥");
        colors.add("♠");
        colors.add("♦");
        colors.add("♣");
        // 1.5 数字集合添加元素(2-10 J Q K A 大王 小王)
        for (int i = 2; i <=10 ; i++) {
            numbers.add(i+"");
        }
        numbers.add("J");
        numbers.add("Q");
        numbers.add("k");
        numbers.add("A");
        // 1.6 创造牌拼接牌操作（由花色和数字构成）
        for (String color : colors) {
            // 1.7 遍历数字
            for (String number : numbers) {
                // 1.8 拼接牌面
                String pokerFace = color+number;
                // 1.9 添加到牌盒中
                pokerBox.add(pokerFace);
            }
        }
        // 1.10 牌盒中还需要添加大王和小王
        pokerBox.add("小☺");
        pokerBox.add("大☠");

        // 2. 洗牌(只需要打乱牌盒对应集合中的元素顺序即可)
        Collections.shuffle(pokerBox);

        // 3. 发牌
        // 3.1 创建三个玩家集合和一个底牌集合ArrayList<String>
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> diPai = new ArrayList<>();
        
        // 3.2 遍历牌盒必须知道索引(传统遍历)
        for (int i = 0; i < pokerBox.size(); i++) {
            // 3.3 获得牌面
            String pokerFace = pokerBox.get(i);
            // 3.4 留三种牌面保存到底牌集合(i>=51)
            if(i>=51){
                // 将对应的牌面添加底盘的集合中
                diPai.add(pokerFace);
            }else{
                //其余添加到三个玩家(对3取余)集合
                if(i%3==0){ // 第一个玩家
                    player1.add(pokerFace);
                }else if(i%3==1){ // 第二个玩家
                    player2.add(pokerFace);
                }else if(i%3==2){ // 第三个玩家
                    player3.add(pokerFace);
                }
            }
        }

        // 4. 看牌
        System.out.println("jack的牌面是：" + player1);
        System.out.println("rose的牌面是：" + player2);
        System.out.println("tom的牌面是：" + player3);
        System.out.println("底牌是：" + diPai);
    }
}
```

**运行结果：**

```java
jack的牌面是：[♣J, ♣Q, ♣k, ♥4, ♠A, ♠6, ♥9, ♦5, ♥7, ♦4, ♦9, ♦2, ♣6, ♠Q, ♦A, ♥10, ♥k]
rose的牌面是：[♦k, ♥8, ♠9, ♠k, ♠5, ♣2, ♣8, 大☠, ♠3, ♦Q, ♦J, ♠7, ♠4, ♠8, ♠J, ♣7, ♣A]
tom的牌面是：[♣3, ♥J, ♣5, ♥5, ♣10, ♦3, ♠10, ♥6, ♥A, ♠2, ♥2, ♦6, 小☺, ♥Q, ♦8, ♣4, ♦7]
底牌是：[♦10, ♣9, ♥3]
```