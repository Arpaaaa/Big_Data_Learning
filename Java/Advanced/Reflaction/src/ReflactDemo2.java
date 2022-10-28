package Big_Data_Learning.Java.Advanced.Reflaction.src;

import Big_Data_Learning.Java.Advanced.Reflaction.src.demo1.MyAnnnotation;
import Big_Data_Learning.Java.Advanced.Reflaction.src.demo1.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflactDemo2 {

    public static void main(String[] args) {

    }

    public void test()throws Exception{
        Class<Person> personClass = Person.class;

        //
        Field declaredField = personClass.getDeclaredField("name");
        Field field = personClass.getField("name");
        Method[] declaredMethods = personClass.getDeclaredMethods();
        Method method = personClass.getMethod("drink");
        int modifiers = personClass.getModifiers();
        Constructor<Person> constructor = personClass.getConstructor();
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor();
        //Annotation annotation = personClass.getAnnotation();
        Annotation[] declaredAnnotations = personClass.getDeclaredAnnotations();
        Class<?>[] interfaces = personClass.getInterfaces();
        //Annotation[] declaredAnnotationsByType = personClass.getDeclaredAnnotationsByType();

    }
}
