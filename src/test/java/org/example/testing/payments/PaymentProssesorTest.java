package org.example.testing.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProssesorTest {

    private PaymentGateway paymentGateway;
    private PaymentProssesor paymentProssesor;

    @Before
    public void setup(){
         paymentGateway = Mockito.mock(PaymentGateway.class);
         paymentProssesor = new PaymentProssesor(paymentGateway);
    }
    @Test
    public void payment_is_correct(){
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.Ok));


        assertTrue(paymentProssesor.makePayment(100));
    }

    @Test
    public void payment_is_wrong(){
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        assertFalse(paymentProssesor.makePayment(100));
    }

}