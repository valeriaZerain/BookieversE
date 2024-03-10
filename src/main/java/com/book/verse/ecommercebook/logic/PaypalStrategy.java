package com.book.verse.ecommercebook.logic;

public class PaypalStrategy implements PaymentStrategy{
    @Override
    public String pay(double ammount) {
        return "Se realizo el pago de " +  ammount + " Bs. con PayPal";
    }
}
