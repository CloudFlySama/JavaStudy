package HomeWork_Practice;

/*
    第三题：
请定义一个方法，实现求一个整数数组中的最大值。调用方法，查看结果。
 */
public class HomeWork03 {
    public static void main(String[] args) {
        int arr[] = {12,15,16,2,8,55,24};
        System.out.println("MAX：" + maxArray(arr));
    }
    public static int maxArray(int arr[]){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
