package Big_Data_Learning.Java.Primer.String;

import java.util.Scanner;

public class StringDemo4 {
    //实现字符串的反转
    public static void main(String[] args){
        //实现逻辑
        //1. 将string中的每一个单词取出并拼接到新的字符串,由于String不可变那么可以用substring来提取单个字符
        //2. 将提取的字母拼接在新字符串
        //升级：键盘录入字符串，并实现字符串反转
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(reverser(str));

    }
    public static String reverser(String str){
        String reverseStr = "";
        for (int i = str.length(); i > 0; i--) {
            String word = str.substring(i-1,i);
            reverseStr = reverseStr.concat(word);
        }
        return reverseStr;
    }
}
