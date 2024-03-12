package com.book.verse.ecommercebook.dao;

import com.book.verse.ecommercebook.model.Books;

import java.sql.SQLException;
import java.util.List;

public interface BooksDao {
    public List<Books> getBooks()
            throws SQLException;

    public List<Books> getBooksByText(String textSearch)
            throws SQLException;
}
