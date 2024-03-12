package com.book.verse.ecommercebook.dao.builder;

import com.book.verse.ecommercebook.model.OrderDetail;

import java.math.BigInteger;

public class DetailsBuilderDetail implements BuilderDetail{
    private OrderDetail detail;

    public DetailsBuilderDetail(){
        this.reset();
    }


    @Override
    public void reset() {
        this.detail = new OrderDetail();
    }

    @Override
    public void buildId(int id) {
        detail.setIdDetail(id);
    }

    @Override
    public void buildOrder(int order) {
        detail.setOrder(order);
    }

    @Override
    public void buildIsbn(BigInteger isbn) {
        detail.setIsbn(isbn);
    }

    @Override
    public void buildQuantity(int quantity) {
        detail.setQuantity(quantity);
    }

    @Override
    public void buildTotalPrice(double totalPrice) {
        detail.setTotalPrice(totalPrice);
    }

    @Override
    public void buildUnitPrice(double unitPrice) {
        detail.setUnitPrice(unitPrice);
    }

    public OrderDetail getResultDetail(){
        return detail;
    }
}
