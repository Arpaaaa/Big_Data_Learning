import java.io.IOException;

public class ExceptionDemo2 {

    public static void main(String[] args) {
        //main 方法是处理异常的最终防线，main如果无法解决则会将异常抛给虚拟机解决
        try {
            test();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void test() throws IOException{
        /*可能出现异常的代码
        * throws 向上一级报告出现的异常*/


    }
}
