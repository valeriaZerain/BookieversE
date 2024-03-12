package com.book.verse.ecommercebook.dao.builder;

import java.sql.Date;

public interface BuilderOrders {
    void reset();
    void buildIdOrder(int idOrder);
    void buildDate(java.sql.Date date);
    void buildNit(Integer nit);
    void buildReceiptName(String receiptName);
    void buildPaymentMethod(String paymentMethod);
    void buildClientEmail(String clientEmail);
    void buildPaymentState(boolean paymentState);
}
