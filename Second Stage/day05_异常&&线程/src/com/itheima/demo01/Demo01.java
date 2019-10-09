package com.itheima.demo01;

public class Demo01 {
    private static String[] name = {"周满仓","孙志良","赵云帆"};

    public static void main(String[] args) {
        String s = "周满仓";
        String s1 = "pig";
        try{
            Regist(s1);
        }catch (UserNameExistException e ){
            e.printStackTrace();
            String message =e.getMessage();
            System.out.println(message);
        }

    }

    public static void Regist(String s) throws UserNameExistException {
        for (int i = 0; i < name.length; i++) {
            if (name[i].equals(s)){
                throw new UserNameExistException("您输入的用户名已经被注册");
            }
        }
    }
}
