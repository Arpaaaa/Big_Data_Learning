package Stream;

/* 流的分类 */

import java.io.*;

public class FileReaderWriter {

    public static void main(String[] args) {

        FileReaderWriter frw = new FileReaderWriter();
        //frw.FileReaderTest();
        frw.FileReaderTest();
    }
    /* 将Hello.txt文件读入到程序中，并输出到控制台*/
    public void FileReaderTest() {
        FileReader fileReader = null;
        try {
            //实例化File类对象，指明我们要操作的文件
            File file = new File("IO\\File\\Hello.txt");    //文件位置相较于当前Module
            //操作具体的流
            fileReader = new FileReader(file);      //抛出FileNotFoundException异常，所以要读入的文件必须存在

            //数据读入
            /*read() 返回读入的字符，如果达到文件末尾则返回-1*/
            //方式一
        /*int data = fileReader.read();
        while (data!=-1){
            System.out.print((char) data);
            data = fileReader.read();
        }*/
            //方式二
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                //流的关闭方法
                if (fileReader != null) {
                    fileReader.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void FileRTest() throws IOException {
        FileReader fr = null;
        try {
            //实例化文件对象
            File file = new File("IO\\File\\Hello.txt");

            //FileReader流的实例化
            fr = new FileReader("IO\\File\\Hello.txt");

            //读入的操作
            char[] cbuf = new char[5];  //一次读入5个字符到 字符数组中
            int len;
            //read(char[] cbuf)返回每次读入cbuf数组中的字符个数，如达到文件末尾则返回-1
            while ((len = fr.read(cbuf)) != -1) {
                //错误写法
            /*for (int i=0;i<cbuf.length;i++){

            }
            因为cbuf.length返回cbuf数组中所有的字符，在最后一个读取文件时，读入的字符可能小于数组长度，导致读入的字符与前一次的字符同时读入
            造成数据脏读的情况，同理String(cbuf)也会有这个问题*/
                //正确写法
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
                //错误写法
                /*String str = new String(cbuf);
                System.out.println(str);*/
                String str = new String(cbuf,0,len);    //将0~len的部分变为字符串
                System.out.print(str);

            }
        }catch(IOException e){
            e.printStackTrace();
        } finally {
            //资源的关闭
            if (fr != null) {
                try {
                    fr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }

    /* 从内存中写出数据到硬盘文件中
    * 输出操作，对应的文件可以不存在，如果不存在则自动创建此文件
    * 如果存在:
    *   使用流构造器为FileWriter(file,true),则不会覆盖原有内容;如果使用FileWriter(file,false)，则会覆盖原有的内容*/
    public void FileWTest() {
        FileWriter fw = null;
        try {
            File file = new File("IO\\File\\write.txt");
            //如果append:true 说明在原有文件之后追加写入内容，如果append:false说明会覆盖原有文件内容
            fw = new FileWriter(file,true);

            //写出操作
            fw.write("I hava a dream to become a data scientist");
            fw.write("I will make it come true");


        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //资源关闭
            try {
                fw.close();
            } catch (IOException e) {
                 e.printStackTrace();
            }
        }
    }

    /**
     * 将文件读入并写出，类似 文件复制
     * @return void
     * @author arpat
     */
    public void FileRFileW() {

        /*将文件读入并写出*/
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //创建File类对象，指明读入和写出的文件
            File fileR = new File("IO\\File\\write.txt");
            File fileW = new File("IO\\File\\write2.txt");

            //创建输入和输出流对象
            fr = new FileReader(fileR);
            fw = new FileWriter(fileW);

            //数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;    //记录每一次读入到cbuf数组中的字符个数
            while ((len = fr.read(cbuf)) != -1) {
                //每次写出lenge字符
                fw.write(cbuf, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                fr.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }



}
