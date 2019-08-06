package Test;

import java.util.Random;
import java.util.Scanner;

/*五、综合案例
        1.定义用户名变量：String username = "admin";
        2.定义密码变量：String password = "123";
        3.准备一个包含大写字母、小写字母、数字的数组
        4.随机从数组中获取四个字符作为验证码
        5.通过键盘录入用户名和密码和验证码
        如果全部相同(验证码不区分大小写)，提示：登录成功
        如果不同，提示：登录失败*/
public class Test01 {
    public static void main(String[] args) {
        //1.定义用户名变量：String username = "admin";
        String username = "admin";
        //2.定义密码变量：String password = "123";
        String password = "123";
        //3.准备一个包含大写字母、小写字母、数字的数组
        char arr[] = new char[62];
        int index = 0;
        for (char c = 'A'; c <= 'Z' ; c++) {
            arr[index] = c;
            index++;
        }
        for (char c = 'a'; c <= 'z' ; c++) {
            arr[index] = c;
            index++;
        }
        for (char c = '0'; c <= '9' ; c++) {
            arr[index] = c;
            index++;
        }
        //4.随机从数组中获取四个字符作为验证码
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n<=3 ; n++){
            int a = r.nextInt(arr.length);
            sb.append(arr[a]);
        }
        String s = sb.toString();

        //5.通过键盘录入用户名和密码和验证码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String user = sc.nextLine();
        System.out.println("请输入密码");
        String passwd = sc.nextLine();
        System.out.println("请输入验证码" + s);
        String y = sc.nextLine();
        //判断用户名、密码、验证码是否相同
        if (user.equalsIgnoreCase(username) && passwd.equalsIgnoreCase(password)&& y.equalsIgnoreCase(s)){
            System.out.println("验证成功");
        }else{
            System.out.println("验证失败");
        }

    }
}

