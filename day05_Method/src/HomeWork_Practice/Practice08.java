package HomeWork_Practice;

import java.util.Random;

/*一个大V直播抽奖，奖品是现金红包，分别有{2,588,888,1000,10000}五个奖金。
        请使用代码模拟抽奖，打印出每个奖项，奖项的出现顺序要随机且不重复。*/

public class Practice08 {
    public static void main(String[] args) {
        //1.定义存放奖金的数组
        int[] arr = {10000,1000,588,888,2};
        //2.定义数组存放已经被取过的奖金
        int[] brr = new int[5];
        //3.定义变量表示brr的索引
        int index = 0;
        //4.创建随机数对象
        Random r = new Random();
        //5.定义循环反复获取随机数,如果index小于arr的长度则继续循环
        while(index < arr.length){
            //5.1每次生成一个随机索引对应一个奖金
            int i = r.nextInt(arr.length);
            //5.2调用方法判断这个奖金是否被获取过
            boolean b = exist(brr, arr[i]);
            //5.3b是false代表这个奖金没有被抽取过
            if(!b) {
                //5.4把获取之后的奖金存放到brr中
                brr[index] = arr[i];
                //5.5index索引向后移动一次
                index++;
                //5.6打印本次被抽出的奖项
                System.out.println( arr[i] + "元的奖金被抽出");
            }
        }
    }
    //6.定义方法：判断brr数组中是否存在num这个数字
    public static boolean exist(int[] brr,int num){
        //6.1对数组进行遍历
        for (int i = 0; i < brr.length; i++) {
            //6.2判断如果找到数字，则返回true
            if(brr[i] == num){
                return true;
            }
        }
        //6.3如果最终没有找到则返回false
        return false;
    }
}