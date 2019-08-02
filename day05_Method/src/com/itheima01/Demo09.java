package com.itheima01;

public class Demo09 {
    public static void main(String[] args) {
        double[] arr = {1.2,1.3,1.4,1.5};
        double avg = getAvg(arr);
        System.out.println(avg);
    }
    public static double getAvg(double[] arr){
        double sum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double avg = sum / arr.length;
        return avg;
    }
}
