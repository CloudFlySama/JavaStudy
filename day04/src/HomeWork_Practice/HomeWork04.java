package HomeWork_Practice;
//有一个整数数组。请编写代码，让数组的最后一个元素代表个位，倒数第二个元素代表十位，以此类推。最终得到一个大的整数。比如：
public class HomeWork04 {
    public static void main(String[] args) {
        int arr[] = {1,3,5,7,9};
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = num*10 + arr[i];

        }
        System.out.println(num);

    }
}
