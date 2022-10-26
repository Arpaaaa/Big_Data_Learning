package Big_Data_Learning.Java.Primer.String;

import java.util.Scanner;

public class StringRomanDemo {
    //键盘录入一个字符串
    //长度小于等于9
    //只能是数字
    //将内容转换为罗马数字，数字与罗马数子的对应关系为(I-1,II-2,III-3,IV-4,V-5,VI-6,VII-7,VIII-8,IX-9)
    public static void main(String[] args){
        //输入字符串
        System.out.println("Enter the String: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        //调用方法转换
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int number = c - 48;    //48是字符0代表的ASCII码
            String rome = toRome(number);
            sb.append(rome);
        }
        System.out.print(sb);
        //输入结果
    }
    public static String toRome(int number){
        String[] arr = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        return arr[number];
    }
    /*
    public static String toRome2(char c){
        String str = switch (c){
            case '1' -> "I";
            case '2' -> "II";
            case '3' -> "III";
            case '4' -> "IV";
            case '5' -> "V";
            case '6' -> "VI";
            case '7' -> "VII";
            case '8' -> "VIII";
            case '9' -> "IX";
        };
        return str;
    }
    */

    public static boolean checkStr(String str){
        if (str.length()>9){
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);     //返回str中的每一个字符
            if (c < '0' || c > '9'){
                return false;
            }
        }
        //只有当所有字符判断结束后才返回
        return true;
    }

}
