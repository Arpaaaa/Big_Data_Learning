public class MannualThrow {
    public static void main(String[] args) {
        Student s = new Student();
        s.regist(-12);
        System.out.println(s);
    }


}

class Student{
    private int id;
    public void regist(int id){
        if (id>0){
            this.id = id;
        }else {
            //手动抛出异常,一般情况下只抛出RuntimeException 和 Exception即可
            throw new RuntimeException("Wrong Input");
        }
    }
}
