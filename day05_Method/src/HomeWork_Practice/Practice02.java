package HomeWork_Practice;

/*题目2（训练）

        定义一个方法，该方法能够找出三个整数中的最大值并返回。在主方法中调用方法测试执行。*/
public class Practice02 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 30;
        System.out.println("MAX:" + printMax(a,b,c));
    }
    public static int printMax(int a, int b, int c){
        int tempmax = 0;
        if(a > b){
            tempmax = a;
        }else{
            tempmax = b;
        }
        int max = tempmax > c ? tempmax : c;
        return max;
    }
}
