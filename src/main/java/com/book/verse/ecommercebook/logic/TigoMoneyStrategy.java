package com.book.verse.ecommercebook.logic;

import java.nio.file.Path;

public class TigoMoneyStrategy implements PaymentStrategy {
    @Override
    public String pay(double ammount) {
        return "Se realizo el pago de " +  ammount + " Bs. con Tigo Money";
    }
}
