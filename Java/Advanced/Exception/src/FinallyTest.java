public class FinallyTest {
    /*finally 的使用
    * finally是可选的*/

    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            System.out.println(a/b);
        }catch (ArithmeticException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("this is finally");
        }

    }


}
