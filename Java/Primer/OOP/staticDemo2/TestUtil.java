package Big_Data_Learning.Java.Primer.OOP.staticDemo2;

public class TestUtil {
    public static void main(String[] args){
        int[] arr = {1,2,32,12,32};
        String str = ArrayUtil.printArr(arr);
        System.out.println(str);

        double[] arr2 = {1.4,3.5,5.4,6.5};
        double average = ArrayUtil.getAverage(arr2);
        System.out.println(average);

    }
}
