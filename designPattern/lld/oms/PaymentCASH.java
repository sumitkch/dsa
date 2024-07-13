package designPattern.lld.oms;

public class PaymentCASH implements PaymentCategory{
    @Override
    public Payment makePayment(double amount) {
        return new Payment(PaymentMode.CASH, amount);
    }
}
