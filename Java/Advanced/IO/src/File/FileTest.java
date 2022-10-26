package File;

import java.io.File;
import java.io.IOException;

/* File 类的使用
* 相对路径和绝对路径
* 路径分隔符
*   windows:\\
*   unix:/

* File类中设计到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法
* 如果需要涉及读写文件内容的操作，则必须使用IO流来完成
* */



public class FileTest {

    public static void main(String[] args) throws IOException {
        FileTest ft = new FileTest();
        //ft.test1();
        //ft.test2();
        //ft.test3();
        ft.test5();
    }

    public void test1() throws IOException {
        //构造器一
        File file1 = new File("File/Hello.txt");    //相对于当前module
        File file2 = new File("D:\\JAVA\\PRACTICE\\HeiMaTest\\IO\\File\\Hello.txt");    //绝对路径，\\是避免转义符增加了一个\
        File file3 = new File("File"+ File.separator+"Hello.txt");  //FIle separator 使用

        System.out.println(file1);
        //构造器二
        File file4 = new File("D:\\JAVA\\PRACTICE\\HeiMaTest\\IO","File");  //file4 在此处是文件路径
        //constructor 3
        File file5 = new File(file4,"Hello.txt");


        //常用方法
        //获取功能
        System.out.println(file1.getAbsoluteFile());    //获取绝对路径
        System.out.println(file1.getPath());    //获取路径
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.getTotalSpace());
        System.out.println(file1.lastModified());
        System.out.println(file1.getCanonicalPath());

    }

    public void test2(){

        File file = new File("D:\\JAVA\\PRACTICE\\HeiMaTest");
        //输出路径下的文件名
        String[] list = file.list();
        for (String s:list){
            System.out.println(s);
        }
        //返回路径中的文件绝对位置
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }

    public void test3(){
        /* public boolean renameTo(File dest) 把文件重命名为指定的文件路径
        * 例如：file1.renameTo(file2) 需要保证file1在硬盘中存在，file2在硬盘中不存在
        * */
        File f1 = new File("File/Hello.txt");
        File f2 = new File("File/Hey.txt");

        boolean renameTo = f1.renameTo(f2);
        System.out.println(renameTo);
    }

    public void test4(){
        File f1 = new File("IO\\File\\Hello.txt");
        File f2 = new File("D:\\JAVA\\PRACTICE\\HeiMaTest\\IO\\File\\Hello.txt");
        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());
        System.out.println(f1.exists());
        System.out.println(f1.canRead());
        System.out.println(f1.canWrite());
        System.out.println(f1.isHidden());
    }
    public void test5() throws IOException {
        /*创建和删除硬盘中对应的文件或文件目录*/
        File file = new File("IO\\File\\Hiii.txt");
        if (!file.exists()){
            file.createNewFile();
            System.out.println("Create Successfully");
        }else {
            file.delete();
            System.out.println("Delete Successfully");
        }

        //文件目录创建
        //mkdir() 只创建最后一层，如果上面的文件不存在则不在创建
        //mkdirs() 如果上层文件目录不存在则一并创建
        File file1 = new File("IO\\File2\\RedFile");
        if (!file1.exists()){
            file1.mkdirs();
        }else {
            file1.delete();
        }
    }
}
