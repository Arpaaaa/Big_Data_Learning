package Stream;

import java.io.*;

public class BufferTest {
    /* 缓冲流的使用
    * BufferedInputStream
    * BufferedOutputStream
    * BufferedReader
    * BUfferedWriter
    *
    * 作用：提升流的读取、写入的速度
    * 处理流就是套接在已有的流上。
    * */

    /**
     * Main方法实现缓冲流测试
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        BufferTest bt = new BufferTest();
        bt.testCopyFileWithBR();

    }

    /**
     * 使用缓冲流实现非文本文件的复制
     */
    public void BufferStream() throws FileNotFoundException {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //File类创建
            File srcFile = new File("IO\\File\\test.jpg");
            File destFile = new File("IO\\File\\test2.jpg");
            //造节点流
            FileInputStream fis = new FileInputStream(srcFile);     //param:the file to be opened to read
            FileOutputStream fos = new FileOutputStream(destFile);
            //造缓冲流
            bis = new BufferedInputStream(fis);     //param: the underlying input stream
            bos = new BufferedOutputStream(fos);   //param:the underlying output stream

            //读取和写入的过程
            byte[] buffer = new byte[5];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭资源
            //要求：先关闭外层的流，再关闭内层的流
            if (bis!=null){
                try {
                    bis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (bos!=null){
                try {
                    bos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
        //在关闭外层流的同时，内层流也会同时关闭，所以内层流的关闭可以省略
        /*fis.close();
        fos.close();*/
    }

    /**
     * 使用缓冲流复制非文本文件
     * @param srcPath
     * @param destPath
     */
    public void CopyFileWithBuffer(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //File类创建
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //造节点流
            FileInputStream fis = new FileInputStream(srcFile);     //param:the file to be opened to read
            FileOutputStream fos = new FileOutputStream(destFile);
            //造缓冲流
            bis = new BufferedInputStream(fis);     //param: the underlying input stream
            bos = new BufferedOutputStream(fos);   //param:the underlying output stream

            //读取和写入的过程
            byte[] buffer = new byte[100];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
                //bos.flush(); //刷新缓冲区
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭资源
            //要求：先关闭外层的流，再关闭内层的流
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 测试使用缓冲流复制非文本文件
     */
    public void testFileCopyWithBuffer(){
        long start = System.currentTimeMillis();
        //例：复制录音文件
        String srcpath = "D:\\JAVA\\PRACTICE\\HeiMaTest\\IO\\File\\arpat_voice.m4a";
        String destpath = "D:\\JAVA\\PRACTICE\\HeiMaTest\\IO\\File\\arpat_voice2.m4a";
        CopyFileWithBuffer(srcpath,destpath);

        long end = System.currentTimeMillis();
        System.out.println("Time : "+ (start-end));
    }

    /**
     * 使用BufferReader,BufferWriter实现文本文件复制
     */
    public void CopyFileWithBR(String srcpath,String destpath){
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            //创建文件类对象
            File file1 = new File(srcpath);
            File file2 = new File(destpath);

            //创建节点流和缓冲流
            br = new BufferedReader(new FileReader(file1));
            bw = new BufferedWriter(new FileWriter(file2));

            //数据读入和写出
            /*char[] buff = new char[100];
            int len;
            while ((len=br.read(buff))!=-1){
                bw.write(buff,0,len);
                bw.flush();
            }*/
            //使用String来读写文件
            String data;
            while ((data = br.readLine())!=null){
                //写文件换行
                //bw.write(data+"\n");
                bw.write(data);
                bw.newLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭资源
            if (br!=null){
                try {
                    br.close();
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

    /**
     * 测试使用缓冲流复制文本文件
     */
    public void testCopyFileWithBR(){
        String srcpath = "IO\\File\\write.txt";
        String destpath = "IO\\File\\write2.txt";

        long start = System.currentTimeMillis();
        CopyFileWithBR(srcpath,destpath);

        long end = System.currentTimeMillis();
        System.out.println("Time : "+ (start-end));

    }



}
