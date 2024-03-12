package com.book.verse.ecommercebook.model;

import java.math.BigInteger;

public class OrderDetail {
    private int idDetail;
    private int order;
    private BigInteger isbn;
    private int quantity;
    private double totalPrice;
    private double unitPrice;

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public BigInteger getIsbn() {
        return isbn;
    }

    public void setIsbn(BigInteger isbn) {
        this.isbn = isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    @Override
    public String toString(){
        return "Books{" +
                "idDetail=" + idDetail +
                ", idOrder='" + order + '\'' +
                ", isbn='" + isbn + '\'' +
                ", quantity=" + quantity + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
