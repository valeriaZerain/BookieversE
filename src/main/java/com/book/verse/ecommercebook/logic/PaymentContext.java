package com.book.verse.ecommercebook.logic;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double ammount){
        paymentStrategy.pay(ammount);
    }
}
