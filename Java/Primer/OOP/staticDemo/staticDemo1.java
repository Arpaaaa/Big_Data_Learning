package Big_Data_Learning.Java.Primer.OOP.staticDemo;

public class staticDemo1 {
    private String name;
    private int age;
    private String gender;

    public static String teachername;   //静态变量

    //行为
    public void study(){
        System.out.println(name + " is studying");
    }



    public staticDemo1() {
    }

    public staticDemo1(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String toString() {
        return "staticDemo1{name = " + name + ", age = " + age + ", gender = " + gender + ",teacher = " + teachername + "}";
    }
}
