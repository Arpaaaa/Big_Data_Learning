package Big_Data_Learning.Java.Primer.String;

public class StringDemo {
    public static void main(String[] args){
        String s1 = new String("abc");
        String s2 = "abc";
        String s3 = "ABC";

        System.out.println(s1 == s2);

        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s3));
    }


}
