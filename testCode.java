package Big_Data_Learning.Java.Projects.StudentManagement;

import java.util.ArrayList;
import java.util.Random;

public class testCode {
    public static void main(String[] args){
        getCode();
    }
    private static String getCode(){
        //1. 创建一个集合添加所有的大写和小写字母和数字
        ArrayList<Character> list22 = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list22.add((char)('a'+i));    //添加a~z字母
            list22.add((char)('A'+i));
        }
        StringBuilder sb = new StringBuilder();
        //随机抽取4个字符
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(list22.size());
            sb.append(list22.get(index));
        }
        //随机一个数字添加到末尾
        int number = r.nextInt(10);
        sb.append(number);

        //打乱字符顺序
        char[] arr = sb.toString().toCharArray();
        //获取最后一个索引，再跟随即索引进行交换
        int randonIndex = r.nextInt(arr.length);
        //最大索引指向的元素，跟随机索引指向的元素交换
        char temp = arr[randonIndex];
        arr[randonIndex] = arr[arr.length-1];
        arr[arr.length-1] = temp;
        System.out.println(arr);
        return new String(arr);
    }
}
