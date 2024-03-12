package com.book.verse.ecommercebook.logic;

public class CreditCardStrategy implements PaymentStrategy{
    @Override
    public String pay(double ammount) {
        return "Se realizo el pago de " +  ammount + " Bs. con su tarjeta de crédito";
    }
    @Override
    public String toString(){
        return "Tarjeta De Credito";
    }
}
