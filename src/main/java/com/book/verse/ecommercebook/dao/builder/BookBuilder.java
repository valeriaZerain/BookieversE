package com.book.verse.ecommercebook.dao.builder;

import com.book.verse.ecommercebook.model.Books;

import java.math.BigInteger;

public class BookBuilder implements Builder{
    private Books books;
    public BookBuilder(){
        this.reset();
    }

    @Override
    public void reset() {
        this.books = new Books();
    }

    @Override
    public void buildIsbn(BigInteger isbn) {
        books.setIsbn(isbn);
    }

    @Override
    public void buildTitle(String title) {
        books.setTitle(title);
    }

    @Override
    public void buildAuthor(String author) {
        books.setAuthor(author);
    }

    @Override
    public void buildPrice(double price) {
        books.setPrice(price);
    }

    @Override
    public void buildDescription(String description) {
        books.setDescription(description);
    }

    @Override
    public void buildStock(int stock) {
        books.setStock(stock);

    }

    @Override
    public void buildImage(String image) {
        books.setImages(image);
    }
    public Books getResultBooks(){
        return books;
    }
}
