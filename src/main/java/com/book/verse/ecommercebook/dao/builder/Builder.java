package com.book.verse.ecommercebook.dao.builder;

import com.book.verse.ecommercebook.model.Books;

import java.math.BigInteger;

public interface Builder {
    void reset();
    void buildIsbn(BigInteger isbn);
    void buildTitle(String title);
    void buildAuthor(String author);
    void buildPrice(double price);
    void buildDescription(String description);
    void buildStock(int Stock);
    void buildImage(String image);
}
