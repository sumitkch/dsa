package designPattern.lld.oms;

public class PaymentWallet implements PaymentCategory{
    @Override
    public Payment makePayment(double amount) {
        return new Payment(PaymentMode.WALLET, amount);
    }
}
