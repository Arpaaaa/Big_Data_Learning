package demo1;

public class Order<T> {

    public String orderName;
    int orderId;
    //类的内部结构可以使用类的泛型
    T orderT;

    public Order(){}

    public Order(String orderName,int orderId,T orderT){
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderT = orderT;
    }



}
