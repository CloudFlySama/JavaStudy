package com.itheima.demo03;

import java.util.LinkedList;

public class Demo {
    //LinkedList集合的常用方法
    /*
    * public void addFirst(E e) :将指定元素插入此列表的开头。
      public void addLast(E e) :将指定元素添加到此列表的结尾。
      public E getFirst() :返回此列表的第一个元素。
      public E getLast() :返回此列表的最后一个元素。
      public E removeFirst() :移除并返回此列表的第一个元素。
      public E removeLast() :移除并返回此列表的最后一个元素。
      public E pop() :从此列表所表示的堆栈处弹出一个元素。
      public void push(E e) :将元素推入此列表所表示的堆栈。
    * public boolean isEmpty() ：如果列表不包含元素，则返回true。
    * */
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("java");
        list.add("javaee");
        list.add("javase");
        list.add("hello");
        System.out.println(list);
        list.addFirst("666666");
        System.out.println(list);
        list.addLast("123456");
        System.out.println(list);
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
        System.out.println(list.getFirst());
    }

}
