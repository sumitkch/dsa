package designPattern.lld.oms;

import designPattern.lld.oms.user.Address;
import designPattern.lld.oms.user.User;

import java.util.Map;
import java.util.Random;

public class Order {
    private int orderID;
    private User user;
    private Address deliveryAddress;
    private Map<Integer, Integer> prodCatIdVsCount;
    private Warehouse warehouse;
    private Invoice invoice;
    private Payment payment;
    private OrderStatus orderStatus;


    public Order(User user, Warehouse warehouse){
        this.orderID=new Random(0).nextInt();
        this.user=user;
        this.warehouse=warehouse;
        this.deliveryAddress=user.getAddress();
        this.prodCatIdVsCount=user.getCart().getProductCatIdVsCount();
        this.invoice=new Invoice();
        this.payment=new Payment();
        this.orderStatus=OrderStatus.CREATED;
    }

    public void getCheckout(){
        warehouse.removeItemFromInventory(prodCatIdVsCount);
        this.orderStatus=OrderStatus.TRANSIT;

        PaymentCategory paymentCategory = new PaymentUPI();
        payment=paymentCategory.makePayment(1000);

        boolean isPaymentSuccess=payment.hasPaymentDone();

        if(isPaymentSuccess){
            user.getCart().emptyCart();
            this.orderStatus=OrderStatus.PAYMENT_DONE;
        }else {
            warehouse.addItemToInventory(prodCatIdVsCount);
            this.orderStatus=OrderStatus.PAYMENT_FAILED;
        }

        this.invoice.generateInvoice(payment);
        this.orderStatus=OrderStatus.INVOICE;

    }
}
