package org.example.testing.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}
