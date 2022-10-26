package Stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

    /* RandomAccessFile 类
    * 程序可以直接跳到文件的任意地方来读写文件
    * 实现的接口：DataInput,DataOutput,Closeable,AutoCloseable
    * RandomAccessFile既可以作为输入流，也可以作为输出流
    * 继承了Object类*/

    public static void main(String[] args) {
        RandomAccessFileDemo rafd = new RandomAccessFileDemo();
        try {
            rafd.test2();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 使用RandomAccessFile实现文本文件的复制
     */
    public void test1(){
        RandomAccessFile raf1=null;
        RandomAccessFile raf2=null;

        try {
            //“r","rw"指访问文件的模式，只读，可读可编辑
            raf1 = new RandomAccessFile(new File("IO\\File\\Hello.txt"), "r");
            raf2 = new RandomAccessFile(new File("IO\\File\\Hello2.txt"), "rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (raf1!=null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (raf2!=null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }


    /**
     * 对文件内容的覆盖,实现文件内容插入效果
     * 如果RAF作为输出流出现，写出文件不存在则创建新文件，如果写出文件存在，则从头开始覆盖
     * RAF有一个文件指针，用来指向当前写入的位置
     */
    public void test2() throws FileNotFoundException {

        RandomAccessFile raf1 = new RandomAccessFile(new File("IO\\File\\Hello2.txt"),"rw");

        try {
            raf1.seek(5);
            //raf1.write("这里是一个覆盖文本".getBytes());

            //保存要插入位置后面的字符
            byte[] buffer = new byte[1024];
            int len;
            StringBuilder builder = new StringBuilder((int) new File("IO\\File\\Hello2.txt").length());
            while ((len=raf1.read(buffer))!=-1){
                builder.append(new String(buffer,0,len));
            }
            raf1.seek(5);   //调回指针
            raf1.write("这是一个插入信息".getBytes());

            //将builder内容写入文件
            raf1.write(builder.toString().getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            raf1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //思考：将StringBUilder替换为bytearrayoutputStream

    }

}
