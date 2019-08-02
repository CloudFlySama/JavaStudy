package HomeWork_Practice;
/*定义一个数组其中包含多个数字。用自己的方式最终实现，奇数放在数组的左边，
        偶数放在数组的右边。（可以创建其他数组，不必须在原数组中改变）*/
public class HomeWork07 {
    public static void main(String[] args) {
        int arr[] = {15,8,1,3,66,55,12,48,35,32,90};
        int brr[] = new int[arr.length];
        int left = 0;
        int right = brr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0){
                brr[right] = arr[i];
                right--;
            }else {
                brr[left] = arr[i];
                left++;
            }
        }
        for (int i = 0; i < brr.length; i++) {
            System.out.println(brr[i]);
        }
    }
}
