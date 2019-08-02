## 课堂知识点

### 一、方法

#### 1.方法的概念

- 什么是方法
  - 方法就是具备独立功能的一段代码块！
- 方法的使用步骤
  - 定义方法
  - 调用方法
- 方法的好处是什么
  - 提高代码的复用性
  - 提高代码的维护性

#### 2.方法的定义和调用【无参数无返回值】

- 定义方法

```java
public static void 方法名(){
    方法体;
}
```

- 调用方法

```java
方法名();
```

- 示例代码

```java
public class MethodDemo {
    public static void main(String[] args) {
        System.out.println("开始");

        //调用方法
        isEvenNumber();

        System.out.println("结束");
    }

    //需求：定义一个方法，在方法中定义一个变量，判断该数据是否是偶数
    public static void isEvenNumber() {
        //定义变量
        int number = 10;

        //判断该数据是否是偶数
        if(number%2 == 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
```

- 图解

![01](img\01.png)

- 方法的案例：打印两个数最大值

```java
public class MethodTest {
    public static void main(String[] args) {
        //在main()方法中调用定义好的方法
        getMax();
    }

    //定义一个方法，用于打印两个数字中的较大数，例如getMax()
    public static void getMax() {
        //方法中定义两个变量，用于保存两个数字
        int a = 10;
        int b = 20;

        //使用分支语句分两种情况对两个数字的大小关系进行处理
        if(a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }
}
```

#### 3.方法的定义和调用【有参数无返回值】

- 定义格式

```java
public static void 方法名(形式参数列表) {
    方法体;
}
```

- 调用格式

```java
方法名(实际参数列表);
```

- 示例代码

```java
public class MethodDemo {
    public static void main(String[] args) {
        //常量值的调用
        isEvenNumber(11);

        //变量的调用
        int number = 10;
        isEvenNumber(number);
    }

    //需求：定义一个方法，该方法接收一个参数，判断该数据是否是偶数
    public static void isEvenNumber(int number) {
        if(number%2 == 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

}
```

- 图解

![02](img\02.png)

- 形式参数和实际参数
  - 形参：定义方法时，小括号中写的参数。包括数据类型、参数的个数！用于约束调用方法时，给出的实际参数
  - 实参：调用方法时，小括号中写的实际数值。根据形参的数据类型和个数来给定数据即可
- 方法的案例：方法接收参数打印最大值

```java
public class MethodTest {
    public static void main(String[] args) {
        //在main()方法中调用定义好的方法（使用常量）
        getMax(10,20);
        //调用方法的时候，人家要几个，你就给几个，人家要什么类型的，你就给什么类型的

        //在main()方法中调用定义好的方法（使用变量）
        int a = 10;
        int b = 20;
        getMax(a, b);
    }

    //定义一个方法，用于打印两个数字中的较大数，例如getMax()
    //为方法定义两个参数，用于接收两个数字
    public static void getMax(int a, int b) {
        //使用分支语句分两种情况对两个数字的大小关系进行处理
        if(a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }

}
```

#### 4.方法的定义和调用【有参数有返回值】

- 定义格式

```java
public static 数据类型(返回值) 方法名(形式参数列表) {
    方法体;
    return 结果;
}
```

- 调用格式

  - 赋值调用

  ```java
  数据类型 变量名 = 方法名(实际参数);
  ```

  - 输出调用

  ```java
  System.out.println(方法名(实际参数));
  ```

- 示例代码

```java
public class MethodDemo {
    public static void main(String[] args) {
        //1:方法名(参数);
        //isEvenNumber(10);
        //true

        //2:数据类型 变量名 = 方法名(参数);
        boolean flag = isEvenNumber(10);
        //boolean flag = true;
        System.out.println(flag);

        //3.输出调用
        System.out.println(isEvenNumber(11));
    }

    //需求：定义一个方法，该方法接收一个参数，判断该数据是否是偶数，并返回真假值
    public static boolean isEvenNumber(int number) {
        if(number%2 == 0) {
            return true;
        } else {
            return false;
        }
    }

}
```

- 图解

![03](img\03.png)

- 方法的案例：获取两个整数较大值

```java
public class MethodTest {
    public static void main(String[] args) {
        //在main()方法中调用定义好的方法并使用变量保存
        int result = getMax(10,20);
        System.out.println(result);

        //在main()方法中调用定义好的方法并直接打印结果
        System.out.println(getMax(10,20));
    }

    //定义一个方法，用于获取两个数字中的较大数
    public static int getMax(int a, int b) {
        //使用分支语句分两种情况对两个数字的大小关系进行处理
        //根据题设分别设置两种情况下对应的返回结果
        if(a > b) {
            return a;
        } else {
            return b;
        }
    }
}
```

#### 5.方法的注意事项

- 方法和方法之间是平级关系。不能嵌套定义
- return：将结果返回。结束方法
  - 有返回值的方法：必须写return语句
  - 没有返回值的方法：可以写return语句，结束方法。也可以不写return语句

### 二、方法的通用格式

#### 1.格式

```java
修饰符 返回值类型 方法名(形式参数列表) {
    方法体;
    return 结果;
}
```

- 修饰符：public static
- 返回值类型：方法完成功能后结果的数据类型。没有返回值写void
- 方法名：合法标识符
- 形参列表：方法完成功能所需要的参数
- 方法体：完成功能的代码
- return：返回结果。结束方法
- 结果：方法完成功能后的最终结果

#### 2.方法的练习

```java
public class Demo01 {
    public static void main(String[] args) {
        //调用需求1的方法
        printHelloWorld();

        //调用需求2的方法
        printSum(5);

        //调用需求3的方法
        int result = getSum(10,20);
        System.out.println(result);

        //调用需求4的方法
        double sum = getSum(2.3,3.5,4.2);
        System.out.println(sum);
    }

    //需求1：定义一个方法，在控制台输出5次HelloWorld
    /*
        两个明确：
            明确参数列表：无
            明确返回值类型：void
     */
    public static void printHelloWorld() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("HelloWorld");
        }
    }

    //需求2：定义一个方法，完成1~N之间的数字之和并输出
    /*
        两个明确：
            明确参数列表：int n
            明确返回值类型：void
     */
    public static void printSum(int n) {
        //定义一个求和变量
        int sum = 0;

        //求和
        for(int i = 1; i <= n; i++) {
            sum += i;
        }

        //输出结果
        System.out.println(sum);
    }

    //需求3：定义一个方法：完成两个整数相加的功能，并获取结果
    /*
        两个明确：
            明确参数列表：int num1,int num2
            明确返回值类型：int
     */
    public static int getSum(int num1,int num2) {
        int sum = num1 + num2;
        return sum;
    }

    //需求4：定义一个方法，完成三个小数相加的功能，并获取结果
    /*
        两个明确：
            明确参数列表：double d1,double d2,double d3
            明确返回值类型：double
     */
    public static double getSum(double d1,double d2,double d3) {
        double sum = d1 + d2 + d3;
        return sum;
    }

}
```

### 三、方法的重载

#### 1.什么是方法的重载

- 在同一个类中，出现了多个同名的方法

#### 2.方法重载的规则

- 在同一个类中
- 方法名必须相同
- 参数必须不同
  - 参数类型不同
  - 参数个数不同
  - 参数的顺序不同
- 与返回值类型无关

- 示例代码

```java
public class MethodDemo {
    public static void main(String[] args) {
        //调用方法
        int result = sum(10,20);
        System.out.println(result);

        double result2 = sum(10.0,20.0);
        System.out.println(result2);

        int result3 = sum(10,20,30);
        System.out.println(result3);

    }

    //需求1：求两个int类型数据和的方法
    public static int sum(int a, int b) {
        return a + b;
    }

    //需求2：求两个double类型数据和的方法
    public static double sum(double a, double b) {
        return a + b;
    }

    //需求3：求三个int类型数据和的方法
    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

}
```

#### 3.方法重载的练习

```java
public class MethodTest {
    public static void main(String[] args) {
        //调用方法
        System.out.println(compare(10, 20));
        System.out.println(compare((byte) 10, (byte) 20));
        System.out.println(compare((short) 10, (short) 20));
        System.out.println(compare(10L, 20L));
    }

    //int
    public static boolean compare(int a, int b) {
        System.out.println("int");
        return a == b;
    }

    //byte
    public static boolean compare(byte a, byte b) {
        System.out.println("byte");
        return a == b;
    }

    //short
    public static boolean compare(short a, short b) {
        System.out.println("short");
        return a == b;
    }

    //long
    public static boolean compare(long a, long b) {
        System.out.println("long");
        return a == b;
    }

}
```

#### 4.方法重载的判断题目

- 下列方法，能够和本方法构成重载关系的有哪些？
  - public static int getSum(int n1,int n2){return n1+n2;}
    - public static void getSum(int num1,int num2){int sum = num1+num2;}
    - public static int getSum(int n1,double n2) {return (int)(n1+n2);}
    - public static double getSum(double d1,double d2){return d1+d2;}
    - public static String sum(String s1,String s2){return s1+s2;}
    - public static long getSum(long l1,long l2,long l3){return l1+l2+l3;}

### 四、方法参数传递

#### 1.方法参数传递基本数据类型

- 传递的是什么
  - 传递的是具体的数据值
- 特点
  - 形式参数的改变不会影响实际参数
- 示例代码

```java
public class Test01 {
    public static void main(String[] args) {
        int num = 10;

        System.out.println(num);    // 10

        change(num);

        System.out.println(num);    // 10
    }

    public static void change(int num) {
        num = 20;
    }
}
```

- 图解

![04](img\04.png)

#### 2.方法参数传递引用数据类型

- 传递的是什么
  - 传递的是内存地址值
- 特点
  - 形式参数的改变会影响实际参数
- 示例代码

```java
public class Test02 {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};

        System.out.println(arr[1]);     // 20

        change(arr);

        System.out.println(arr[1]);     // 200
    }

    public static void change(int[] arr) {
        arr[1] = 200;
    }
}
```

- 图解

![05](img\05.png)

- **注意：String虽然是引用数据类型，但是作为方法参数传递的时候，特点是和基本类型是一样的！**

### 五、方法练习

#### 1.定义方法，遍历数组

```java
public class Demo01 {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = {10,20,30,40,50};

        //System.out.println("main:" + arr);

        //调用方法
        printArray(arr);
    }

    //需求：定义一个方法，用于遍历数组
    /*
        两个明确：
            明确参数列表：int[] arr
            明确返回值类型：void
     */
    public static void printArray(int[] arr) {
        //System.out.println("print:" + arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

#### 2.定义方法，获取数组最大值

```java
public class Demo02 {
    public static void main(String[] args) {
        int[] arr = {10,30,40,20,50,45};

        int result = getMax(arr);

        System.out.println("最大值是：" + result);
    }

    /*
        两个明确：
            明确参数列表：int[] arr
            明确返回值类型：int
     */
    public static int getMax(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }
}
```

#### 3.定义方法，获取数组元素平均值

```java
public class Demo03 {
    public static void main(String[] args) {
        double[] arr = {4.5,5.5,6.7,8.8,9.6};

        double avg = getAVG(arr);

        System.out.println("平均值是：" + avg);
    }

    /*
        两个明确：
            明确参数列表：double[] arr
            明确返回值类型：double
     */
    public static double getAVG(double[] arr) {
        //1.定义一个求和变量
        double sum = 0;

        //2.遍历数组，和每一个元素累加
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        //3.计算平均值：总和/数组长度
        double avg = sum / arr.length;

        //4.返回结果
        return avg;
    }
}
```





## 练习题

1. 过一遍笔记
2. 练习无参数无返回值方法的使用
3. 练习有参数无返回值方法的使用
4. 练习有参数有返回值方法的使用
5. 练习方法通用格式中的练习
6. 练习方法重载的使用
7. 练习方法的三个案例



## 面试题

- 什么是方法？方法的好处是什么？
- 方法的定义格式是什么？
- 什么是方法的重载？有哪些规则？
- 基本类型作为方法的参数传递，传递的是什么？有什么特点？
- 引用类型作为方法的参数传递，传递的是什么？有什么特点？