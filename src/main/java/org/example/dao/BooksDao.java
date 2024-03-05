package org.example.dao;

import org.example.model.Books;

import java.sql.SQLException;
import java.util.List;

public interface BooksDao {
    public List<Books> getBooks()
            throws SQLException;
    public List<Books> getBooksByAuthor(String author)
            throws SQLException;

    public List<Books> getBooksByText(String textSearch)
            throws SQLException;

}
