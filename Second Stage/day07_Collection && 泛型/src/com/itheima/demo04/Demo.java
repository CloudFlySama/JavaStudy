package com.itheima.demo04;

import java.util.ArrayList;
import java.util.Collection;

//定义一个集合，并把集合(集合里面的元素是Integer)转成存有相同元素的数组，
// 并将结果输出在控制台。
// （可以使用Object[]数组类型接收转换的数组）
public class Demo {
    public static void main(String[] args) {
        Collection<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        ArrayList list1 = (ArrayList)list;
        Object[] arr = new Object[list.size()];
        arr = list1.toArray();
//        for (int i = 0; i < list1.size(); i++) {
//            int a = (int)list1.get(i);
//            arr[i] = a;
//        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
