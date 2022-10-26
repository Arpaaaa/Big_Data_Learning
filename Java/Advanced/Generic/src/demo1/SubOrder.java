package demo1;

public class SubOrder extends Order<Integer>{
    //继承父类Order时，指明了泛型为Integer类
}


class SubOrder1<E> extends Order<E>{
    //继承父类时没有指明泛型类型
}
