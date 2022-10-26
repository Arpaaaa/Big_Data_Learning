package demo1;

public class GenericMethod {
    //以下都是泛型方法
    <T> int addSum(int a){
        return a;
    }

    <E> E test(E a){
        return a;
    }

    <E> void test2(E a){
        return;
    }

    public static void main(String[] args) {

        GenericMethod gm = new GenericMethod();
        System.out.println(gm.addSum(23));
        System.out.println(gm.test("String class"));

    }
}
