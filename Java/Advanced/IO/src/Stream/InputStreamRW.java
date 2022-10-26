package Stream;

/* 转换流的使用
* InputStreamReader : 将字节输入流转换为字符输入流
* OutputStreamWriter    : 将字符输出流转换为字节输出流
* 两者同属于字符流
* 作用：提供字节流与字符流之间的转换
* 从字节->字符 解码
* 从字符->字节 编码
*
* 字符集
*   ASCII:美国标准信息交换码，一个字节的7位来标识
*   UTF-8:变长的编码方式，用1-4个字节来表示一个字符
*   Unicode: 国际通用字符集，所有文字使用两个字节来存储
* */


import java.io.*;

public class InputStreamRW {

    public static void main(String[] args) {
        InputStreamRW isrw = new InputStreamRW();
        isrw.FileOutputStream();

    }

    /**
     * 实现字节流到字符流的转换
     * @throws IOException
     */
    public void FileInputStream() throws IOException {
        //处理异常需要用try-catch-family

        FileInputStream fis = new FileInputStream("IO\\File\\Hello.txt");
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8"); //字符集默认为系统设置字符集

        char[] cbuff = new char[20];
        int len;
        while ((len = isr.read(cbuff))!=-1){
            String str = new String(cbuff,0,len);
            System.out.println(str);
        }

        isr.close();
    }

    public void FileOutputStream(){
        InputStreamReader isr=null;
        OutputStreamWriter osw=null;

        try {
            FileInputStream fis = new FileInputStream(new File("IO\\File\\Hello.txt"));
            FileOutputStream fos = new FileOutputStream(new File("IO\\File\\Hello2.txt"));

            isr = new InputStreamReader(fis, "utf-8");
            osw = new OutputStreamWriter(fos, "gbk");

            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                osw.write(cbuf, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (isr!=null){
                try {
                    isr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (osw!=null){
                try {
                    osw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }





}
