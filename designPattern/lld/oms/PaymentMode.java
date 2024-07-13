package designPattern.lld.oms;

public enum PaymentMode {
    CASH(1,"CASH"),
    CREDIT_CARD(2,"CREDIT_CARD"),
    DEBIT_CARD(3, "DEBIT_CARD"),
    UPI(4, "UPI"),
    WALLET(5, "WALLET");

    private int paymentModeID;
    private String paymentModeName;

    PaymentMode(int paymentModeID, String paymentModeName) {
        this.paymentModeID=paymentModeID;
        this.paymentModeName=paymentModeName;
    }
}
