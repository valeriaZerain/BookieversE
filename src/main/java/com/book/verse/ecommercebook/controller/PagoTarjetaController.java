package com.book.verse.ecommercebook.controller;

import com.book.verse.ecommercebook.logic.CreditCardStrategy;
import com.book.verse.ecommercebook.logic.TigoMoneyStrategy;
import com.book.verse.ecommercebook.model.Order;
import com.book.verse.ecommercebook.model.OrderDetail;

public class PagoTarjetaController extends  PayController{
    public PagoTarjetaController() {
        paymentStrategy = new CreditCardStrategy();
    }
    public Order getOrder() {
        return order;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }
}
