## 课堂知识点

### 一、IDEA介绍

#### 1.IDEA项目组成结构

![01](img\01.png)

#### 2.IDEA常用快捷键

| 快捷键             | 说明                                   |
| ------------------ | -------------------------------------- |
| Ctrl+Y             | 删除光标所在行                         |
| Ctrl+D             | 复制光标所在行的内容，插入光标位置下面 |
| Ctrl+Alt+L         | 格式化代码                             |
| Ctrl+/             | 单行注释                               |
| Ctrl+Shift+/       | 选中代码注释，多行注释，再按取消注释   |
| Alt+Shift+上下箭头 | 移动当前代码行                         |
| psvm               | 快速生成main方法                       |
| sout               | 快速生成输出语句                       |

### 二、数组

#### 1.数组的组成部分和基本格式

- 什么是数组：数组就是一个容器。可以保存多个相同数据类型的数据！
- 数组组成部分：
  - 数据类型
  - 数组名
  - []
- 数组定义格式：
  - 数据类型[] 数组名
  - 数据类型 数组名[]

#### 2.数组的动态初始化

- 初始化格式：数据类型[] 数组名 = new 数据类型[长度];
- 示例代码

```java
//创建一个长度为5的int类型数组
int[] arr1 = new int[5];

//创建一个长度为3的double类型数组
double[] arr2 = new double[3];

//创建一个长度为4的字符串数组
String[] arr3 = new String[4];
```

#### 3.数组元素访问

- 数组名：记录的是数组内存地址值
- 索引：数组中元素的编号。编号从0开始。最大是数组长度-1
- 访问元素格式：数组名[索引];
- 示例代码

```java
public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = new int[3];
        /*
            左边：
                int:说明数组中的元素类型是int类型
                []:说明这是一个数组
                arr:这是数组的名称
            右边：
                new:为数组申请内存空间
                int:说明数组中的元素类型是int类型
                []:说明这是一个数组
                3:数组长度，其实就是数组中的元素个数
         */

        //输出数组名
        System.out.println(arr); // [I@880ec60

        //输出数组中的元素
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
    }
}
```

#### 4.数组元素默认初始化值

- 整数类型：0
- 浮点类型：0.0
- 字符类型：空白字符  \u0000
- 布尔类型：false
- 引用类型：null

#### 5.java中内存分配

- 方法区：将编译后的字节码文件加载到方法区中。
- 栈内存：存储局部变量。执行方法。方法运行结束后，会立即从栈内存消失！
- 堆内存：存储的是new出来的对象。并不会立即消失，在垃圾回收器空闲时，不定期的来回收堆内存空间

#### 6.一个数组的内存图解

![02](img\02.png)

#### 7.多个数组的内存图解

![03](img\03.png)

#### 8.多个数组指向同一个内存空间图解

![04](img\04.png)

#### 9.数组的静态初始化

- 什么是静态初始化
  - 创建数组时，直接给定元素。由系统确认长度
- 静态初始化的格式
  - 标准格式：数据类型[] 数组名 = new 数据类型[]{元素1,元素2,元素3,...};
  - 简化格式：数据类型[] 数组名= {元素1,元素2,元素3,...};
- 图解

![05](img\05.png)

- 示例代码

```java
public class ArrayDemo {
    public static void main(String[] args) {
        //定义数组
        //int[] arr = new int[]{1, 2, 3};
        int[] arr = {1, 2, 3};

        //输出数组名
        System.out.println(arr);

        //输出数组中的元素
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
    }
}
```

#### 10.操作数组的两个问题

- 数组索引越界：ArrayIndexOutOfBoundsException
  - 出现的原因：当我们访问了不存在的索引
  - 解决的方案：修改为正确的索引范围即可
- 空指针异常：NullPointerException
  - 出现的原因：数组对象为null
  - 解决的方案：赋值一个真正的对象地址即可

### 三、数组的案例

#### 1.数组的遍历

```java
public class Test01 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        for (int i = 0; i < arr.length; i++) {  // 数组名.fori   敲回车
            System.out.println(arr[i]);
        }

        /*for(int i = 0; i < arr.length; i++) {
            //System.out.println(arr[i]);
            int num = arr[i];
            System.out.println(num);
        }*/
    }
}
```

#### 2.数组获取最大值

```java
/*
    需求：获取数组最大值

    分析：
        1.定义一个数组
        2.定义一个最大值变量max
        3.遍历数组，拿到每一个元素
        4.用当前元素和max的值进行比较
            如果当前元素比max的值要大：用当前元素重新给max赋值
        5.输出max
 */
public class Test02 {
    public static void main(String[] args) {
        //1.定义一个数组
        int[] arr = {5,15,20,10000,18,35};

        //2.用于保存最大值的变量
        int max = arr[0];

        //3.遍历数组，拿到每一个元素
        for(int i = 1; i < arr.length; i++) {
            //4.用当前元素和max的值进行比较
            if(arr[i] > max) {
                //用当前元素重新给max赋值
                max = arr[i];
            }
        }

        //5.输出max
        System.out.println("最大值是：" + max);
    }
}
```

#### 3.数组元素求和

```java
/*
    需求：对数组元素求和

    分析：
        1.定义一个数组
        2.定义求和变量
        3.遍历数组，拿到每一个元素
        4.用当前元素和求和变量进行累加
        5.输出结果
 */
public class Test03 {
    public static void main(String[] args) {
        //1.定义一个数组
        int[] arr = {1,2,3,4,5};

        //2.定义求和变量
        int sum = 0;

        //3.遍历数组，拿到每一个元素
        for (int i = 0; i < arr.length; i++) {
            //4.用当前元素和求和变量进行累加
            sum += arr[i];
        }

        //5.输出结果
        System.out.println("总和是：" + sum);
    }
}
```

#### 4.数组元素求平均值

```java
public class Test04 {
    public static void main(String[] args) {
        //1.定义一个数组
        int[] arr = {1,2,3,4,5};

        //2.定义求和变量
        int sum = 0;

        //3.遍历数组，拿到每一个元素
        for (int i = 0; i < arr.length; i++) {
            //4.用当前元素和求和变量进行累加
            sum += arr[i];
        }

        //计算平均值
        int avg = sum / arr.length;

        System.out.println("平均值是：" + avg);
    }
}
```

#### 5.键盘录入为数组元素赋值

```java
/*
    需求：
        1.定义一个长度为3的double类型的数组
        2.通过键盘录入数字，为数组元素赋值

    分析：
        1.定义一个长度为3的double类型数组
        2.创建键盘录入对象
        3.遍历数组，通过键盘输入数据，为数组元素赋值
        4.遍历数组，查看元素结果
 */
public class Test05 {
    public static void main(String[] args) {
        //1.定义一个长度为3的double类型数组
        double[] arr = new double[3];

        //2.创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        //3.遍历数组，通过键盘输入数据，为数组元素赋值
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第"+(i+1)+"个小数：");
            //double num = sc.nextDouble();   // double num = 1.6
            //arr[i] = num;
            arr[i] = sc.nextDouble();
            /*
            arr[0] = 3.5;
            arr[1] = 2.3;
            arr[2] = 1.6;
             */
        }

        //4.遍历数组，查看元素结果
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

#### 6.生成随机数为数组元素赋值

```java
public class Test06 {
    public static void main(String[] args) {
        //1.定义一个长度为5的int类型的数组
        int[] arr = new int[5];

        //2.创建Random随机数对象
        Random r = new Random();

        //3.遍历数组，通过生成随机数为数组元素赋值
        for (int i = 0; i < arr.length; i++) {
            /*int num = r.nextInt(100)+1;
            arr[i] = num;*/
            arr[i] = r.nextInt(100)+1;
        }

        //4.遍历数组，查看结果
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
```





## 练习题

1. 过一遍笔记
2. 练习IDEA中的常用快捷键
3. 练习数组的6个案例



## 面试题

- 什么是数组？
- 数组的初始化有几种方式？
- 什么是动态初始化？
- 什么是静态初始化？
- 数组中的索引是从几开始的？
- 数组的长度如何获取？
- 数组的两个小问题是什么？