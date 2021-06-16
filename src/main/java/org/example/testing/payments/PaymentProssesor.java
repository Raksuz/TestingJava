package org.example.testing.payments;

public class PaymentProssesor {

    private PaymentGateway paymentGateway;

    public PaymentProssesor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount){
        PaymentResponse response = paymentGateway.requestPayment(new PaymentRequest(amount));
        if(response.getStatus() == PaymentResponse.PaymentStatus.Ok){
            return true;
        } else {
            return false;
        }
    }
}
