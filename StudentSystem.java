package Big_Data_Learning.Java.Projects.StudentManagement;

import java.util.ArrayList;
import java.util.Scanner;


public class StudentSystem {
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static void startStudentSystem(){
        //创建学生集合
        //ArrayList<Student> studentList = new ArrayList<>();
        //标记：将while循环用loop标记
        //final 关键字
        final String ADD_STUDENT = "1";
        final String DELETE_STUDENT = "2";
        final String MODIFY_STUDENT = "3";
        final String QUERY_STUDENT = "4";
        final String EXIT_STUDENT = "5";
        loop: while (true) {
            //输出界面
            System.out.println("--------Student Management System--------");
            System.out.println("1. Add Student ");
            System.out.println("2: Delete Student ");
            System.out.println("3: Modify Student Information ");
            System.out.println("4: Query Student ");
            System.out.println("5: Exit ");
            System.out.println("Enter Your Selection: ");
            //用户输入
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose){
                case ADD_STUDENT->addStudent(studentList);
                case DELETE_STUDENT->delStudent(studentList);
                case MODIFY_STUDENT->updateStudent(studentList);
                case QUERY_STUDENT->queryStudent(studentList);
                case EXIT_STUDENT->{
                    System.out.println(" Exit ");
                    break loop;
                    //System.exit(0); //停止虚拟机运行
                }
                default -> System.out.println("Not An Option");
            }
        }


    }

    //添加方法
    public static boolean addStudent(ArrayList<Student> studentList){
        Student student = new Student();

        //判断输入学生id是否已经在系统中存在，若存在则提示重新出入，若没有则继续
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Please Enter the Student id: ");
            String id = sc.next();
            boolean flag = contains(studentList,id);
            if (flag){
                System.out.println("This id is already exists , Please enter again ");
            }else {
                student.setId(id);
                break;
            }
        }
        System.out.println("Please Enter the Student Name: ");
        student.setName(sc.next());
        System.out.println("Please Enter the Student Age: ");
        student.setAge(sc.nextInt());
        System.out.println("Please Enter the Student Address: ");
        student.setAddress(sc.next());

        //把学生加到学生集合中
        studentList.add(student);
        //提示添加成功
        System.out.println(" Add Student Successfully ! ");
        return true;
    }

    //删除学生
    public static void delStudent(ArrayList<Student> studentList){
        //判断删除学生是否在系统中，如果不在则提示，若在则继续
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the Student id ");
        String id = sc.next();
        int index = getIndex(studentList,id);
        if (index>=0){
            //student exists
            studentList.remove(index);
            System.out.println(" Student "+ id + " deleted  Successfully ");
        }else {
            //student doesn't exist
            System.out.println("Student doesn't exist, enter again ");
        }
    }

    //修改学生
    public static void updateStudent(ArrayList<Student> studentList){
        //判断id是否存在
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the Student id: ");
        String id = sc.next();
        //获取id的索引
        int index = getIndex(studentList,id);
        if (index == -1){
            System.out.println("The student doesn't exist");
            return;
        }
        //根据索引来修改信息
        System.out.println("Please Enter the Student Name: ");
        studentList.get(index).setName(sc.next());
        System.out.println("Please Enter the Student Age: ");
        studentList.get(index).setAge(sc.nextInt());
        System.out.println("Please Enter the Student Address: ");
        studentList.get(index).setAddress(sc.next());
        System.out.println("Update Student Successfully");
    }

    //查询学生
    public static void queryStudent(ArrayList<Student> studentList){
        //判断学生集合是否为空
        if (studentList.size()==0){
            System.out.println("No Student Information.Please Add Student First");
            return ;
        }

        //表头信息打印
        System.out.println("id\tName\tAge\tAddress");
        for (Student student1 : studentList) {
            System.out.println(student1.getId()+"\t"+student1.getName()+"\t"+student1.getAge()+"\t"+student1.getAddress());
        }
    }
    //判断id是否已存在
    public static boolean contains(ArrayList<Student> studentList, String id){
        return getIndex(studentList,id) >= 0;
    }

    /**
     * 根据学生id获取学生集合中的索引
     * @param studentList
     * @param id
     * @return index
     */
    public static int getIndex(ArrayList<Student> studentList,String id){
        for (int i = 0; i < studentList.size(); i++) {
            if (id.equals(studentList.get(i).getId())){
                return i;
            }
        }
        return -1;
    }
    /*public static int getIndex(ArrayList<Student> studentList,String name){
        for (int i = 0; i < studentList.size(); i++) {
            if (id.equals(studentList.get(i).getName())){
                return i;
            }
        }
        return -1;
    }*/


}

































