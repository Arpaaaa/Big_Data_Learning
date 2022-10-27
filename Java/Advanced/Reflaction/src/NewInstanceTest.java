package Big_Data_Learning.Java.Advanced.Reflaction.src;

public class NewInstanceTest {
    /* 使用反射创建运行时类的对象 */
    public static void main(String[] args) {
        NewInstanceTest nit = new NewInstanceTest();
        try {
            nit.test1();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void test1() throws Exception {
        Class<Person> clazz = Person.class;
        //newInstance:创建对应运行时类的对象
        Person p1 = clazz.getDeclaredConstructor().newInstance();

        System.out.println(p1.age);

    }
}
