package Stream;

import java.io.*;
import java.security.PublicKey;

/* 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
* 对于非文本文件(.jpg,.mp4,.avi,.doc,.ppt...)，使用字节流文件*/
public class FileInputOutput {

    public static void main(String[] args) {
        FileInputOutput fIO = new FileInputOutput();
        /*fIO.FileInputStream();*/
        /*String srcpath = "IO\\File\\test.jpg";
        String destpath = "IO\\File\\test3.jpg";
        fIO.copyFile(srcpath,destpath);*/
        fIO.testCopyFile();
    }

    /**
     * 将jpg格式文件进行读入操作
     * @return void
     * 会输出乱码序列
     */
    public void FileInputStream() {
        FileInputStream FIS = null;
        try {
            //创建文件类对象
            File file = new File("IO\\File\\test.jpg");
            //创建文件输入流对象
            FIS = new FileInputStream(file);
            //数据读入
            byte[] buffer = new byte[5];
            int len;
            while ((len = FIS.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                FIS.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


    /**
     * 字节流应用：复制图片
     * 两个输入输出流：FileInputStream,FileOutputStream
     * @return void
     */
    public void FileInputOutputTest(){
        FileInputStream fileIS = null;
        FileOutputStream fileOS = null;
        try {
            //创建文件类对象
            File fileRead = new File("IO\\File\\test.jpg");
            File fileWrite = new File("IO\\File\\test2.jpg");

            //创建输入输出流对象
            fileIS = new FileInputStream(fileRead);
            fileOS = new FileOutputStream(fileWrite);

            //读入写出文件
            byte[] b = new byte[10];
            int len;
            while ((len = fileIS.read(b)) != -1) {
                fileOS.write(b, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                fileIS.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fileOS.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 复制特定路径文件方法
     * @param srcPath
     * @param destPath
     */
    public void copyFile(String srcPath,String destPath){
        FileInputStream fileIS = null;
        FileOutputStream fileOS = null;
        try {
            //创建文件类对象
            File fileRead = new File(srcPath);
            File fileWrite = new File(destPath);

            //创建输入输出流对象
            fileIS = new FileInputStream(fileRead);
            fileOS = new FileOutputStream(fileWrite);

            //读入写出文件
            byte[] b = new byte[100];
            int len;
            while ((len = fileIS.read(b)) != -1) {
                fileOS.write(b, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                fileIS.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fileOS.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void testCopyFile(){
        long start = System.currentTimeMillis();
        //例：复制录音文件
        String srcpath = "D:\\JAVA\\PRACTICE\\HeiMaTest\\IO\\File\\write.txt";
        String destpath = "D:\\JAVA\\PRACTICE\\HeiMaTest\\IO\\File\\write2.txt";
        copyFile(srcpath,destpath);

        long end = System.currentTimeMillis();
        System.out.println("Time : "+ (start-end));
    }
}
