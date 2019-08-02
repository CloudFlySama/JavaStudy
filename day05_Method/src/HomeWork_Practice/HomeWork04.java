package HomeWork_Practice;

/*
    第四题：
请定义一个方法，实现求一个整数数组中的最小值。调用方法，查看结果。
 */
public class HomeWork04 {
    public static void main(String[] args) {
        int arr[] = {12,15,16,2,8,55,24};
        System.out.println("Min：" + minArray(arr));
    }
    public static int minArray(int arr[]){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
}
