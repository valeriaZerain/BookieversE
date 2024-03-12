package com.book.verse.ecommercebook.dao.builder;

import java.math.BigInteger;

public interface BuilderBooks {
    void reset();
    void buildIsbn(BigInteger isbn);
    void buildTitle(String title);
    void buildAuthor(String author);
    void buildPrice(double price);
    void buildDescription(String description);
    void buildStock(int Stock);
    void buildImage(String image);
}
