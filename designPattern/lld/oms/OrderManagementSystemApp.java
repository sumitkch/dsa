package designPattern.lld.oms;

import designPattern.lld.oms.user.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class OrderManagementSystemApp {
    private UserController userController;
    private WarehouseController warehouseController;
    private OrderController orderController;

    public OrderManagementSystemApp(List<User> userList, List<Warehouse> warehouseList){
        userController=new UserController(userList);
        warehouseController=new WarehouseController(warehouseList, null);
        orderController=new OrderController();
    }

    public User getUser(int userId){
        return userController.getUser(userId);
    }

    public Warehouse getWarehouse(WarehouseSelectionStrategy strategy){
        return warehouseController.getWareHouseFromStrategy(null);
    }

    public Inventory getInventory(Warehouse warehouse){
        return warehouse.getInventory();
    }

    public void addProductToCart(User user, ProductCategory productCategory, int count){
        user.getCart().addItem(productCategory.getProductCategoryID(), count);
    }

    public Order placeOrder(User user, Warehouse warehouse){
        return orderController.createNewOrder(user, warehouse);
    }

    public void checkout(Order order){
        order.getCheckout();
    }
}
