public class ExceptionDemo1 {
    public static void main(String[] args) {
        String str = "123";
        str = "abc";
        /*使用try将可能出现异常的代码包装起来，一旦出现异常，就生成一个异常类对象，根据此对象取catch中进行匹配
        * 一旦对象匹配到catch时，就会进入catch中进行异常处理，一旦处理完成就会跳出语句
        * 跳出try-catch语句后继续执行后面的代码*/
        try {
            int num = Integer.parseInt(str);    //可能出现错误的代码
            System.out.println("--------");
        }catch (NumberFormatException e){
            System.out.println("Exception Occur");
            e.getMessage();
            //获取异常的详细信息
            e.printStackTrace();
        }
        System.out.println("=========");
    }


}
