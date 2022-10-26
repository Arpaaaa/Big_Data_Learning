package Test;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordCountTest {
    /* 统计文本文件中字符出现的次数*/
    public static void main(String[] args) {
        WordCountTest wct = new WordCountTest();
        String srcpath = "IO\\File\\write.txt";
        String destpath = "IO\\File\\wordCount.txt";
        wct.wordCount(srcpath,destpath);

    }

    public void wordCount(String srcpath,String descpath){
        FileReader fr = null;
        BufferedWriter bw = null;
        try {
            //创建Map集合
            Map<Character,Integer> map = new HashMap<>();

            //遍历每个字符，将字符出现的次数放在map中
            fr = new FileReader(srcpath);
            int c = 0;
            while ((c=fr.read())!=-1){
                //int 还原char
                char ch = (char) c;
                //判断ch是否在map中第一次出现
                if (map.get(ch)==null){
                    map.put(ch,1);
                }else {
                    map.put(ch,map.get(ch)+1);
                }
            }

            //把map中数据存在文件count.txt中
            //创建writer
            bw = new BufferedWriter(new FileWriter(descpath));
            //遍历map，再写入数据
            Set<Map.Entry<Character,Integer>> entrySet = map.entrySet();    //获取map的entryset
            for (Map.Entry<Character,Integer> entry:entrySet){
                switch (entry.getKey()){
                    case ' ':
                        bw.write("blank = " + entry.getValue());
                        break;
                    case '\t':
                        bw.write("tab = " + entry.getValue());
                        break;
                    case '\r':
                        bw.write("Enter = "+entry.getValue());
                        break;
                    case '\n':
                        bw.write("line break = " + entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey() + "="+entry.getValue());
                        break;
                }
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fr!=null){
                try {
                    fr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (bw!=null){
                try {
                    bw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
