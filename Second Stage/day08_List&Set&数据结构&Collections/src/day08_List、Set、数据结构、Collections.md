# 今日内容介绍

> - List接口(特点)
> - 数据结构(栈、队列、数组、链表、红黑树)
> - List接口的子类(ArrayList、LinkedList)
> - Set接口的子类(HashSet、LinkedHashSet)
> - Collections类(常用方法、比较器Comparator)

## 1. List接口

### 1.1 List接口介绍

java.util.List 接口继承自 Collection 接口，是单列集合的一个重要分支，习惯性地会将实现了 List 接口的对象称为**List集合**。在List集合中**允许出现重复的元素**，所有的元素是以一种线性方式进行存储的，在程序中可以通过索引来访问集合中的指定元素。另外，List集合还有一个特点就是元素有序，即元素的存入顺序和取出顺序一致。

**特点：**

```markdown
1. List集合中的元素是可以重复的！
2. List集合中的元素是有序的！
3. List集合中的元素是带有索引值的 【它的子类依旧就被这个特点】
```

### 1.2 List接口中常用方法

List作为Collection集合的子接口，不但继承了Collection接口中的全部方法，而且还增加了一些根据元素索引来操作
集合的特有方法，如下：

```java
public void add(int index, E element) : 将指定的元素，添加到该集合中的指定位置上。
public E get(int index) :返回集合中指定位置的元素。
public E remove(int index) : 移除列表中指定位置的元素, 返回的是被移除的元素。
public E set(int index, E element) :用指定元素替换集合中指定位置的元素,返回值的更新前的元素。
```

**代码演示：**

```java
public static void main(String[] args) {
    // 创建List集合的对象
    List<String> list = new ArrayList<>(); // List接口的子类ArrayList
    // 直接添加元素
    list.add("java");
    list.add("javaee");
    list.add("javase");

    // 使用Iterator迭代器获得list集合中的每个元素
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()){
        System.out.println(iterator.next()); // java javaee javase
    }
    System.out.println("==========");

    // 再次添加
    //public void add(int index, E element) : 将指定的元素，添加到该集合中的指定位置上。
    list.add(2,"java"); // java javaee java javase

    //public E get(int index) :返回集合中指定位置的元素。
    System.out.println(list.get(1));
    System.out.println("==========");

    //public E remove(int index) : 移除列表中指定位置的元素, 返回的是被移除的元素。
    String remove = list.remove(2);
    System.out.println("remove:"+remove); // java
    System.out.println("=============");

    //public E set(int index, E element) :用指定元素替换集合中指定位置的元素,返回值的更新前的元素。
    list.set(1,"jack");

    // 使用增强for循环获得list集合中的所有元素
    for (String s : list) {
        System.out.println(s);
    }

}
```

> Tips:我们之前学习Colletion体系的时候，发现List集合下有很多集合，它们的存储结构不同，这样就导致了这
> 些集合它们有各自的特点，供我们在不同的环境下使用，那么常见的数据结构有哪些呢？

## 2. 数据结构

### 2.1 数据结构介绍

**数据结构** : [数据](https://baike.baidu.com/item/数据/5947370)结构是[计算机](https://baike.baidu.com/item/计算机/140338)存储、组织[数据](https://baike.baidu.com/item/数据)的方式。数据结构是指相互之间存在一种或多种特定关系的[数据元素](https://baike.baidu.com/item/数据元素/715313)的集合。

### 2.2 常见数据结构

数据存储的常用结构有：栈、队列、数组、链表和红黑树。

我们学习数据结构主要学习：**各种数据结构的特点！**

#### 2.2.1 栈

**栈：**stack,又称堆栈，它是运算受限的线性表，其限制是仅允许在栈的一端进行插入和删除操作，不允许在其他任何位置进行添加、查找、删除等操作。

**特点：**

```markdown
1. 先进后出 【弹夹】
2. 操作栈只有一端！(栈顶)
```

![1566717509662](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566717509662.png)

> **压栈：**就是存元素。即，把元素存储到栈的顶端位置，栈中已有元素依次向栈底方向移动一个位置。
> **弹栈：**就是取元素。即，把栈的顶端位置元素取出，栈中已有元素依次向栈顶方向移动一个位置。

#### 2.2.2 队列

**队列：**queue,简称队，它同堆栈一样，也是一种运算受限的线性表，其限制是仅允许在表的一端进行插入，而
在表的另一端进行删除。

**特点：**

```markdown
1. 先进先出 【火车过隧道】
2. 可以操作队列的两端
```

![1566718782090](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566718782090.png)

#### 2.2.3 数组

**数组：**Array,是有序的元素序列，数组是在内存中开辟一段连续的空间，并在此空间存放元素。

**特点：**

```markdown
1. 数组是有索引值的
2. 里面的元素是可以重复的
3. 里面的元素是有序的
4. 查询和修改效率高、插入和删除效率低
一个公寓某一层(数组)，有多个房间(可以存放数据)，这多个房间是连续的。 601 602 603 604
需求：使用数组存放中国所有的省份和城市
	中国有很多省份，一个省份中有很多城市！
```

![1566719340391](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566719340391.png)

#### 2.2.4 链表

**链表：**linked list,由一系列结点node（链表中每一个元素称为结点）组成，结点可以在运行时i动态生成。每个
结点包括两个部分：一个是存储数据元素的数据域，另一个是存储下一个结点地址的指针域。我们常说的链表
结构有**单向链表**与**双向链表**，那么这里给大家介绍的是单向链表。

**特点：**

```markdown
链表理解为：一伙人，手拉手，下一个人拉着上一个人的右手！
1. 删除、插入操作效率高 【断开指向或者断开之后重新建立新的指向】
2. 查询效率比较低的！
```

![1566720269612](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566720269612.png)



#### 2.2.5 红黑树

**二叉树：**binary tree ,是每个结点不超过2的有序树（tree） 。

是一种类似于我们生活中树的结构，只不过每个结点上都最多只能有两个子结点。二叉树是每个节点最多有两个子树的树结构。顶上的叫根结点，两边被称作“左子树”和“右子树”。

![1566710013819](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566710013819.png)

**红黑树：**二叉树中的一种，将节点插入后，该树仍然是一颗二叉树。

![1566710104987](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566710104987.png)

**红黑树的约束:**

```markdown
1. 节点可以是红色的或者黑色的
2. 根节点是黑色的
3. 叶子节点(特指空节点)是黑色的
4. 每个红色节点的子节点都是黑色的
5. 任何一个节点到其每一个叶子节点的所有路径上黑色节点数相同
```

**特点：**

```markdown
速度特别快,趋近平衡树,查找叶子元素最少和最多次数不多于二倍 
【找10需要4次！找15需要3次！(最少是3次，最多的是四次)】
```

![1566722504978](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566722504978.png)

左子树比父节点的数小，右子树比父节点的数大！

```markdown
找到根节点，数值为9，10比9大，所以在右子树。那么此时找到数值13。而10比13小，此时在左子树，找到11；10比11小，找左子树，正好是数值10. 【只需要进行4次操作就能找到数据】
```

## 3. List接口的子类

### 3.1 ArrayList集合

java.util.ArrayList 集合数据存储的结构是**数组结构**。元素增删慢，查找快，由于日常开发中使用最多的功能为
**查询数据、遍历数据**，所以 ArrayList 是最常用的集合之一。
许多程序员开发时非常随意地使用ArrayList完成任何需求，并不严谨，这种用法是不提倡的。

> Tips：ArrayList我们在基础班都学习过。

### 3.2 LinkedList集合

java.util.LinkedList 集合数据存储的结构是**链表结构**。方便元素添加、删除的集合。

**双向链表**

![1566723660098](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566723660098.png)

实际开发中对一个集合元素的添加与删除经常涉及到首尾操作，而LinkedList提供了大量首尾操作的方法。这些方法我们作为了解即可：

```java
public void addFirst(E e) :将指定元素插入此列表的开头。
public void addLast(E e) :将指定元素添加到此列表的结尾。
public E getFirst() :返回此列表的第一个元素。
public E getLast() :返回此列表的最后一个元素。
public E removeFirst() :移除并返回此列表的第一个元素。
public E removeLast() :移除并返回此列表的最后一个元素。
public E pop() :从此列表所表示的堆栈处弹出一个元素。
public void push(E e) :将元素推入此列表所表示的堆栈。
public boolean isEmpty() ：如果列表不包含元素，则返回true。
```

**代码演示：**

```java
public static void main(String[] args) {
    // 创建LinkedList集合对象
    LinkedList<String> list = new LinkedList<>();
    // 随意添加数据
    list.add("java");
    list.add("javase");
    list.add("javaee");
    list.add("itcast");

    //public void addFirst(E e) :将指定元素插入此列表的开头。
    //list.addFirst("hello");

    //public void addLast(E e) :将指定元素添加到此列表的结尾。
    //list.addLast("hello");

    //public E getFirst() :返回此列表的第一个元素。
    //System.out.println(list.get(0));
    //System.out.println(list.getFirst());

    //public E getLast() :返回此列表的最后一个元素。
    //System.out.println(list.get(list.size()-1));
    //System.out.println(list.getLast());

    //public E removeFirst() :移除并返回此列表的第一个元素。
    //System.out.println(list.remove(0));
    //System.out.println(list.removeFirst());

    //public E removeLast() :移除并返回此列表的最后一个元素。
    //System.out.println(list.removeLast());

    //public E pop() :从此列表所表示的堆栈处弹出一个元素。【删除第一个元素】
    //System.out.println(list.pop());
    //System.out.println("=========");

    //public void push(E e) :将元素推入此列表所表示的堆栈。[链表头部，左侧]
    //list.push("jack");

    //public boolean isEmpty() ：如果列表不包含元素，则返回true。
    System.out.println(list.isEmpty()); // false

    // 遍历
    for (String s : list) {
        System.out.println(s);
    }
}
```

## 4. Set接口

java.util.Set 接口和 java.util.List 接口一样，同样继承自 Collection 接口，它与 Collection 接口中的方法基本一致，并没有对 Collection 接口进行功能上的扩充，只是比 Collection 接口更加严格了。与 List 接口不同的是， Set 接口都会以某种规则保证存入的**元素不出现重复**。

Set 集合有多个子类，这里我们介绍其中的 java.util.HashSet 、 java.util.LinkedHashSet 这两个集合。

> Tips:Set集合取出元素的方式可以采用：迭代器、增强for。

### 4.1 HashSet集合介绍

java.util.HashSet 是 Set 接口的一个实现类，它所存储的元素是**不可重复的**，并且元素都是**无序的**(即存取顺序不能保证不一致)。 java.util.HashSet 底层的实现其实是一个 java.util.HashMap 支持，由于我们暂时还未学习，先做了解。【HashMap明天学习】

HashSet 是根据对象的哈希值来确定元素在集合中的存储位置，因此具有良好的存储和查找性能。保证元素唯一性
的方式依赖于： hashCode 与 equals 方法 【原理稍后学习！】

**代码演示：**

```java
public static void main(String[] args) {
    // 创建HashSet集合对象
    HashSet<String> hashSet = new HashSet<>();
    // 添加元素
    hashSet.add("java");
    hashSet.add("javase");
    hashSet.add("javase"); // 添加不进去！【元素不允许重复！】
    hashSet.add("javaee");
    hashSet.add("javame");
    hashSet.add("javame"); // 添加不进去！【元素不允许重复！】

    // 遍历
    for (String s : hashSet) {
        System.out.println(s); // [可能是：java javame javase javaee]
    }
}
```

### 4.2 HashSet集合存储数据的结构(哈希表)

**哈希表：**在JDK1.8之前，哈希表底层采用**数组+链表**实现，即使用数组处理冲突，同一hash值的链表都存储在一个数组里。但是当位于一个数组中的元素较多，即hash值相等的元素较多时，通过key值依次查找的效率较低。而在JDK1.8中，哈希表存储采用**数组+链表+红黑树**实现，当链表长度超过阈值（8）时，将链表转换为红黑树，这样大大减少了查找时间。

**哈希表**是由**数组+链表+红黑树**（JDK1.8增加了红黑树部分）实现的，如下图所示。

![1566711192416](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566711192416.png)

**存储流程图来说明：**

![1566711272039](C:/Users/Never Say Never/AppData/Roaming/Typora/typora-user-images/1566711272039.png)

JDK1.8引入**红黑树**大程度优化了HashMap的性能，那么对于我们来讲保证HashSet集合元素的唯一，其实就是根据对象的hashCode和equals方法来决定的。如果我们往集合中存放自定义的对象，那么保证其唯一，就必须复写hashCode和equals方法建立属于当前对象的比较方式。

### 4.3 HashSet存储自定义类型元素

给HashSet中存放自定义类型元素时，需要重写对象中的hashCode和equals方法，建立自己的比较方式，才能保证
HashSet集合中的对象唯一。

```java
public class Student {

    private String name;
    private int age;
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 省略getter and setter 和无参构造

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

```java
public static void main(String[] args) {
    // 创建HashSet集合对象
    HashSet<Student> students = new HashSet<>();
    // 添加数据
    students.add(new Student("jack",28));
    students.add(new Student("tom",48));
    students.add(new Student("rose",18));
    students.add(new Student("lucy",22));
    students.add(new Student("lucy",22));

    for (Student student : students) {
        System.out.println(student);
    }
}
// 测试结果：
Student{name='tom', age=48}
Student{name='lucy', age=22}
Student{name='jack', age=28}
Student{name='rose', age=18}
Student{name='lucy', age=22}
// 结果lucy俩都进去了！
```

重写hashCode和equals方法，建立自己的比较方式，才能保证HashSet集合中的对象唯一。

```java
// alt+insert 选择 equals和hashCode方法的选项即可！ 【在Student类中】
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return age == student.age &&
        Objects.equals(name, student.name);
}

@Override
public int hashCode() {
    return Objects.hash(name, age);
}
```

### 4.4 LinkedHashSet

我们知道HashSet保证元素唯一，可是元素存放进去是没有顺序的，那么我们要保证有序，怎么办呢？在HashSet下面有一个子类 java.util.LinkedHashSet ，它是链表和哈希表组合的一个数据存储结构。

**代码演示：**

```java
public static void main(String[] args) {
    // 创建LinkedHash集合对象
    LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
    // 添加数据
    linkedHashSet.add("java");
    linkedHashSet.add("javase");
    linkedHashSet.add("javase"); // 进不去
    linkedHashSet.add("javame");
    linkedHashSet.add("javaee");
    linkedHashSet.add("javaee"); // 添加不进去！

    // 遍历
    for (String s : linkedHashSet) {
        System.out.println(s); // java javase javame javaee
    }
}
```

## 5.Collections类

### 5.1 Collections类常用功能

java.utils.Collections 是集合工具类(里面的方法都是静态的)，用来对集合进行操作。常用方法如下：

```java
public static void shuffle(List<?> list) :打乱集合顺序。
public static <T> void sort(List<T> list) :将集合中元素按照默认规则排序。【自然排序】
public static <T> void sort(List<T> list，Comparator<? super T> ) :将集合中元素按照指定规则排序
```

**代码演示：**

```java
public static void main(String[] args) {
    // 准备一个集合对象
    ArrayList<Integer> list = new ArrayList<>();
    // 添加数据
    list.add(100);
    list.add(400);
    list.add(200);
    list.add(500);
    // 遍历
    /*for (Integer integer : list) {
            System.out.println(integer); // 100 400 200 500
        }*/

    // 打乱集合中元素的顺序
    /*Collections.shuffle(list);

        for (Integer integer : list) {
            System.out.println(integer); // 不再是之前存数据的顺序了！
        }*/

    // 使用sort方法进行排序
    Collections.sort(list);
    for (Integer integer : list) {
        System.out.println(integer); // 100 200 400 500
    }

}
```

### 5.2 Comparator比较器

它是一个接口，主要用于自定义排序规则！【普通的使用自然顺序，自定义一般使用指定规则排序】

```java
public class Student {

    private String name;

    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
	
	// 省略getter setter toString 无参构造
}
```

```java
public class Demo02 {

    public static void main(String[] args) {
        // 创建一个集合
        ArrayList<Student> students = new ArrayList<>();
        // 添加数据
        students.add(new Student("jack",28));
        students.add(new Student("rose",18));
        students.add(new Student("tom",48));
        students.add(new Student("lucy",24));

        // 排序
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 按照年龄升序
                return o1.getAge()-o2.getAge();
            }
        });

        // 遍历
        for (Student student : students) {
            System.out.println(student);
        }

    }
}
```

