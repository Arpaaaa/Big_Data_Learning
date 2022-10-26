import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class ErrorTest {

    public static void main(String[] args) {
        //********RuntimeException**********************************
        //NullPointerException
/*
        String str = null;
        System.out.println(str.charAt(0));
*/
        //ArrayIndexOutBoundsException
/*        int[] arr = {0,1,2};
        System.out.println(arr[5]);*/
        //ClassCastException
 /*       Object str = new String();
        Integer it = (Integer) str;
 */       //InputMissMatchException
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();

        //*************
        File file = new File("hello.txt");
    }
}
