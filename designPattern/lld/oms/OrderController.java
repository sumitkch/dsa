package designPattern.lld.oms;

import com.sun.org.apache.xpath.internal.operations.Or;
import designPattern.lld.oms.user.User;

import java.util.ArrayList;
import java.util.List;

public class OrderController {

    private List<Order> orderList;

    public OrderController(){
        this.orderList=new ArrayList<>();
    }

    public void addOrder(Order order){
        orderList.add(order);
    }

    public void removeOrder(Order order){
        orderList.remove(order);
    }
    public Order createNewOrder(User user, Warehouse warehouse){
        return new Order(user, warehouse);
    }
}
