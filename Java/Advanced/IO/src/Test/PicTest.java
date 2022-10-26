package Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PicTest {
    /*实现图片加密*/
    public static void main(String[] args) {
        PicTest pt = new PicTest();
        //生成了一个加密的照片文件
        //pt.Pic();
        pt.Pic2();
    }

    /**
     * 对照片进行加密方法
     */
    public void Pic(){
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            fis = new FileInputStream("IO\\File\\test.jpg");
            fos = new FileOutputStream("IO\\File\\test_sercret.jpg");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                //对字节数据进行修改实现加密
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fos.write(buffer, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fis!=null){
                try {
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 对照片进行解密
     */
    public void Pic2(){
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            fis = new FileInputStream("IO\\File\\test_sercret.jpg");
            fos = new FileOutputStream("IO\\File\\test_decode.jpg");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                //对字节数据进行修改实现加密
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fos.write(buffer, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fis!=null){
                try {
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
