package org.example.testing.payments;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProssesorTest {

    @Test
    public void payment_is_correct(){
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.Ok));
        PaymentProssesor paymentProssesor = new PaymentProssesor(paymentGateway);

        assertTrue(paymentProssesor.makePayment(100));
    }

    @Test
    public void payment_is_wrong(){
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));
        PaymentProssesor paymentProssesor = new PaymentProssesor(paymentGateway);

        assertFalse(paymentProssesor.makePayment(100));
    }

}