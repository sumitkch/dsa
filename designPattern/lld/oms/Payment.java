package designPattern.lld.oms;

import java.util.Random;

public class Payment {
    private int paymentID;
    private PaymentMode paymentMode;
    private double totalAmount;

    public Payment(){
        this.paymentID=new Random(0).nextInt();
        this.paymentMode=PaymentMode.CASH;
        this.totalAmount=0;
    }

    public Payment(PaymentMode paymentMode, double totalAmount){
        this.paymentID=new Random(0).nextInt();
        this.paymentMode=paymentMode;
        this.totalAmount=totalAmount;
    }

    public boolean hasPaymentDone(){
        return true;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
