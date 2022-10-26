package Big_Data_Learning.Java.Primer.String;

import java.util.Scanner;

public class StringBuilderDemo2 {
    //键盘接收字符串，判断字符串是否为对称字符串，并打印是或否
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(symmetry(str));
    }
    public static boolean symmetry(String str){
        StringBuilder sb = new StringBuilder(str);
        if (str.equals(sb.reverse().toString())){
            return true;
        }
        return false;
    }
}
