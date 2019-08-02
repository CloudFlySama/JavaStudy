package HomeWork_Practice;

/*题目1（训练）
        定义一个方法，该方法能够找出两个小数中的较小值并返回。在主方法中调用方法进行测试。*/
public class Practice01 {
    public static void main(String[] args) {
        double num1 = 0.2;
        double num2 = 2.2;
        double min = printMin(num1,num2);
        System.out.println(min);
    }
    public static double printMin(double num1, double num2){
        if(num1 < num2){
            return num1;
        }else
            return num2;
    }
}
