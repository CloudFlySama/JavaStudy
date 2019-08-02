package com.itheima01;

public class Demo07 {
    /* public static void main(String[] args) {
         int[] arr = {10,20,30,40,50};
         //System.out.println("main:" + arr);
         printArray(arr);
     }
     public static void printArray(int[] arr){
        // System.out.println("print:" + arr);
         for (int i = 0; i < arr.length; i++) {
             System.out.println(arr[i]);
         }
     }*/
  /* public static void main(String[] args) {
       int count = 0;
       for(int i = 1;i <= 10;i++) {
           if(i % 5 == 0) {
               break;
           }
           if (i == 3 || i == 7 || i == 9){
               continue;
           }

           count++;
       }
       System.out.println(count);
   }*/
  /* public static void main(String[] args) {
       int sum = 0;
       int i=0;
       while (i<=5){
           if(i % 2 != 0){
               sum += i;
           }
           i++;
       }
       System.out.println("sum = " + sum);
   }*/
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1;i <= 10;i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}