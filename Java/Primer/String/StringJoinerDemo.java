package Big_Data_Learning.Java.Primer.String;

import java.util.StringJoiner;

public class StringJoinerDemo {
    public static void main(String[] args){
        StringJoiner sj = new StringJoiner("---");
        sj.add("aaa").add("BBB").add("ccc");

        StringJoiner sj2 = new StringJoiner(",","[","]");
        sj2.add("aaa").add("BBB").add("ccc");


        System.out.println(sj2);
    }
}
