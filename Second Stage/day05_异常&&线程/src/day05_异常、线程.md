# 今日内容介绍

> - 异常(异常介绍、体系结构；处理异常；自定义异常)
> - 多线程

## 1. 异常概述

### 1.1 异常概念

```markdown
异常：不正常、有问题！生病了，去医院，医生会告诉你身体有问题(异常了)

在Java中，编写程序也有可能出现问题！可能是程序编写代码不够严谨(代码的健壮性不够)，也可能是用户操纵不当！

在这里提到的问题，不是程序错误！一旦程序错误，那么肯定编译是不通过的，也就不会生成对应的class文件，更不会运行！

简而言之：就是执行程序之后，出现的结果不是我们预期的！
为了解决这类问题，Java专门提供了一个处理异常的一个类！Throwable类(在java.lang包下！)

异常：在java中异常包含Exception和error，更倾向于Exception 
```

### 1.2 异常体系

![1566283588403](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566283588403.png)

```markdown
1. Throwable类是Java语言中所有错误和异常的父类。
2. Throwable类它有2个直接子类Error和Exception
	Error:错误，一般是系统环境导致，比如内存溢出！一般在程序中是无法处理的，只能提前避免这类问题 【癌症晚期】
	Exception：异常，用户操作不当，编写的程序本身存在Bug,我们是可以处理的！【感冒】
	
说明：在java中一旦某个类有子类，我们学习是需要学习这个类的，但是使用的一般都是它的子类！
	例如：Throwable有子类Exception
		学习父类，父类里面有功能(方法)！使用的时候使用子类(子类拥有父类的功能)。

3. Throwable类相关的方法	
	String getMessage() 返回此throwable的详细消息字符串。:获取发生异常的原因  【适用于自定义异常】
	void printStackTrace() 将此throwable和其追溯打印到标准错误流。打印异常的详细信息。【在控制台打印异常】 
	String toString() 返回此可抛出的简短描述。【一般不用！】  
```

### 1.3 异常分类

```markdown
1. 异常：
	★ Exception:编译异常，checked异常。在编译时期,就会检查,如果没有处理异常,则编译失败。		
	★ RuntimeException：运行异常，runtime异常。在运行时期,检查异常.在编译时期,运行异常不会编译器检测(不报错)【除法运算，除数为0】
		语法通过，但是里面的程序是存在问题的，比如 int i = 1/0;
	
2. 错误：Error 【可能是程序问题，更多的是环境问题，比如内存溢出！】

程序出现异常是很正常的！只要不是错误就行！出现异常，将异常(类)
		public class Demo01 {
            public static void main(String[] args) {
                int i = 1/0;
                System.out.println(i);
            }
        }
```

![1566285379767](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566285379767.png)

```
上面的代码在执行过程中出现问题，我们只需要将控制台的异常类ArithmeticException，在API手册中查询原因即可！
```

![1566285443341](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566285443341.png)

```markdown
目前常见的异常类：
	NullPointerException(运行时异常)：空指针，对象的引用没有没有指向堆内存空间，你依旧使用它进行操作！
		String str = null;
		str.split(":");	
	ArrayIndexOutOfBoundsException(运行时异常)：操作了数组不存在的索引
		int[] array = {10,20,30};
        System.out.println(array[3]);
	ArithmeticException(运行时异常)：除数为0
		int i = 1/0;
        System.out.println(i);
```

![1566285885713](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566285885713.png)

### 1.4 异常产生过程分析

```java
// 测试方法
public static void main(String[] args) {
    int a = 10;
    int b = 0;
    int quotient = quotient(a,b);
    System.out.println(quotient);
}


// 定义一个方法求2个数的商！
public static int quotient(int a,int b){
    int result = a/b;
    return result;
}
```

![1566287239300](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566287239300.png)

> 一旦程序出现异常，那么出现异常代码之后的代码不再执行！！！！
>

## 2. 异常的处理

```markdown
在编写程序时，我们必须要考虑程序出现问题的情况。比如，在定义方法时，方法需要接受参数。那么，当调用方法使用接受到的参数时，首先需要先对参数数据进行合法的判断，数据若不合法，就应该告诉调用者，传递合法的数据进来。这时需要使用抛出异常的方式来告诉调用者。

处理异常的5个关键字：try、catch、finally、throw、throws

★★★★★此类方式处理了异常，并且告诉调用者使用正常的数据！
```

### 2.1 抛出异常throw

```markdown
1. 操作步骤：
	★ 在可能出现异常的位置，创建一个异常匿名对象
	★ 使用throw将这个对象抛出

2. 格式：
	throw new 异常类("给定异常信息的描述");
	例如：ArithmeticException(String s) 构造具有指定详细消息的 ArithmeticException 。  
		thow new ArithmeticException("哥们，除数不能为0");

3. 代码演示：
        // 定义一个方法求2个数的商！
        public static int quotient(int a,int b){
            // 形参先要判断，然后在使用！
            if(b==0){
                // ArithmeticException(String s) 构造具有指定详细消息的 ArithmeticException 。
                throw new ArithmeticException("哥们，你传递的除数不能为0啊！");
            }
            // 使用数据
            int result = a/b;
            return result;
        }
	一旦调用方法，给参数b传递一个为0的数值，那么程序就会出现以下的提示：        
```

![1566288188614](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566288188614.png)

> 使用thow，会将异常抛出给程序调用者！
>

```markdown
我们在工具类Obejcts中也有throw抛出异常的处理方式：

	// 检查指定的对象引用不是 null 。 
	public static <T> T requireNonNull(T obj) {
        if (obj == null)
            throw new NullPointerException();
        return obj;
    }
```

### 2.2 声明异常throws

```markdown
声明异常：将问题标识出来，报告给调用者。如果方法内通过throw抛出了编译时异常，而没有捕获处理（稍后讲解该方式），那么必须通过throws进行声明，让调用者去处理。

关键字throws运用于方法声明之上,用于表示当前方法不处理异常,而是提醒该方法的调用者来处理异常(抛出异常).

格式：
	修饰符 返回值类型 方法名称(参数列表) throws 异常类名1,常类名2,……{}
	
★★★★★此类方式并没有真正的处理异常，只是声明抛出告诉调用者而已！	
```

```java
// 测试方法
public static void main(String[] args) {
    int a = 10;
    int b = 0;
    // 调用方法quotient可能会出现ArithmeticException或者NullPointerException异常！
    int quotient = quotient(a,b);
    System.out.println(quotient);
}

// 定义一个方法求2个数的商！
//【定义方法的时候，告诉调用者，一旦运行这个方法可能出现ArithmeticException异常！】
public static int quotient(int a,int b) throws ArithmeticException,NullPointerException{
    // 使用数据
    int result = a/b;
    return result;
}
```

> 作为一个优秀的程序员，异常我们肯定是要进行处理的！
>
> 即使使用声明异常，将可能出现的异常抛出，到程序的调用处，我们还是得处理啊！

### 2.3 捕获异常try…catch

```markdown
捕获并处理异常，可以使用try...catch语句块
格式：
	try{
		// 代码(可能出现异常！)
		// 其它代码
	}catch(异常类 对象){
		对象.printStackTrace();
	}
	执行流程：一旦代码出现异常，那么就不会执行其它代码，它会直接进入到catch中的语句！如果代码没有出现异常，它就会继续执行其它代码，不会进入catch里面的代码块中去！

代码演示：直接在方法的内部完成
	// 测试方法
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int quotient = quotient(a,b);
        System.out.println(quotient);
    }


    // 定义一个方法求2个数的商！
    public static int quotient(int a,int b){
        int result = -1;
        try{
            // 使用数据
            result = a/b;
        }catch(ArithmeticException e){
            e.printStackTrace();
        }
        return result;
    }

在方法的调用处，借助声明异常throws
	// 测试方法
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int quotient = -1;
        try {
            quotient = quotient(a, b);
        }catch (ArithmeticException e){
            e.printStackTrace();
        }
        System.out.println(quotient);
    }


    // 定义一个方法求2个数的商！
    public static int quotient(int a,int b) throws ArithmeticException{
        int result = a/b;
        return result;
    }

```

### 2.4 finally 代码块

```markdown
finally代码块里面的代码最终一定会执行！！！！【即使出现异常也会执行！】
比如：连接数据库！【建立连接、编写SQL语句、执行SQL语句、释放连接对象】
	try{
		//建立连接
		//编写SQL语句
		//执行SQL语句 【此处可能会出现异常！】
		//释放连接对象
	}catch(Exception e){
		e.printStackTrace();
	}finally{
	
	}
	在上面的例子中，一旦执行SQL语句的代码出现，那么就不会执行释放连接对象的代码，这样一来，最终就会造成其他用户无法连接上数据库了，也就说，释放连接对象的代码必须执行！！！=======>>>> 我们可以将释放连接对象的代码放入finally


代码演示：
	public static int quotient(int a,int b){
        int result = -1;
        try{
            // 使用数据
            result = a/b;
            // 一旦上面的代码出现异常，那么下面的代码不会执行！但是我们希望它必须执行，可以将其放入finally
            //System.out.println("end");
        }catch(ArithmeticException e){
            e.printStackTrace();
        }finally {
            System.out.println("end");
        }
        return result;
    }

★ 我们有些时候，并不是为了处理异常，仅仅只是为了让部分代码必须执行，我们可以这么干！
	try{
    	// 正常代码1
        // 正常代码2
    }finally {
		// 必须执行的代码！
	}
```

### 2.5 异常注意事项

```markdown
1. 运行时异常被抛出可以不处理。既不捕获也不声明抛出。
	例如：ArithmeticException是一个运行时异常
		public class ArithmeticException extends RuntimeException
        public static int quotient(int a,int b){// 如果b为0就会出现运行时异常ArithmeticException
        	int result = a/b;
        	return result;
        }
		
2. 如果父类抛出了多个异常,子类覆盖父类方法时,只能抛出相同的异常或者是他的子集。
	例如：
		class A{
			public void method(){
				 try{
                    // 使用数据
                    result = a/b;
                }catch(ArithmeticException e){
                    e.printStackTrace();
                    throw new RuntimeException("xxx");
                }catch (NullPointerException e1){
                    throw new RuntimeException("yyyy");
                }finally {
                    System.out.println("end");
                }
			}
		}
		class B extends A{
			// 子类覆盖父类方法
			@Override
			public void method(){
				// 在此处抛出异常，只能抛出相同的异常或者是他的子集。
			}
		}

3. 父类方法没有抛出异常，子类覆盖父类该方法时也不可抛出异常。此时子类产生该异常，只能捕获处理，不能声明抛出
		方法来自于父类，你在子类抛出的话，父类方法声明是没有这个的！

4. 当多异常处理时，捕获处理，前边的类不能是后边类的父类
		try{
            // 使用数据
            result = a/b;
        }catch(Exception e){  // 前边的类不能是后边类的父类
            e.printStackTrace();
            throw new RuntimeException("xxx");
        }catch (NullPointerException e1){  // 编译报错！
            throw new RuntimeException("yyyy");
        }

5. 在try/catch后可以追加finally代码块，其中的代码一定会被执行，通常用于资源回收。
6. 多个异常使用捕获又该如何处理呢？
	★ 多个异常分别处理。
		try {
            int a = 10;
        }catch (Exception e){

        }

        try {
            int b = 10;
        }catch (Exception e){

        }
	★ 多个异常一次捕获，多次处理。
	★ 多个异常一次捕获一次处理。
		
	一般我们是使用一次捕获多次处理方式，格式如下：
		try{
          编写可能会出现异常的代码
        }catch(异常类型A  e){  当try中出现A类型异常,就用该catch来捕获.
          处理异常的代码
          //记录日志/打印异常信息/继续抛出异常
        }catch(异常类型B  e){  当try中出现B类型异常,就用该catch来捕获.
          处理异常的代码
          //记录日志/打印异常信息/继续抛出异常
        }
        例如：
        	try{
                // 使用数据
                result = a/b;
                String str = null;
                //System.out.println("end");
            }catch(ArithmeticException e){
                e.printStackTrace();
                throw new RuntimeException("xxx");
            }catch (NullPointerException e1){
                throw new RuntimeException("yyyy");
            }
        
	注意:这种异常处理方式，要求多个catch中的异常不能相同，并且若catch中的多个异常之间有子父类异常的关系，那么子类异常要求在上面的catch处理，父类异常在下面的catch处理。

```

## 3. 自定义异常

### 3.1 自定义异常概述

```markdown
实际开发中，JDK提供的一些异常类并不能够满足我们的需求，比如：学生考试成绩为0异常、用户注册用户名已经被注册过异常。那么此时，我们可以自己定义异常类来进行相关的处理！

1. 自定义异常的格式：自定义异常类只需要去继承Exception即可！
	public class UserNameExistException extends Exception{
		private String msg;
		public UserNameExistException(){
		
		}		
		public UserNameExistException(String msg){
			super(msg);
		}
	}
2. 如何使用：
	使用抛出异常结合捕获异常一起使用！
        public class Register{
            public static void main(String[] args){

                try{
                    String username = "jack";
                    register(username);
                }catch(UserNameExistException e){
                    e.printStackTrace();
                }

            }

            public static void register(String username) throws UserNameExistException{
                RegisterDao registerDao =  new RegisterDao();
                // 从数据库查询(根据username查询)
                User user = registerDao.findUserByUserName(username);
                // 判断
                if(user!=null){
                    // 根据username查到用户信息了，说明数据库已经存在该用户名了
                    throw new UserNameExistException("哥们，该用户名已经被注册过了！");
                }
                ……	
            }
        }
```

### 3.2 自定义异常的练习

```markdown
需求：我们模拟注册操作，如果用户名已存在，则抛出异常并提示：亲，该用户名已经被注册。

    public class Register {

        // 准备容器，模拟数据库中已经存在用户名
        private static String[] names = {"jack","rose","tom"};

        // main方法
        public static void main(String[] args) {
            // 定义一个要注册的用户名(模拟用户在注册表单输入的用户名)
            String username = "jack";
            // 调用方法
            try{
                register(username);
            }catch (UserNameExsitException e){
                e.printStackTrace();
				// 实际开发用下面的，将提示信息最终给显示在页面让用户看到！
                /*String message = e.getMessage();
            	System.out.println(message);*/
            }
        }


        // 注册方法
        public static void register(String name) throws UserNameExsitException {
            // 遍历数组
            for (int i = 0; i < names.length; i++) {
                // 获得遍历的单个
                String n = names[i];
                // 与用户要注册的用户名进行比对
                if(n.equals(name)){
                    // 该用户名应被注册过了
                    throw new UserNameExsitException("亲，"+name+"已经被注册");
                }
            }
        }
    }
```

## 4. 多线程

```
我们在不考虑使用跳转语句(if...else)的情况，我们实现一个功能，里面的代码都是逐行执行的！现在希望在这个前提下，实实现功能(边听音乐边玩游戏！)，我们可以使用多线程技术来实现！
```

### 4.1 并发与并行

```markdown
1. 并行：指两个或多个事件在同一时刻发生（同时执行）。
2. 并发：指两个或多个事件在同一个时间段内发生(交替执行)。  ★★★★★
	时间段：非常短暂(在你听音乐和玩游戏的时候，2个动作是有1个先后顺序，但是这个时间段短到你感觉不到！)
	
对于计算机而言，同时做2件事，进行并发操作，效率会更高！负荷更低！【java更加关注程序并发执行！】	
```

### 4.2 线程与进程

```markdown
1. 进程：可以将进程理解为系统中正在运行的应用程序！一个应用程序可能不止一个进程！
		是指一个内存中运行的应用程序，每个进程都有一个独立的内存空间，一个应用程序可以同时运行多个进程；进程也是程序的一次执行过程，是系统运行程序的基本单位；系统运行一个程序即是一个进程从创建、运行到消亡的过程。
```

![1566296922886](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566296922886.png)

```markdown
2. 线程：★★★★★
		是进程中的一个执行单元，负责当前进程中程序的执行，一个进程中至少有一个线程。一个进程中是可以有多个线程的，这个应用程序也可以称之为多线程程序。
		

3. 进程与线程的区别
	进程：有独立的内存空间，进程中的数据存放空间（堆空间和栈空间）是独立的，至少有一个线程。
	线程：堆空间是共享的，栈空间是独立的，线程消耗的资源比进程小的多。
		
4. 线程调度
	平均轮流分配 
		线程A
		线程B
			A B A B A B A B
	抢占式的 【java中的线程】
    	A B B B B A B B B A B A B
```

### 4.3 创建线程类

```markdown
1. 所在包
	Thread类在java.lang包下！	public class Thread extends Object implements Runnable

2. Thread类的描述
	Thread是程序中执行的线程。 Java虚拟机允许应用程序同时执行多个执行线程。

3. Thread类的构造方法
	Thread​() 分配一个新的 Thread对象。 【创建一个新的线程对象，没有线程名称，系统自动分配默认名字】 
	Thread​(String name) 分配一个新的 Thread对象。  【创建一个新的线程对象，指定一个名字】

4. 其它方法
	String getName​() 返回此线程的名称。  
	void run​() 如果这个线程是使用单独的Runnable运行对象构造的，那么这个Runnable对象的run方法被调用; 否则，此方法不执行任何操作并返回。  
	void start​() 导致此线程开始执行; Java虚拟机调用此线程的run方法。  
	
5. 多线程如何操作
	★ 定义一个类去继承Thread类，重写run方法(要执行的任务！)
	★ 创建线程类的对象，然后调用start方法启动线程！

        public class MyThread extends Thread {

            public MyThread(String name) {
                super(name);
            }

            // 线程要执行的任务！
            @Override
            public void run() {
                // 打印20次，我爱黄焖鸡
                for (int i = 0; i < 20; i++) {
                    // 额外添加了线程的名称和索引值
                    System.out.println(this.getName()+" 我们爱黄焖鸡！ " + (i+1)+"次！");
                }
            }
        }

		// 测试
        public static void main(String[] args) {
            // 创建线程类的对象
            MyThread myThread = new MyThread("新线程");
            // 启动线程
            myThread.start();

            // 主线程
            for (int i = 0; i < 10; i++) {
                System.out.println("main线程执行了！" + i);
            }
        }
```

