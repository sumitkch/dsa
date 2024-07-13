package designPattern.lld.oms;

public class Invoice {

    private double totalPrice;
    private double totalTax;

    private double grossPrice;
    private Payment payment;

    public boolean generateInvoice(Payment payment){
        totalPrice=payment.getTotalAmount();
        totalPrice=(totalPrice*18)/100;
        this.grossPrice=totalPrice-totalTax;
        this.payment=payment;
        return true;
    }
}
