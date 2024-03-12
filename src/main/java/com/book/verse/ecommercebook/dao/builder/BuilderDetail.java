package com.book.verse.ecommercebook.dao.builder;

import java.math.BigInteger;

public interface BuilderDetail {
    void reset();
    void buildId(int id);
    void buildOrder(int order);
    void buildIsbn(BigInteger isbn);
    void buildQuantity(int quantity);
    void buildTotalPrice(double totalPrice);
    void buildUnitPrice(double unitPrice);
}
