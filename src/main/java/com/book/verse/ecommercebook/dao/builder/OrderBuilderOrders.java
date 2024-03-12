package com.book.verse.ecommercebook.dao.builder;

import com.book.verse.ecommercebook.model.Order;

import java.sql.Date;

public class OrderBuilderOrders implements BuilderOrders{
    private Order order;

    public OrderBuilderOrders() {
        this.reset();
    }

    @Override
    public void reset() {
        this.order = new Order();
    }

    @Override
    public void buildIdOrder(int idOrder) {
        order.setIdOrder(idOrder);
    }

    @Override
    public void buildDate(Date date) {
        order.setDate(date);
    }

    @Override
    public void buildNit(Integer nit) {
        if (nit == null){
            nit = 0;
        }
        order.setNit(nit);
    }

    @Override
    public void buildReceiptName(String receiptName) {
        if(receiptName==null){
            receiptName = "s/n";
        }
        order.setReceiptName(receiptName);
    }

    @Override
    public void buildPaymentMethod(String paymentMethod) {
        order.setPayment(paymentMethod);
    }

    @Override
    public void buildClientEmail(String clientEmail) {
        order.setClientEmail(clientEmail);
    }

    @Override
    public void buildPaymentState(boolean paymentState) {
        order.setPaymentState(paymentState);
    }

    public Order getResultOrder(){
        return order;
    }
}
