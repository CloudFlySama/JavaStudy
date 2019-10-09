# 今日内容介绍

> * Object类
> * Date类
> * DateFormat类
> * Calendar类
> * Math类
> * System类
> * 包装类

```markdown
1. 之前：
	自己定义类以及方法：
		// 自定义的类
        public class Student {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            // 显示学生的姓名 [自定义的方法]
            public void show(){
                System.out.println("name："+ name);
            }

            // 自定义一个静态方法
            public static void method(){
                System.out.println("Hello!");
            }
        }
	使用：
		非静态方法：创建类的对象，通过对象去调用方法！
		静态方法：直接通过类名去调用方法！

2. 现在
	当初我们自己能够定义一些类(里面实现一些方法)，别人也能做到的(JDK提供了大量这样的类)！所以，我们现在关注的是
		★ 别人提供类所在的包！【放置同名的类，可以通过包来区分】 稍后只需要导包就能够使用这个类！
        ★ 如果别人提供的类中的方法是静态的，那么直接可以通过类名去调用，否则需要创建对象【构造方法】
		★ 关注别人类中提供的方法(可以通过对应的手册进行学习)
```

> 今天所有类的学习，我们都可以通过API文档来完成！

## 1. Object类

```markdown
1. 所在的包
	Object类它在java.lang包下！我们使用这个类不用导包的！
```

![1566197520691](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566197520691.png)

```markdown
2. Object类的描述(特点)
	Object类是所有类的父类！如果一个类没有明确继承Object类，那么它默认就是继承了Object类
		public class Student /*extends Object*/{
	所有类都拥有了Object类里面的方法！常用的有2个：
		boolean equals(Object obj) 指示一些其他对象是否等于此。  
		String toString() 返回对象的字符串表示形式。  

3. Object类的构造方法
	Object() 构造一个新对象。  
		Object obj = new Object();
```

### 1.1 Object常用方法toString

```markdown
1. 方法的描述
		String toString() 返回对象的字符串表示形式。
		【打印对象的内容是一个字符的地址值，格式为：类型@16进制数字】  (类型：包名.类名 ====>>> 全限定类名)
2. 代码演示：
        public static void main(String[] args) {
            // 通过构造方法创建一个Object类的对象
            Object obj = new Object();
            // 通过对象调用toString方法，获得字符串对象
            String s = obj.toString();
            // 打印对象！
            System.out.println(s); // java.lang.Object@4554617c
        }

3. 重写toString方法
	本身Object类的toString方法是打印一个对象的地址值，但是，我们一般希望但是打印这个对象的数据(成员变量)，索引我们一般会将这个方法进行重写！
	
	自定义类，打印对象的得到的是地址值
		public static void main(String[] args) {
            Student student = new Student();
            System.out.println(student); // com.itheima.demo02.Student@4554617c
        }
	在自定义类中去重写父类Obejct的toString方法
		// 重写父类Object中的toString方法
        public String toString(){
            return "name:"+name+", age:"+age;  
        }
	此时，再打印Student对象，得到的就是这个对象中成员变量的值
		此时
			public static void main(String[] args) {
                Student student = new Student();
                System.out.println(student); // name:null, age:0
            }
	而我们实际开发中，一般不会自动去手动编写重写的toString方法，而是借助工具自动生成(固定格式)
		快捷键：alt+insert 呼出对应常用的方法下拉菜单，根据实际需要去选择
		
		@Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
		测试结果：Student{name='null', age=0}	
```

> 结论：关于Object类的toString方法，以后要想打印对象得到的是数据，那么必须重写toString，直接打印或者调用没有任何效果，打印的都是地址值

### 1.2 Object类的equals

```markdown
1. 方法描述
	boolean equals(Object obj) 比较2个对象是否相等(同)。  
		在没有重写这个方法的时候，它比较的是2个对象的地址值是否相同

2. 代码演示
	Student类中没有重写父类的equals方法，仅仅只是继承过来使用！
		public static void main(String[] args) {
            // 创建2个学生对象
            Student student1 = new Student();
            Student student2 = new Student();
            //boolean equals(Object obj) 比较2个对象是否相等(同)。
            boolean flag = student1.equals(student2);
            System.out.println(flag); // false (没有重写父类的equals方法，比较的是2个对象的地址值)
        }
	我知道，字符串String类中的equals方法它是比较2个对象里面的内容是否相同！

3. 重写Object类的equals方法
	在Student类中重写了父类Object的equals方法，用于比较2个对象里面的数据是否相同
		// 重写来自父类的equals方法
        @Override
        public boolean equals(Object o) {
        	// o：student2 ，this:student1
            if (this == o) {  // false
                return true;
            }
            // getClass()获得对象类型,此时都是Student
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            Student student = (Student) o;
            // Objects工具类
            return this.age == student.age && Objects.equals(this.name, student.name);
        }
	再次测试：
		public static void main(String[] args) {
            // 创建2个学生对象
            Student student1 = new Student();
            Student student2 = new Student();
            //boolean equals(Object obj) 比较2个对象的内容是否相同。
            boolean flag = student1.equals(student2);
            System.out.println(flag); // true (重写了父类的equals方法，比较的是2个对象的内容)
        }
```

> 我们使用String类比较2个字符串的数据是否相同，直接使用equals方法(String类已经重写了Object类的equaslfagnfa )，而我们想要比较我们自定义类的2个对象的数据是否相同，就需要在自定义类中去重写Object类的equals方法！
>

## 2. Date类

```markdown
1. Date类所在的包
	Date类我们需要使用的是java.util包下的 【后面千万不要导错包！】

2. Date类的描述
```

![1566201480533](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566201480533.png)

```markdown
3. Date类的构造方法
	Date()分配一个 Date对象并对其进行初始化，以便它表示分配的时间，以最接近的毫秒为单位。  
		Date date = new Date();
        System.out.println(date); // Mon Aug 19 16:03:55 CST 2019
	Date(long date)分配一个 Date对象，并将其初始化为表示从标准基准时间（称为“时代”）即1970年1月1日00:00:00 GMT起的指定毫秒数。  
		Date date1 = new Date(10000000L);
        System.out.println(date1); // Thu Jan 01 10:46:40 CST 1970
	Date(String s) 已过时。 从JDK 1.1版开始，替换为DateFormat.parse(String s) 。  
		这个方法标记为已过时(处于设计存在问题来考虑，不建议使用)，但是是可以使用的！
		
★★★★★ 无参构造是我们以后开发常用的！
```

### 2.1 Date类常用方法

```markdown
1. 常用方法描述
		void setTime​(long time) 将此 Date对象设置为1970年1月1日00:00:00 GMT后的 time毫秒的时间点。  
		long getTime​() 返回自1970年1月1日以来，由 Date对象表示的00:00:00 GMT的毫秒数。  

2. 代码演示
        public static void main(String[] args) {
            // 创建一个Date类的对象
            Date date = new Date();
            //void setTime(long time) 将此Date对象设置为1970年1月1日00:00:00 GMT后的time毫秒的时间点。
            //date.setTime(1000000L);

            //long getTime​() 返回自1970年1月1日以来，由 Date对象表示的00:00:00 GMT的毫秒数。
            long time = date.getTime();
            //System.out.println(time); // 1566202401499

            // int getYear​() 已过时。
            //从JDK 1.1版开始，由Calendar.get(Calendar.YEAR) - 1900替换。
            int year = date.getYear();
            System.out.println(year+1900); // 2019
        }		

说明：关于Date类，以后开发，基本都是使用无参构造方法，得到一个日期对象(初始化数据了)，然后借助下面这个类的方法来操作！
```

## 3. DateFormat类

```markdown
1. DateFormat类所在的包
	在java.text包下！ 

2. DateFormat类描述
	public abstract class DateFormat extends Format
	通过查看手册，我们发现，这个类是一个抽象类，那么我们使用肯定是它的一个子类！
		public class SimpleDateFormat extends DateFormat
	我们操作【日期格式转换】，都是通过抽象类DateFormat的子类SimpleDateFormat来完成！
	
3. SimpleDateFormat类的构造方法
	SimpleDateFormat(String pattern)  // 创建对象并指定转换日期的格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyy年MM月dd日 HH:mm:ss");
```

![1566203245630](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566203245630.png)

```markdown
4. 其它方法	
	常用的有2个【从父类继承过来的！】
		String format(Date date) 按照指定格式，将一个日期对象转成一个字符串
		Date parse(String source) 将一个字符串转成日期 

5. 代码演示
	★ String format(Date date) 按照指定格式，将一个日期对象转成一个字符串 【★★★★★】
        public static void main(String[] args) {
            // 创建SimpleDateFormat类的对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

            // 创建一个Date对象
            Date date = new Date();
            System.out.println(date); // Mon Aug 19 16:59:22 CST 2019

            // 通过SimpleDateFormat类的对象去调用方法将一个日期转成指定格式的字符串
            String s = sdf.format(date);
            System.out.println(s); // 2019年08月19日 16:59:22
        }
	★ Date parse(String source) 将一个字符串转成日期 
		public static void main(String[] args) throws ParseException {
            // 创建SimpleDateFormat类的对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

            // 定义一个字符串
            String date = "2088年12月09日 15:25:44"; 

            // 通过SimpleDateFormat类的对象去调用方法将字符串转成一个date对象
            Date d = sdf.parse(date); // alt+enter 选第一个，抛异常！
            System.out.println(d); // Thu Dec 09 15:25:44 CST 2088
        }
     如果需要转换成日期对象的字符串的数据与定义的格式不一致就会出现：ParseException   
        public static void main(String[] args) throws ParseException {
            // 创建SimpleDateFormat类的对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

            // 定义一个字符串
            String date = "2088-12-09 15:25:44"; // 与上面定义的格式不一致，出现异常！

            // 通过SimpleDateFormat类的对象去调用方法将字符串转成一个date对象
            Date d = sdf.parse(date); 
            System.out.println(d); // 报错！！出现ParseException
        }

```

## 4. Calendar类

```markdown
1. 所在的包
	java.util.Calendar 
	
2. Calendar类的描述
	 是日历类，在Date后出现，替换掉了许多Date的方法。该类将所有可能用到的时间信息封装为静态成员变量，方便获取。日历类就是方便获取各个时间属性值

3. 构造方法
	public abstract class Calendar===>>>抽象类，不能创建对象！但是它有构造方法，主要是在子类创建对象的时候，借助构造方法为这个抽象类的成员变量赋值！
	里面可以通过类名.成员变量的方式去获得对应的数据！！！！

4. 其它的成员方法
	通过查阅手册，发现这个类的其它成员方法不是静态的，那么不能通过类名调用的，必须通过对象！而这个了是抽象类，不能通过构造方法创建对象，所有肯定有一个静态方法用于生成这个类的对象！
	static Calendar getInstance() 使用默认时区和区域设置获取日历。  
		Calendar c = Calendar.getInstance(); // 获得子类对象！
	★ 常用方法描述
		public int get(int field) ：返回给定日历字段的值。
		public void set(int field, int value) ：将给定的日历字段设置为给定值。
		public abstract void add(int field, int amount) ：根据日历的规则，为给定的日历字段添加或减去
指定的时间量。
		public Date getTime() ：返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象。
	★ 常用的成员常量	
```

![1566205937526](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566205937526.png)

```markdown
5. 代码演示：
		public static void main(String[] args) {
            // 通过Calendar类的静态方法获得一个Calendar对象
            Calendar calendar = Calendar.getInstance();

            //  public int get(int field) ：返回给定日历字段的值。
            int year = calendar.get(Calendar.YEAR); // 参数：类的成员常量
            System.out.println(year); // 2019
        }

		public static void main(String[] args) {
            // 通过Calendar类的静态方法获得一个Calendar对象
            Calendar calendar = Calendar.getInstance();

            //  public int get(int field) ：返回给定日历字段的值。
            int year = calendar.get(Calendar.YEAR); // 参数：类的成员常量
            System.out.println(year); // 2019

            // 在当前时间的基础上前推10年
            calendar.add(Calendar.YEAR,-10);
            System.out.println(calendar.get(Calendar.YEAR)); //2009

            //public Date getTime()：返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象。
            Date date = calendar.getTime();
            System.out.println(date); // Wed Aug 19 17:20:29 CST 2009
        }
```

## 5. Math类

```markdown
1. Math类所在的包
	java.lang.Class Math    public final class Math(不能被继承)

2. Math的描述
	Math包含执行基本数字运算的方法，如基本指数，对数，平方根和三角函数。通过查看API文档，发现它的成员方法都是静态的，所以我们将这类称之为数学工具类！ 【我们使用它的功能不需要创建对象！】
	
3. 成员方法
```

![1566207759505](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566207759505.png)

## 6. System类

```markdown
1. 所在包
	java.lang.System   public final class System

2. 类的描述
	System类包含几个有用的类字段和方法。 它不能被实例化。 
		类字段：字段(成员变量)，类的成员变量不就是静态的！
	System类提供的设施包括标准输入，标准输出和错误输出流; 访问外部定义的属性和环境变量; 一种加载文件和库的方法; 以及用于快速复制阵列的一部分的实用方法。 【系统录入System.in和系统输出Sytem.out,错误输出System.err】

3. 类字段
        static PrintStream err “标准”错误输出流。  
        static InputStream in “标准”输入流。  
        static PrintStream out “标准”输出流。  

4. 其它方法
	public static void exit(int status) 终止当前运行的 Java 虚拟机，非零表示异常终止
			while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("输入您的选择：");
                String line = scanner.nextLine();

                switch (line) {
                    case "1":
                        System.out.println("添加");
                        break;
                    case "2":
                        System.out.println("删除");
                        break;
                    case "3":
                        System.out.println("修改");
                        break;
                    case "4":
                        System.out.println("退出！");
                        System.exit(0);
                }
            }	
	public static long currentTimeMillis() 返回当前时间(以毫秒为单位)
		public static void main(String[] args) {

            long start = System.currentTimeMillis();

            for (int i = 0; i < 10000; i++) {
                System.out.println("我爱黄焖鸡");
            }

            long end = System.currentTimeMillis();

            System.out.println("10000次循环消耗的时间是：" + (end - start) + "毫秒！");
        }
```

## 7. 包装类

```markdown
之前我们学习过ArrayList集合类
	java.util.ArrayList<E>
其中<E>它是一个泛型！它专门对ArrayList集合中存放数据的类型进行限定！
	ArrayList<String> list = new ArrayList<String>(); // 这个集合list中只能存放String类型的数据
泛型的类型指定给定引用类型！！！！万一我们实际需求中就要添加基本类型的数据，那怎么办呢？
	我们可以使用基本数据类型的包装类！

1. 基本类型的包装类
	基本类型	引用类型（包装类）
	byte		Byte
	short		Short
	int 		Integer
	long		Long
	float		Float
	double		Double
	char		Character
	boolean		Boolean
	包装类：就是基本类型转成的引用类型！
	
2. 包装类(Integer类)	
	构造方法：
    	public Integer(int value) 根据 int 值创建 Integer 对象(过时)
        public Integer(String s) 根据 String 值创建 Integer 对象(过时)
    其它方法：   
        public static Integer valueOf(int i) 返回表示指定的 int 值的 Integer 实例
        public static Integer valueOf(String s) 返回保存指定String值的 Integer 对象
        public String toString() 返回一个表示 Integer的值的 String对象。 
        // ★★★★★
		static int parseInt(String s) 将字符串参数解析为带符号的十进制整数。  
	
    上面的构造方法我们使用很少(基本不用！)，但是将一个字符串转成int类型的方法很常用！！！！

3. 自动装箱和拆箱
	装箱：从基本类型转换为对应的包装类对象。
		// 左侧是一个引用类型，右侧是一个基本数据类型的数值
        Integer number = 10;
	
	拆箱：从包装类对象转换为对应的基本类型。
		// 左侧是一个基本类型，右侧是一个引用类型 【拆箱】
        int num = number;
	
	
		Integer i = 4;//自动装箱
		i = i + 5; // 先将i拆箱Wie基本类型，然后与5运算，得到基本类型，然后在装箱
	
4. 字符串转成包装类
	包装类.valueOf(String str);
		Double aDouble = Double.valueOf("10.3");
        Boolean aTrue = Boolean.valueOf("true");
        ……

5. 字符串转换成基本类型
	返回值类型  对象		方法名称  					参数列表
	基本类型 基本类型包装类.parse基本类型单词首字符大写(String str);
		String str = "120";
		int number = Integer.parseInt(str); 
		double aDouble = Double.parseDouble(str);
		
```

























