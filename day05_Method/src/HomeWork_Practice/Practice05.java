package HomeWork_Practice;

import java.util.Scanner;

/*题目5（训练）

        在主方法中通过键盘录入三个整数。定义一个方法，
        方法接收三个整数变量，在方法中从大到小依次打印三个变量：*/
public class Practice05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字");
        int a = sc.nextInt();
        System.out.println("请输入第二个数字");
        int b = sc.nextInt();
        System.out.println("请输入第三个数字");
        int c = sc.nextInt();
        int arr[] = printArray(a,b,c);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static int[] printArray(int a,int b,int c){
        int arr[] = new int[3];
        int tempmax = 0;
        int min = 0;
        if(a > b){
            tempmax = a;
            min = b;
        }else{
            tempmax = b;
            min = a;
        }
        // 如果需要返回数组
        int max = tempmax > c ? tempmax : c;
        arr[0] = max;
        arr[1] = tempmax;
        arr[2] = min;
       /* for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/
        return arr;



    }

}
