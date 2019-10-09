```markdown
1. 并行和并发
	并行：2个或者多个事物，在同一时刻！
	并发：2个或者多个事物，在同一时间段！

2. 进程与线程
	进程：电脑正在运行的某个应用程序(至少有1个进程)
	线程：一个进程中至少有1个线程。如果一个程序里面有多个线程，那么此程序就是一个多线程程序！

	java中的多线程采用的是抢占式的！
	
3. 多线程的基本操作
	在java.lang包下有1个Thread类，代表程序中执行的线程。
		public class Thread extends Object implements Runnable

	首先需要定义一个多线程类去继承Thread，重写run方法(当前线程类的具体任务都在这个方法中)
	然后需要创建多线程类的对象(构造方法)，调用start方法去启动线程！
		Thread​() 分配一个新的 Thread对象。【创建线程对象，使用系统默认分配的线程名称】  
		Thread​(String name) 分配一个新的 Thread对象。【创建线程对象，指定线程名称】  

	Thread类的常用方法：
		String getName​() 返回此线程的名称。  
		void start​() 导致此线程开始执行; Java虚拟机调用此线程的run方法。 

	一个程序至少有1个线程！【我们编写的代码要运行，至少有1个主线程！】

4. 代码演示：
	
     ★自定义线程类
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
	★测试类
		public class Main {
            public static void main(String[] args) {
                // 创建自定义线程类对象【有参构造方法】
                MyThread myThread = new MyThread("新线程：");
                // 启动这个新线程
                myThread.start();

                // 主线程的功能！
                for (int i = 1; i <= 10; i++) {
                    System.out.println("main线程："+i);
                }
            }
        }
```

# 今日内容介绍

> - 多线程(原理、三种操作方式)
> - 线程安全(同步代码块和同步方法)
> - 线程状态(睡眠、等待和唤醒)

## 1. 多线程

### 1.1 多线程原理

```markdown
1. 自定义了一个线程类【采用继承Thread类的方式】
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
2. 编写了一个测量类，创建自定义线程类的对象，启动这个线程
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
        
 3. 运行结果：【java中多线程采用抢占式】
        main线程：1
        新线程：我爱黄焖鸡:1
        main线程：2
        新线程：我爱黄焖鸡:2
        main线程：3
        新线程：我爱黄焖鸡:3
        main线程：4
        main线程：5
        main线程：6
        main线程：7
        main线程：8
        main线程：9
        新线程：我爱黄焖鸡:4
        main线程：10
        新线程：我爱黄焖鸡:5
        新线程：我爱黄焖鸡:6
        新线程：我爱黄焖鸡:7
        新线程：我爱黄焖鸡:8
        新线程：我爱黄焖鸡:9
        ……
4.  多线程内存图       
```

多线程执行时，在栈内存中，其实每一个执行线程都有一片自己所属的栈内存空间。进行方法的压栈和弹栈。

![1566458772348](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566458772348.png)

> 当执行线程的任务结束了，线程自动在栈内存中释放了。但是当所有的执行线程都结束了，那么进程就结束了。

```markdown
5. 程序启动运行main时候，java虚拟机启动一个进程，主线程main在main()调用时候被创建。随着调用mt的对象的start方法，另外一个新的线程也启动了，这样，整个应用就在多线程下运行。
```

![1566459729835](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566459729835.png)

### 1.2 Thread类

```markdown
上面我们操作多线程都是去继承Thread类，针对这个类在API文档中的描述
	public class Thread extends Object implements Runnable
我们也发现Runnable接口里面有一个核心方法
	void run() 当使用实现接口 Runnable的对象来创建线程时，启动线程将使该对象的run方法在单独执行的线程中被调用
我们自己编写代码，如果去继承Thread类，就需要重写run方法！【自己定义线程的任务与Thread类的不一样的】
	Thread​() 分配一个新的 Thread对象。【创建线程对象，使用系统默认分配的线程名称】  
	Thread​(String name) 分配一个新的 Thread对象。【创建线程对象，指定线程名称】   
针对Thread类它还提供的很多其它的方法：
	String getName​() 返回此线程的名称。 
	void run​() 自定义线程的任务功能方法 【启动线程不是执行这个方法！】
	void start​() 导致此线程开始执行; Java虚拟机调用此线程的run方法。  
	public static void sleep(long millis) :使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行）。
		★ 方法演示：
		public static void main(String[] args) {
            try {
                // 让主线程沉睡3秒
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < 10; i++) {
                System.out.println("么么哒！");
            }
        }
	
	public static Thread currentThread() :返回对当前正在执行的线程对象的引用。
		★方法演示：【获得当前线程的名称】
		System.out.println(Thread.currentThread().getName()+"我爱黄焖鸡:"+ i);

上面已经将Thead类的构造方法进行了一个基本的介绍和使用，在API文档中还提供了2个常用的构造方法
	Thread​(Runnable target) 分配一个新的 Thread对象。  
	Thread​(Runnable target, String name) 分配一个新的 Thread对象。  
```

### 1.3 实现Runnable接口方式

```markdown
在Thread类的构造方法中有：【有参构造，参数是形式参数！调用构造方法，需要传递实际参数，就传递接口的子类对象】
	Thread​(Runnable target) 分配一个新的 Thread对象。  
	Thread​(Runnable target, String name) 分配一个新的 Thread对象。 
然后，Thread类的描述： public class Thread extends Object implements Runnable
也就是说，我们在创建线程对象的时候，可以传递一个Thread类的对象(包括Thread子类对象)

我们现在编写多线程代码，可以不用去继承Thread类，直接去实现Runnable接口即可【要的是run方法】
	
1. 编写一个类去实现Runnable接口
        public class MyThread implements Runnable{
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }

2. 编写测试类：创建自定义线程类的对象作为Thread构造方法的参数
		public static void main(String[] args) {
            // 创建MyThread线程类的对象
            MyThread myThread = new MyThread();

            // Thread​(Runnable target) 分配一个新的 Thread对象。
            //Thread thread = new Thread(myThread);

            // Thread​(Runnable target, String name) 分配一个新的 Thread对象。
            Thread thread = new Thread(myThread,"新线程");

            thread.start();
        }
```

### 1.4 匿名内部类方式

```java
// MyThread类省略！

// 测试类
public static void main(String[] args) {
    // 创建MyThread线程类的对象
    MyThread myThread = new MyThread();

    // Thread​(Runnable target) 分配一个新的 Thread对象。
    //Thread thread = new Thread(myThread);

    // Thread​(Runnable target, String name) 分配一个新的 Thread对象。
    Thread thread = new Thread(myThread,"新线程");

    thread.start();
}
//上面的代码，在调用start方法启动线程的时候，就是为了执行Runnable接口的run方法(重写之后的)，所以，我们可以不用去单独定义一个类去实现Runnabel接口，可以采用匿名内部类的方式
```

```java
// 测试类
public static void main(String[] args) {
    // 创建MyThread线程类的对象
    // MyThread myThread = new MyThread();
    
    // 创建Runnable接口的匿名内部类对象
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    };
    

    // Thread​(Runnable target, String name) 分配一个新的 Thread对象。
    Thread thread = new Thread(runnable,"新线程");

    thread.start();
}
```

上面的代码可以简化为：

```java
// 测试类
public static void main(String[] args) {
    // 创建MyThread线程类的对象
    // MyThread myThread = new MyThread();
    
    // Thread​(Runnable target, String name) 分配一个新的 Thread对象。
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    },"新线程");

    thread.start();
}
```

上面的代码继续简化：

```java
// 测试类
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
```

```markdown
★ 继承Thread类和实现Runnable接口方式的区别  【以后建议通过实现Runnable接口的方式去进行多线程操作】
1. 适合多个相同的程序代码的线程去共享同一个资源。【稍后马上写这个代码】 【成员变量】
2. 可以避免java中的单继承的局限性。
		接口与接口之间可以多继承，类与接口之间可以多实现！
3. 增加程序的健壮性，实现解耦操作，代码可以被多个线程共享，代码和线程独立。
		public static void main(String[] args) {
            new Thread(new Runnable() {
            	// 任务一
                @Override
                public void run() {
                    for (int i = 0; i < 20; i++) {
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            },"新线程1").start();

             new Thread(new Runnable() {
             	// 任务二
                @Override
                public void run() {
                    for (int i = 0; i < 20; i++) {
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            },"新线程2").start();
        }
```

> Runnable对象仅仅作为Thread对象的target，Runnable实现类里包含的run()方法仅作为线程执行体(任务)。而
> 实际的线程对象依然是Thread实例，只是该Thread线程负责执行其target的run()方法。

## 2. 线程安全

```markdown
1. 需求：电影院要卖票，我们模拟电影院的卖票过程。假设要播放的电影是 “葫芦娃大战奥特曼”，本次电影的座位共100个(本场电影只能卖100张票)。

我们来模拟电影院的售票窗口，实现多个窗口同时卖 “葫芦娃大战奥特曼”这场电影票(多个窗口一起卖这100张票)
需要窗口，采用线程对象来模拟；需要票，Runnable接口子类来模拟

2. 分析：
	1. 定义一个变量，指定票数(100)【线程类中】
	2. 多个窗口卖票(作为多个线程来完成) 【多个窗口对应的线程共享这100张票】通过实现Runnable接口方式
	3. 编写类去实现Runnable接口
		在这个类中去重写run方法(卖票的)，多个窗口必须一直卖票(死循环)，票卖没了结束卖票！
	4. 编写测试类
		创建一个多线程类的对象
		创建多个Thread线程对象(模拟多个窗口！)，调用start方法，开始卖票！
	
3. 代码实现	
        public class Ticket implements Runnable {
            // 1. 准备100张票
            int ticket = 100;
            // 执行任务，卖票功能！
            @Override
            public void run() {
                // 2. 卖票动作一直持续
                while (true){
                    // 3.有票才卖
                    if(ticket>0){
                        // 6.获得线程的名称（卖票窗口的名称）
                        String name = Thread.currentThread().getName();
                        // 打印
                        System.out.println(name+"正在卖第："+ticket+"张票");
                        // 5.每卖一张就少一张
                        ticket--;
                    }else{
                        // 4. 结束
                        break;
                    }
                }
            }
        }
	
		public class Main {
            public static void main(String[] args) {
                // 创建线程类Ticket对象
                Ticket ticket = new Ticket();

                // 创建多个线程(多个卖票窗口)
                Thread thread1 = new Thread(ticket,"1号窗口");
                Thread thread2 = new Thread(ticket,"2号窗口");
                Thread thread3 = new Thread(ticket,"3号窗口");

                // 卖票
                thread1.start();
                thread2.start();
                thread3.start();
            }
        }
	
通过上面的案例的代码，我们印证了：
	1.线程去共享同一个资源(3个线程窗口共享100张票)
	2.多个线程共享数据，存在安全问题！【多个窗口卖同一张票！】 
```

### 2.1 线程安全

```markdown
通过上面的卖票案例，我们发现，多个线程共享同一个数据，存在线程安全问题！【主要是对成员变量进行了写(修改)操作！】 
卖票：3个线程窗口同时进行 【抢占式】
	thread1.start(); // 1号窗口
    thread2.start(); // 2号窗口
    thread3.start(); // 3号窗口

		
	// 1. 准备100张票
    int ticket = 100;
	public void run() {
         while (true){
             // 3.有票才卖
             if(ticket>0){
                try {
                    Thread.sleep(500);
                    // 6.获得线程的名称（卖票窗口的名称）
                    String name = Thread.currentThread().getName();
                    // 打印（每卖一张就少一张）
                    System.out.println(name+"正在卖第："+ticket--+"张票");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
             }else{
                // 4. 结束
                break;
             }
         }
 	 }
假设1号窗口，先抢到了执行权，它就开始进行卖票动作，有100张票 ，然后程序执行到获得窗口那一行！沉睡一会(执行权没了)，此时2号窗口它也开始卖票(抢到了执行权)，正常的操作了，获得的是第100张票，票就变成99张！此时1号窗口醒过来了(到了执行权)，开始卖票，还记着之前的100，此时就继续卖第100张！【现在不就出现了2个窗口都卖过第100张票了么】
 
那么如何解决呢？ 【你去蹲坑，没锁门，还没完事，别人进来了，不就出问题了么！】
我们可以第一个人进去之后，把门关上(锁着)，只有他完事了，第二个人才能进去！【同步操作了！】 	
	异步：可以多个同时来！
 	同步：一个一个来！
```

### 2.2 线程同步

```markdown
当我们使用多个线程访问同一资源的时候，且多个线程中对资源有写的操作，就容易出现线程安全问题。Java中提供了同步机制
(synchronized)来解决。

只要同步了，那么多个线程就是一个一个来！【当前只有1个线程在进行(写)操作】

线程同步的三种方式：
	★使用同步代码块
	★使用同步方法
	★使用Lock锁！
```

### 2.3 同步代码块

```markdown
同步代码块： synchronized 关键字可以用于方法中的某个区块中，表示只对这个区块的资源实行互斥访问。
格式：
    synchronized(任意对象锁){

    }
注意：多个线程必须操作的是同一把锁！

之前的代码可以改进为：
	★ 创建一个任意对象锁
	★ 在卖票功能的位置添加同步代码块

	public class Ticket implements Runnable {

        // 1. 准备100张票
        int ticket = 100;

        /*
        * 准备同一把任意对象锁
        * */
        Object obj = new Object();

        // 执行任务，卖票功能！
        @Override
        public void run() {
            // 2. 卖票动作一直持续
            while (true){
                /*
                * 使用同步代码块
                * */
                synchronized (obj) {
                    // 3.有票才卖
                    if (ticket > 0) {

                        /*
                         *   模拟多个窗口出票有延迟时间
                         * */
                        try {
                            Thread.sleep(500);
                            // 6.获得线程的名称（卖票窗口的名称）
                            String name = Thread.currentThread().getName();
                            // 打印（每卖一张就少一张）
                            System.out.println(name + "正在卖第：" + ticket-- + "张票");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        // 4. 结束
                        break;
                    }
                }
            }
        }
    }
```

### 2.4 同步方法

```markdown
就是单独定义了一个执行具体任务功能的一个方法，里面使用synchronized关键字
public synchronized void 方法名称(){
	// 执行具体任务功能的代码
}

可以使用同步方法将卖票功能的代码进行改写：
	public class Ticket implements Runnable {

    // 1. 准备100张票
    int ticket = 100;

    // 执行任务，卖票功能！
    @Override
    public void run() {
        // 2. 卖票动作一直持续
        while (true){
            /*
            * 使用同步方法
            * */
            sellTicket();
        }
    }

    /*
    * 同步方法(隐含锁是this)
    * */
    public synchronized void sellTicket(){
        if(ticket>0) {
            try {
                Thread.sleep(100);
                // 6.获得线程的名称（卖票窗口的名称）
                String name = Thread.currentThread().getName();
                // 打印（每卖一张就少一张）
                System.out.println(name + "正在卖第：" + ticket-- + "张票");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            System.exit(0);
        }
    }
}

不管是同步代码块也好，还是同步方法也罢，它们肯定使用了同步锁！同步代码块我们很明确的知道使用的是哪一把锁！
	非静态的，锁是this
	静态的，锁是字节码 类名.class
		Class mainClass = Main.class; // Class它是一个类 mainClass是一个对象
	
    之前在同步代码块中说锁是一个任意对象！！！！
```

### 2.5 Lock锁

```markdown
Lock实现提供比使用synchronized方法和语句可以获得的更广泛的锁定操作。 它们允许更灵活的结构化，可能具有完全不同的属性，并且可以支持多个关联的Condition对象。

Lock它是一个接口。public interface Lock
我们使用的的时候，可以使用它的一个子类ReentrantLock 


获得锁：
	void lock​() 获得锁。  
释放锁：
	void unlock​() 释放锁。  

使用Lock锁改写卖票案例：
	
    public class Ticket implements Runnable {

        // 1. 准备100张票
        int ticket = 100;

        /*
        *   准备Lock锁对象
        * */
        Lock lock = new ReentrantLock();

        // 执行任务，卖票功能！
        @Override
        public void run() {
            // 2. 卖票动作一直持续
            while (true){
                /*
                *   使用Lock锁
                * */
                // 加锁
                lock.lock();
                if (ticket > 0) {
                        /*
                         *   模拟多个窗口出票有延迟时间
                         * */
                    try {
                        Thread.sleep(100);
                        // 6.获得线程的名称（卖票窗口的名称）
                        String name = Thread.currentThread().getName();
                        // 打印（每卖一张就少一张）
                        System.out.println(name + "正在卖第：" + ticket-- + "张票");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    // 4. 结束
                    System.exit(0);
                }
                // 释放锁
                lock.unlock();
            }
        }

    }
```

## 3. 线程状态

### 3.1 线程状态概述

**当线程被创建并启动以后，它既不是一启动就进入了执行状态，也不是一直处于执行状态。**在线程的生命周期中，有几种状态呢？在API中 java.lang.Thread.State 这个枚举中给出了六种线程状态：

> **生命周期**：在java中，生命周期指的是一个对象从创建到销毁，期间的一系列的调用过程！

这里先列出各个线程状态发生的条件，下面将会对每种状态进行详细解析

| 线程状态                | 导致状态发生条件                                             |
| ----------------------- | ------------------------------------------------------------ |
| NEW(新建)               | 线程刚被创建，但是并未启动。还没调用start方法。              |
| Runnable(可运行)        | 线程可以在java虚拟机中运行的状态，可能正在运行自己代码，也可能没有，这取决于操作系统处理器。 |
| Blocked(锁阻塞)         | 当一个线程试图获取一个对象锁，而该对象锁被其他的线程持有，则该线程进入Blocked状态；当该线程持有锁时，该线程将变成Runnable状态。 |
| Waiting(无限等待)       | 一个线程在等待另一个线程执行一个（唤醒）动作时，该线程进入Waiting状态。进入这个状态后是不能自动唤醒的，必须等待另一个线程调用notify或者notifyAll方法才能够唤醒。 |
| Timed Waiting(计时等待) | 同waiting状态，有几个方法有超时参数，调用他们将进入Timed Waiting状态。这一状态将一直保持到超时期满或者接收到唤醒通知。带有超时参数的常用方法有Thread.sleep 、Object.wait。 |
| Teminated(被终止)       | 因为run方法正常退出而死亡，或者因为没有捕获的异常终止了run方法而死亡。 |

![1566453328403](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566453328403.png)

我们不需要去研究这几种状态的实现原理，我们只需知道在做线程操作中存在这样的状态。那我们怎么去理解这几个状态呢，新建与被终止还是很容易理解的，我们就研究一下线程从Runnable（可运行）状态与非运行状态之间的转换问题。

### 3.2 睡眠sleep方法

我们看到状态中有一个状态叫做计时等待，可以通过Thread类的方法来进行演示.

```markdown
public static void sleep(long time) 让当前线程进入到睡眠状态，到毫秒后自动醒来继续执行
```

```java
public static void main(String[] args) {
    new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                // 让itheima线程沉睡2秒后打印！【超时2秒后，自动继续执行线程！】
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()+":"+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    },"itheima").start();
}
```

### 3.3 等待和唤醒

Object类的方法

```java
public void wait() : 让当前线程进入到等待状态 此方法必须锁对象调用
```

```java
public class MyThread extends Thread {
    @Override
    public void run() {
        synchronized (this){          
            try {
                System.out.println("start....");
                // 一直沉睡(等待！)
                this.wait();
                System.out.println("end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
```

```java
public void notify() : 唤醒当前锁对象上等待状态的线程 此方法必须锁对象调用.
```

```java
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



### 3.4 等待和唤醒案例

![1566453583399](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566453583399.png)

```markdown
定义一个集合，包子铺线程完成生产包子，包子添加到集合中；吃货线程完成购买包子，包子从集合中移除。
1. 当包子没有时（包子状态为false），吃货线程等待.
2. 包子铺线程生产包子（即包子状态为true），并通知吃货线程（解除吃货的等待状态）
```

```java
//生成包子：
public class BaoZiPu extends Thread {

    // 定义一个集合存储包子
    private ArrayList<Integer> list;

    public BaoZiPu(String name,ArrayList<Integer> list) {
        super(name);
        this.list = list;
    }

    // 生产包子
    @Override
    public void run() {
        // 初始化
        int i = 0;
        while(true){
            //list作为锁对象
            synchronized (list){

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(list.size()>0){
                    try {
                        //存元素的线程进入到等待状态[不用生成]
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    //如果线程没进入到等待状态 说明集合中没有元素
                    //向集合中添加元素
                    list.add(i++);
                    System.out.println("生成的第"+ i +"个包子！");
                    //集合中已经有元素了 唤醒获取元素的线程
                    list.notify();
                }
            }
        }
    }
}	
```

```java
// 吃包子
public class ChiHuo extends Thread {

    // 定义一个集合存储包子
    private ArrayList<Integer> list;

    public ChiHuo(String name, ArrayList<Integer> list) {
        super(name);
        this.list = list;
    }

    // 消灭包子
    @Override
    public void run() {
        //为了能看到效果 写个死循环
        while(true){
            //由于使用的同一个集合 list作为锁对象
            synchronized (list){

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(list.size()==0){
                    try {
                        //如果集合中没有元素 获取元素的线程进入到等待状态
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    //如果集合中有元素 则获取元素的线程获取元素(删除)
                    list.remove(0);
                    //打印集合 集合中没有元素了
                    System.out.println(list);
                    //集合中已经没有元素 则唤醒添加元素的线程 向集合中添加元素
                    list.notify();
                }
            }
        }
    }
}
```

```java
// 测试
public class Main {

    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        // 创建生成包子线程类对象
        BaoZiPu bzp = new BaoZiPu("包子铺",list);
        bzp.start();

        // 创建吃货消灭包子线程类对象
        ChiHuo ch = new ChiHuo("吃货",list);
        ch.start();

    }
}
```

> 注意：生成和消费的锁必须是保存包子的集合对象！

