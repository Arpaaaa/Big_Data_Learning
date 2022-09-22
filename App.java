package PRACTICE.HeiMaTest.StudentManagement;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static ArrayList<User> userList = new ArrayList<>();
    public static void main(String[] args){
        //用户登录界面
        loop:while (true) {
            System.out.println("-----Student Management System-----");
            System.out.println("Select Your Option: 1. Log in 2. Register 3. Forget Password 4. Exit 0.Show UserList");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose){
                case "1"-> login(userList);
                case "2"-> regist(userList);
                case "3"-> forgetPassword(userList);
                case "4"-> {
                    System.out.println("Exit");
                    break loop;
                }
                case "0"->{
                    for (int i = 0; i < userList.size(); i++) {
                        System.out.println(userList.get(i));
                    }
                }
                default -> System.out.println("Not an Option ");
            }
        }

    }

    private static void forgetPassword(ArrayList<User> userList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username ");
        String username =sc.next();
        int flag = getIndex(userList,username);
        if (flag==-1){
            System.out.println("Current User " +username+" is not registered");
            return;
        }
        //键盘录入身份证号码和手机号
        System.out.println("Enter personID");
        String personID = sc.next();
        System.out.println("Enter PhoneNumber");
        String phoneNumber = sc.next();

        //比较用户对象的手机号码和身份证号码是否正确
        User user = userList.get(getIndex(userList,username));
        if (!(user.getPersonId().equalsIgnoreCase(personID) && user.getPhoneNumber().equals(phoneNumber))){
            System.out.println("Wrong PersonID or phoneNumber");
        }
        String password;
        while (true) {
            System.out.println("Correct PersonID and phoneNumber");
            System.out.println("Enter the new password: ");
            password = sc.next();
            System.out.println("Enter the new password again: ");
            String passwordAgain = sc.next();
            if (password.equals(passwordAgain)){
                System.out.println("Correct");
                break;
            }else {
                System.out.println("Incorrect Password, Enter again");
                continue;
            }
        }
        user.setPassword(password);
        System.out.println("Change Password Successfully ");


    }

    /**
     * 登录功能
     * @param userList
     */
    private static void regist(ArrayList<User> userList) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        //用户名设置
        while (true) {
            System.out.println("Enter the username");
            String username = sc.next();

            boolean flag1 = checkUsername(username);    //username 合格返回true
            if (!flag1) {
                System.out.println("Wrong Username, Enter again");
                continue;
            }
            //验证用户名唯一
            int flag2 = getIndex(userList,username);
            if (flag2 == -1){
                System.out.println("Correct username");
                user.setUsername(username);
                break;
            }else {
                System.out.println(" Username " + username + " has been registered ");
            }
        }

        //密码设置
        while (true) {
            System.out.println("Enter your password");
            String pas1 = sc.next();
            System.out.println("Enter your password again");
            String pas2 = sc.next();
            if (!pas1.equals(pas2)){
                System.out.println("Wrong password, enter again");
            }else {
                System.out.println("Correct password");
                user.setPassword(pas1);
                break;
            }
        }

        //身份证设置
        while (true) {
            System.out.println("Enter your Person ID");
            String personID = sc.next();
            boolean flagID = checkPersonID(personID);
            if (!flagID){
                System.out.println("Wrong personID, Enter again");
            }else {
                user.setPersonId(personID);
                break;
            }
        }

        //手机号设置
        while (true) {
            System.out.println("Enter Your Phone Number: ");
            String phoneNumber = sc.next();
            boolean flagPhone = checkPhoneNumber(phoneNumber);
            if (!flagPhone){
                System.out.println("Wrong Phone Number, Enter Again: ");
            }else {
                user.setPhoneNumber(phoneNumber);
                break;
            }
        }
        //将注册用户添加到用户列表中
        userList.add(user);
        System.out.println("You have registered successfully !");

    }

    /**
     * 检查手机号码
     * @param phoneNumber
     * @return
     */
    private static boolean checkPhoneNumber(String phoneNumber) {
        //判断长度
        if (phoneNumber.length() != 11){
            return false;
        }
        //不能0开头
        if (phoneNumber.startsWith("0")){
            return false;
        }
        //必须都是数字
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (phoneNumber.charAt(i) < '0' || phoneNumber.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }

    /**
     * 检查身份证
     * @param personID
     * @return
     */
    private static boolean checkPersonID(String personID) {
        //长度为18位
        if (personID.length()!=18){
            return false;
        }
        //不能以0开头
        if (personID.startsWith("0")){
            return false;
        }
        //前17位必须是数字
        for (int i = 0; i < personID.length()-1; i++) {
            if (!(personID.charAt(i) >= '0'&&personID.charAt(i) <='9')){
                return false;
            }
        }
        //最后一位数字可以是数字也可以是X或x
        char x = personID.charAt(personID.length()-1);
        if (!((x>='0'&& x<='9')||(x=='X'||x=='x'))){
            return false;
        }
        System.out.println("Correct Personal Identification");
        return true;
    }

    /**
     * 检查用户名
     * @param username
     * @return
     */
    private static boolean checkUsername(String username) {
        //1.判断长度是否正确
        int len = username.length();
        if (len <3 || len>15){
            return false;
        }
        //2.判断每个字符是否符合标准
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (!((c >= 'a'&&c<='z')||(c >= 'A'&&c<='Z')||(c >= '0'&&c<='9'))) {
                return false;
            }
        }
        //3. 判断是否为纯数字
        int alpha = 0;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if ((c >= 'a'&&c<='z')||(c >= 'A'&&c<='Z')){
                alpha++;
                break;
            }
        }
        return alpha > 0;
    }
    //TODO:实现登录功能
    private static void login(ArrayList<User> userList) {
        //提示输入信息,输入用户名、密码、验证码
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter Your Username: ");
            String username = sc.next();
            //判断用户名是否存在
            int flag = getIndex(userList,username);
            if (flag==-1){
                System.out.println("This User "+ username + " is not registered");
                return;
            }
            //输入密码
            System.out.println("Enter your password: ");
            String password = sc.next();

            //
            while (true) {
                String rightCode = getCode();
                System.out.println("Verification Code : "+rightCode);
                System.out.println("Enter the Verification Code: ");
                String code = sc.next();
                if (code.equalsIgnoreCase(rightCode)){
                    System.out.println("Correct Verification Code");
                    break;
                }else {
                    System.out.println("Wrong Verification Code, Enter again");
                }
            }
            //验证用户名和密码
            //定义方法来验证用户名和密码是否正确
            //将零散数据封装在一起,直接传递封装对象即可
            User userInfo = new User(username,password,null,null);
            boolean result = checkUserInfo(userList,userInfo);
            if (result){
                System.out.println("Log in successfully");
                //登录学生管理系统
                StudentSystem studentSystem = new StudentSystem();
                studentSystem.startStudentSystem();
                break;
            }else {
                System.out.println("Log in Failed");
                if (i==2){
                    System.out.println("Current "+username+" is locked, try later");
                    //当前账号被锁定后结束函数即可
                    return;
                }else {
                    System.out.println("Wrong Username or password , You have "+(2-i)+" times to try");
                }
            }
        }
    }

    private static boolean checkUserInfo(ArrayList<User> userList,User userInfo) {
        //遍历集合，判断用户是否存在，如存在登陆成功，若不存在则登录失败
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getUsername().equals(userInfo.getUsername()) && user.getPassword().equals(userInfo.getPassword())){
                return true;
            }
        }
        return false;
    }

    private static int getIndex(ArrayList<User> userList,String username){
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername())){
                return i;
            }
        }
        return -1;
    }

    /**
     * 生成验证码
     * @return
     */
    private static String getCode(){
        //1. 创建一个集合添加所有的大写和小写字母和数字
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a'+i));    //添加a~z字母
            list.add((char)('A'+i));
        }
        StringBuilder sb = new StringBuilder();
        //随机抽取4个字符
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(list.size());
            sb.append(list.get(index));
        }
        //随机一个数字添加到末尾
        int number = r.nextInt(10);
        sb.append(number);

        //打乱字符顺序
        char[] arr = sb.toString().toCharArray();
        //获取最后一个索引，再跟随即索引进行交换
        int randonIndex = r.nextInt(arr.length);
        //最大索引指向的元素，跟随机索引指向的元素交换
        char temp = arr[randonIndex];
        arr[randonIndex] = arr[arr.length-1];
        arr[arr.length-1] = temp;
        return new String(arr);
    }

}
