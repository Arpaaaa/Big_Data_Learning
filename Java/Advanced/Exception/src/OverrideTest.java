import java.io.FileNotFoundException;
import java.io.IOException;

public class OverrideTest {
    /*子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型*/

    public static void main(String[] args) {
        OverrideTest test = new OverrideTest();
        test.display(new subClass());
    }
    public void display(superClass s ){
        try {
            s.method();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

class superClass{
    public void method() throws IOException{

    }
}

class subClass extends superClass{
    //重写父类方法method并且抛出的异常应小于父类该方法抛出的方法IOException
    @Override
    public void method() throws FileNotFoundException{

    }
}