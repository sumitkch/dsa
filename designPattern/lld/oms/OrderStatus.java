package designPattern.lld.oms;

public enum OrderStatus {
    CREATED(1, "CREATED"),
    TRANSIT(2, "TRANSIT"),
    INVOICE(3, "INVOICE"),
    DELIVERING(4, "DELIVERING"),
    DELIVERED(5, "DELIVERED"),
    CANCELLED(6, "CANCELLED"),
    UNDELIVERED(7, "UNDELIVERED"),
    PAYMENT_FAILED(8, "PAYMENT_FAILED"),
    PAYMENT_DONE(9, "PAYMENT_DONE");


    private int orderStatusID;
    private String orderStatusName;


    OrderStatus(int orderStatusID, String orderStatusName) {
        this.orderStatusID=orderStatusID;
        this.orderStatusName=orderStatusName;
    }
}
