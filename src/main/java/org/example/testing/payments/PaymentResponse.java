package org.example.testing.payments;

public class PaymentResponse {

    enum PaymentStatus{
        Ok, ERROR
    }
    private PaymentStatus status;

    public PaymentResponse(PaymentStatus status) {
        this.status = status;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
