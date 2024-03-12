package com.book.verse.ecommercebook.controller;

import com.book.verse.ecommercebook.logic.PaypalStrategy;
import com.book.verse.ecommercebook.model.Order;
import com.book.verse.ecommercebook.model.OrderDetail;

public class PagoPayPalController extends PayController{
    public PagoPayPalController() {
        paymentStrategy = new PaypalStrategy();
    }
    public Order getOrder() {
        return order;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

}
