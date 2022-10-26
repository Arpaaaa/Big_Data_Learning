package Big_Data_Learning.Java.Primer.String;

public class StringDemo3 {
    public static void main(String[] args){
        // 定义一个方法把int数组中的元素拼接成字符串返回
        int[] arr = {1,2,3};
        String str = arrToString(arr);
        System.out.println(str);

    }
    public static String arrToString(int[] arr){
        if (arr.length == 0){
            return "[]";
        }
        if (arr == null){
            return " ";
        }
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1){
                result = result + arr[i];
            }else {
                result = result + arr[i] + ",";
            }
        }
        result += "]";
        return result;
    }
}
