public class MyException extends RuntimeException{
    /*自定义异常类
    * 1. 继承于现有的异常结构：RuntimeException,Exception
    * 2. 提供全局常量：serialVersionUID 序列号
    * 3. 提供重载的构造器
    * */

    static final long serialVersionUID = 232391024981L;
    public MyException(){}
    public MyException(String msg){super(msg);}
}
