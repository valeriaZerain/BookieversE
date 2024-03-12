package com.book.verse.ecommercebook.model;

import java.sql.Date;

public class Order {
    private int idOrder;
    private java.sql.Date date;
    private int nit;
    private String receiptName;
    private String paymentMethod;
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

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getReceiptName() {
        return receiptName;
    }

    public void setReceiptName(String receiptName) {
        this.receiptName = receiptName;
    }

    public String getPayment() {
        return paymentMethod;
    }

    public void setPayment(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", date='" + date + '\'' +
                ", nit='" + nit + '\'' +
                ", receiptName=" + receiptName +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", idClientEmail=" + clientEmail +
                ", paymentState='" + paymentState + '\'' +
                '}';
    }
}
