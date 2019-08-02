package HomeWork_Practice;
/*小李用自己的钱买了十只股票，年末他看了各只股票的收益分别是
        10.4%,-3%,-6.2%,1.2%,-6.1%,-19%,-3.8%,0.9%,-4.5%,5.5%。
        请使用数组相关知识编程，帮他统计赚钱的股票和赔钱的股票分别有多少只？*/
public class HomeWork06 {
    public static void main(String[] args) {
        double arr[] = {10.4,-3,-6.2,1.2,-6.1,-19,-3.8,0.9,-4.5,5.5};
        int lost = 0;
        int win = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0){
                win++;
            }else{
                lost++;
            }
        }
        System.out.println("赚钱的有" + win +"个");
        System.out.println("赔钱的有" + lost +"个");
    }
}
