package Big_Data_Learning.Java.Primer.String;

public class StringDemo5 {
    //实现手机号码屏蔽
    public static void main(String[] args){
        //获取手机号
        String phoneNumber = "19821287739";

        //获取手机中间四位
        String begin = phoneNumber.substring(0,3);
        String end = phoneNumber.substring(7,11);

        System.out.println(begin+"****"+end);
    }
}
