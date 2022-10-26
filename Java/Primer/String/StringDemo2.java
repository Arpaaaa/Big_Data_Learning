package Big_Data_Learning.Java.Primer.String;

import java.util.Scanner;

public class StringDemo2 {
    public static void main(String[] args){
        //1.正确的用户名和密码
        String rightUserName = "arpat";
        String rightPassWord = "123456";

        Scanner sc = new Scanner(System.in);
        for (int i=0;i<3;i++) {
            //键盘录入用户名和密码
            System.out.println(" Enter the username ");
            String username = sc.next();
            System.out.println(" Enter the password ");
            String password = sc.next();

            //比较
            if (rightUserName.equals(username) && rightPassWord.equals(password)){
                System.out.println("The username and password is correct");
                break;
            }else {
                if (i == 2){
                    System.out.println("Your account is frozen");
                }else {
                    System.out.printf("Incorrect, %d times remained ",2-i);
                }
            }
        }
    }
}
