package com.itheima.demo03;

import java.util.ArrayList;
import java.util.Collection;

//Collection集合数组转集合
//定义一个方法，要求此方法把int数组转成存有相同元素的集合(集合里面的元素是Integer)，并返回。()
public class Demo {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,6,5,4,8,9,6};
        System.out.println(changeList(arr));
    }
    public static Collection changeList(int[] i){
        Collection<Integer> list = new ArrayList<>();
        for (int i1 = 0; i1 < i.length; i1++) {
            list.add(Integer.valueOf(i[i1]));
        }
        return list;
    }
}
