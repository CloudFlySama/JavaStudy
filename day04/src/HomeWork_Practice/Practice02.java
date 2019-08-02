package HomeWork_Practice;
//数组求最大值
public class Practice02 {
    public static void main(String[] args) {
        int arr[] = {88,99,75,36,25,15};
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
                System.out.println(max);
            }
        }
    }
}
