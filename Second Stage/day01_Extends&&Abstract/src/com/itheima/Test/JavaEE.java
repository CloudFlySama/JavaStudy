package com.itheima.Test;

public class JavaEE extends Developer{

    @Override
    public void work() {
        System.out.println("员工号为"+ super.getId() +"的 "+super.getName()+"员工，正在研发某宝网站");

    }
}
