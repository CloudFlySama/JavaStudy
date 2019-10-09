package com.itheima.Homework06;

/*

模拟商品添加到购物车，展示商品信息
* 开发步骤:
1.定义商品类，
(1)属性:商品名称（字符串类型），id（int类型），价格（double类型）
(2)方法：
①属性对应的get/set方法
②提供空参数构造方法和满参数构造方法
③定义show方法，方法没有形参，方法的返回值类型是void,方法内打印商品的名称，id,价格
2.定义购物车GouWuChe类，具有如下成员
(1)成员属性:
①创建ArrayList<Goods>集合
(2)方法
①空参数构造方法和满参数构造方法
②定义添加方法的方法
1)方法的名字叫addGoods
2)方法的形参是Goods类类型
3)方法内调用集合的add方法，将传递过来的商品传递进去
③定义showGoods方法
1)方法没有形参
2)方法的返回值类型是void
3)遍历集合(这个集合在成员属性的位置定义的)
4)获取集合中的每一个商品，调用商品的show方法
④定义removeGoods方法
1)方法的形参是Goods类型
2)方法的返回值类型是void
⑤定义total方法
1)方法没有形参
2)方法的返回值类型是void
3)方法内遍历集合计算商品的总和并打印
3.创建Test测试类，在测试类中创建main方法，在main方法中创建GouWuChe对象，然后创建三个商品对象，信息如下:

调用GouWuChe对象的addGoods方法，分别将三个商品对象添加到GouWuChe对象中，然后分别调用GouWuChe对象的showGoods方法和	total方法，打印一句话”============移除鼠标=================”,然后调用GouWuChe对象的removeGoods方法，将第三个商品删除，再次调用GouWuChe对象的showGoods方法，最后再调用GouWuChe对象的total方法
* */
public class Test {
    public static void main(String[] args) {
        System.out.println("==========添加商品==========");
        GouWuChe g = new GouWuChe();
        Goods goods1 = new Goods(1, "电脑", "g10000", 6999.0);
        Goods goods2 = new Goods(2, "键盘", "g10001", 199.0);
        Goods goods3 = new Goods(3, "鼠标", "g10002", 59.0);
        g.addGoods(goods1);
        g.addGoods(goods2);
        g.addGoods(goods3);
        g.showGoods();
        g.removeGoods();
        g.showGoods();
    }
}
