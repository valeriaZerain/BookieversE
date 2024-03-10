package com.book.verse.ecommercebook.model;

import java.sql.Date;

public class Order {
    private int idOrder;
    private java.sql.Date date;
    private String state;
    private int nit;
    private String ReceiptName;
    private String payment;
    private String clientEmail;
    private boolean paymentState;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getReceiptName() {
        return ReceiptName;
    }

    public void setReceiptName(String receiptName) {
        ReceiptName = receiptName;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public boolean getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(boolean paymentState) {
        this.paymentState = paymentState;
    }
}
