package org.example.dao;

import org.example.model.Books;

import java.sql.SQLException;
import java.util.List;

public interface BooksDao {
    List<Books> getBooks()
            throws SQLException;
    List<Books> getBooksByAuthor(String author)
            throws SQLException;

    List<Books> getBooksByText(String textSearch)
            throws SQLException;

}
