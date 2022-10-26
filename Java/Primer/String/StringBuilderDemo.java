package Big_Data_Learning.Java.Primer.String;
/*StringBuilder 的用法*/

public class StringBuilderDemo {
    //StringBuilder 用法
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder("abc");

        sb.append(12);
        sb.reverse();
        int a = sb.length();
        String str = sb.toString();
        System.out.println(sb);
        System.out.println(str);
        System.out.println(a);

    }
}
