## 课堂知识点

### 一、API

#### 1.API帮助文档的使用

- 打开帮助文档->点击索引->输入查询的类名->敲回车

#### 2.Scanner接收数据的注意事项

- nextLine()和其他数据类型的方法一起使用时，nextLine()会接收不到数据
  - 第一种：如果输入的字符串中没有空格，使用next()
  - 第二种：重新创建一个Scanner对象，用新对象专门接收nextLine()
- 示例代码

```java
public class Demo01 {
    public static void main(String[] args) {
        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个整数：");
        int num1 = sc.nextInt();
        System.out.println("num1:" + num1);

        System.out.println("请输入一个字符串：");
        //String str = sc.nextLine();
        //String str = sc.next(); // 第一种解决方式：确定输入的字符串中没有空格

        //第二种：再创建一个Scanner对象
        Scanner sc2 = new Scanner(System.in);
        String str = sc2.nextLine();
        System.out.println("str:" + str);
    }

    public static void demo02() {
        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        //next()    只能接收空格之前的那些字符串
        /*System.out.println("请输入一个字符串：");
        String s1 = sc.next();
        System.out.println("s1：" + s1);*/

        //nextLine()   可以接收一整行字符串
        System.out.println("请输入一个字符串：");
        String s2 = sc.nextLine();
        System.out.println("s2：" + s2);
    }

    //推荐使用的几个方法
    public static void method01() {
        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        //接收整数
        System.out.println("请输入一个整数：");
        int num1 = sc.nextInt();
        System.out.println("num1:" + num1);

        System.out.println("请输入一个小数：");
        double num2 = sc.nextDouble();
        System.out.println("num2:" + num2);

        System.out.println("请输入一个字符串：");
        String str = sc.next();
        System.out.println("str:" + str);
    }
}
```

### 二、String类

#### 1.String类的介绍

- String类是字符串的对象
- 字符串内容不可改变
- 字符串可以被共享使用

#### 2.String类构造方法

- 方法分类

| 方法名             | 说明                               |
| ------------------ | ---------------------------------- |
| String()           | 创建一个空的String对象             |
| String(String str) | 根据指定字符串来创建String对象     |
| String(char[] arr) | 根据指定的字符数组来创建String对象 |
| String(byte[] arr) | 根据指定的字节数组来创建String对象 |
| String s = "abc";  | 直接赋值形式来创建String对象       |

- 示例代码

```java
public class StringDemo01 {
    public static void main(String[] args) {
        //public String()：创建一个空白字符串对象，不含有任何内容
        String s1 = new String();
        System.out.println("s1:" + s1);

        //public String(char[] chs)：根据字符数组的内容，来创建字符串对象
        char[] chs = {'a', 'b', 'c'};
        String s2 = new String(chs);
        System.out.println("s2:" + s2);

        //public String(byte[] bys)：根据字节数组的内容，来创建字符串对象
        byte[] bys = {97, 98, 99};
        String s3 = new String(bys);
        System.out.println("s3:" + s3);

        //String s = “abc”;	直接赋值的方式创建字符串对象，内容就是abc
        String s4 = "abc";
        System.out.println("s4:" + s4);

        //String(String str)
        String s5 = new String("hello");
        System.out.println("s5:" + s5);
    }
}
```

#### 3.String类的特点

- ==号  比较运算符
  - 如果比较的是基本数据类型，比较的是数据值
  - 如果比较的是引用数据类型，比较的是地址值
- 字符串对象的区别
  - 如果是new对象的方式，记录的是堆内存的地址值
  - 如果是直接赋值的方式，记录的是常量池中的地址值
- 图解

![01](img\01.png)

#### 4.String类成员方法-equals()

- boolean equals(String str)             比较字符串的内容是否相同
- 示例代码

```java
public class StringDemo02 {
    public static void main(String[] args) {
        //构造方法的方式得到对象
        char[] chs = {'a', 'b', 'c'};
        String s1 = new String(chs);
        String s2 = new String(chs);

        //直接赋值的方式得到对象
        String s3 = "abc";
        String s4 = "abc";

        //比较字符串对象地址是否相同
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
        System.out.println("--------");

        //比较字符串内容是否相同
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s3.equals(s4));
    }
}
```

#### 5.String类案例-用户登录

```java
public class StringTest01 {
    public static void main(String[] args) {
        //已知用户名和密码，定义两个字符串表示即可
        String username = "itheima";
        String password = "czbk";

        //键盘录入要登录的用户名和密码，用 Scanner 实现
        Scanner sc = new Scanner(System.in);

        //用循环实现多次机会，这里的次数明确，采用for循环实现，并在登录成功的时候，使用break结束循环
        for(int i=0; i<3; i++) {
            System.out.println("请输入用户名：");
            String name = sc.nextLine();

            System.out.println("请输入密码：");
            String pwd = sc.nextLine();

            //拿键盘录入的用户名、密码和已知的用户名、密码进行比较，给出相应的提示。字符串的内容比较，用equals() 方法实现
            if (name.equals(username) && pwd.equals(password)) {
                System.out.println("登录成功");
                break;
            } else {
                if(2-i == 0) {
                    System.out.println("你的账户被锁定，请与管理员联系");
                } else {
                    //2,1,0
                    //i,0,1,2
                    System.out.println("登录失败，你还有" + (2 - i) + "次机会");
                }
            }
        }
    }
}
```

#### 6.String类案例-遍历字符串

- int length()                            获取字符串的长度
- char charAt(int index)         根据指定索引来获取对应的字符
- 示例代码

```java
public class Demo03 {
    public static void main(String[] args) {
        String str = "HelloWorld";

        // int length()    获取字符串的长度
        int length = str.length();
        System.out.println(length); // 10

        // char charAt(int index)    获取指定索引上的字符
        char ch = str.charAt(5);
        System.out.println(ch); // W

        System.out.println("------------");

        //遍历字符串的通用格式
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.println(c);
        }
    }
}
```

#### 7.String类案例-统计字符次数

```java
public class StringTest03 {
    public static void main(String[] args) {
        //键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();

        //要统计三种类型的字符个数，需定义三个统计变量，初始值都为0
        int bigCount = 0;
        int smallCount = 0;
        int numberCount = 0;
        int otherCount = 0;

        //遍历字符串，得到每一个字符
        for(int i=0; i<line.length(); i++) {
            char ch = line.charAt(i);

            //判断该字符属于哪种类型，然后对应类型的统计变量+1
            if(ch>='A' && ch<='Z') {
                bigCount++;
            } else if(ch>='a' && ch<='z') {
                smallCount++;
            } else if(ch>='0' && ch<='9') {
                numberCount++;
            } else {
                otherCount++;
            }
        }

        //输出三种类型的字符个数
        System.out.println("大写字母：" + bigCount + "个");
        System.out.println("小写字母：" + smallCount + "个");
        System.out.println("数字：" + numberCount + "个");
        System.out.println("其他字符有：" + otherCount + "个");

    }
}
```

#### 8.String类案例-字符串拼接

```java
public class StringTest04 {
    public static void main(String[] args) {
        //定义一个 int 类型的数组，用静态初始化完成数组元素的初始化
        int[] arr = {1, 2, 3};

        //调用方法，用一个变量接收结果
        String s = arrayToString(arr);

        //输出结果
        System.out.println("s:" + s);
    }

    //定义一个方法，用于把 int 数组中的数据按照指定格式拼接成一个字符串返回
    public static String arrayToString(int[] arr) {
        //在方法中遍历数组，按照要求进行拼接
        String s = "[";

        for(int i=0; i<arr.length; i++) {
            if(i==arr.length-1) {
                s += arr[i];
            } else {
                s += arr[i];
                s += ", ";
            }
        }

        s += "]";

        return s;
    }
}
```

#### 9.String类案例-字符串反转

```java
public class StringTest05 {
    public static void main(String[] args) {
        //键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();

        //调用方法，用一个变量接收结果
        String s = reverse(line);

        //输出结果
        System.out.println("s:" + s);
    }

    //定义一个方法，实现字符串反转
    /*
        两个明确：
            返回值类型：String
            参数：String s
     */
    public static String reverse(String s) {
        //在方法中把字符串倒着遍历，然后把每一个得到的字符拼接成一个字符串并返回
        String ss = "";

        for(int i=s.length()-1; i>=0; i--) {
            ss += s.charAt(i);
        }

        return ss;
    }
}
```

### 三、StringBuilder类

#### 1.StringBuilder类概述

- 因为String类在做字符串拼接操作的时候，不方便。会不断的产生内存垃圾。而且效率较低
- StringBuilder类是一个可变的字符序列。可以在原有的内容基础之上，进行相关操作
- 将String字符串转成一个StringBuilder类对象。例如：内容拼接、内容的反转。将StingBuilder转为String字符串

#### 2.StringBuilder类构造方法

- 方法分类

| 方法名称                  | 说明                                   |
| ------------------------- | -------------------------------------- |
| StringBuilder()           | 创建一个内容为空的字符串缓冲区对象     |
| StringBuilder(String str) | 根据指定的字符串来创建字符串缓冲区对象 |

- 示例代码

```java
public class StringBuilderDemo01 {
    public static void main(String[] args) {
        //public StringBuilder()：创建一个空白可变字符串对象，不含有任何内容
        StringBuilder sb = new StringBuilder();
        System.out.println("sb:" + sb);
        System.out.println("sb.length():" + sb.length());

        //public StringBuilder(String str)：根据字符串的内容，来创建可变字符串对象
        StringBuilder sb2 = new StringBuilder("hello");
        System.out.println("sb2:" + sb2);
        System.out.println("sb2.length():" + sb2.length());
    }
}
```

#### 3.StringBuilder类成员方法

- 方法分类

| 方法名                            | 说明                         |
| --------------------------------- | ---------------------------- |
| StringBuilder append(Object obj); | 向缓冲区追加内容             |
| StringBuilder reverse();          | 将缓冲区内容反转             |
| int length();                     | 获取缓冲区长度               |
| String toString();                | 将缓冲区转为String字符串对象 |

- 示例代码

```java
public class StringBuilderDemo01 {
    public static void main(String[] args) {
        //创建对象
        StringBuilder sb = new StringBuilder();

        //public StringBuilder append(任意类型)：添加数据，并返回对象本身
        //链式编程
        sb.append("hello").append("world").append("java").append(100);

        System.out.println("sb:" + sb);

        //public StringBuilder reverse()：返回相反的字符序列
        sb.reverse();
        System.out.println("sb:" + sb);
    }
}
```

#### 4.StringBuilder和String相互转换

```java
public class Demo04 {
    public static void main(String[] args) {
        //定义一个字符串对象
        String str = "HelloWorld";

        //需求：
        /*
            String -> StringBuilder
            方式一：直接用StringBuilder的有参构造方法创建对象，直接传递字符串
            方式二：调用append方法来添加
         */
        //StringBuilder sb = new StringBuilder(str);  // 创建对象时，直接在构造方法中，将字符串传递
        StringBuilder sb = new StringBuilder();       // 空参构造创建对象，调用append方法添加数据
        sb.append(str);

        // 在字符串的基础之上，拼接Java、Heima、100、8.8
        sb.append("Java").append("Heima").append(100).append(8.8);

        // 将拼接后的字符串反转
        sb.reverse();

        // 输出反转后的字符串结果
        /*
            StringBuilder -> String
            方式一：调用toString方法
         */
        String result = sb.toString();
        System.out.println(result);
    }
}
```

#### 5.StringBuilder类案例-字符串拼接

```java
public class StringBuilderTest01 {
    public static void main(String[] args) {
        //定义一个 int 类型的数组，用静态初始化完成数组元素的初始化
        int[] arr = {1, 2, 3};

        //调用方法，用一个变量接收结果
        String s = arrayToString(arr);

        //输出结果
        System.out.println("s:" + s);

    }

    //定义一个方法，用于把 int 数组中的数据按照指定格式拼接成一个字符串返回
    /*
        两个明确：
            返回值类型：String
            参数：int[] arr
     */
    public static String arrayToString(int[] arr) {
        //在方法中用 StringBuilder 按照要求进行拼接，并把结果转成 String 返回
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for(int i=0; i<arr.length; i++) {
            if(i == arr.length-1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(", ");
            }
        }

        sb.append("]");

        String s = sb.toString();

        return s;
    }
}
```

#### 6.StringBuilder类案例-字符串反转

```java
public class StringBuilderTest02 {
    public static void main(String[] args) {
        //键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();

        //调用方法，用一个变量接收结果
        String s = myReverse(line);

        //输出结果
        System.out.println("s:" + s);
    }

    //定义一个方法，实现字符串反转。返回值类型 String，参数 String s
    /*
        两个明确：
            返回值类型：String
            参数：String s
     */
    public static String myReverse(String s) {
        //在方法中用StringBuilder实现字符串的反转，并把结果转成String返回
        //String --- StringBuilder --- reverse() --- String
//        StringBuilder sb = new StringBuilder(s);
//        sb.reverse();
//        String ss = sb.toString();
//        return ss;

       return new StringBuilder(s).reverse().toString();
    }
}
```

#### 7.StringBuilder类案例-判断是否是对称字符串

```java
public class Test01 {
    public static void main(String[] args) {
        //1.定义数组
        String[] arr = {"abc","aba","强强打强强","我爱黑马","上海自来水来自海上"};

        //2.遍历数组，拿到每一个字符串
        for (int i = 0; i < arr.length; i++) {
            String s1 = arr[i];
            //3.将字符串反转 借助StringBuilder类中的reverse方法
            StringBuilder sb = new StringBuilder(s1);
            sb.reverse();
            //4.用反转后的字符串和原始字符串比较。 equals
            if(s1.equals(sb.toString())) {
                System.out.println(s1 + "是对称的");
            }else {
                System.out.println(s1 + "不是对称的");
            }
        }
    }
}
```





## 练习题

1. 过一遍笔记
2. 练习String类的构造方法和成员方法的使用
3. 练习String类的案例
4. 练习StringBuilder类的构造方法和成员方法的使用
5. 练习StringBuilder类的案例



## 面试题

- String类的特点有哪些？
- String类的常用构造方法有哪些？
- String类的成员方法有哪些？
- StringBuilder类的特点有哪些？
- StringBuilder类的常用构造方法有哪些？
- StringBuilder类的成员方法有哪些？
- ==号的作用