package com.book.verse.ecommercebook.dao;

import com.book.verse.ecommercebook.model.Books;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksDaoImpl implements BooksDao{
    static Connection con
            = DatabaseSingleton.getInstance().getConnection();

    @Override
    public List<Books> getBooks() throws SQLException {
        String query = "select * from books";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Books> listBooks = new ArrayList();

        while (rs.next()) {
            Books book = new Books();
            book.setIsbn(new BigInteger(String.valueOf(rs.getLong("isbn"))));
            book.setAuthor(rs.getString("author"));
            book.setPrice(rs.getDouble("price"));
            book.setTitle(rs.getString("title"));
            book.setDescription(rs.getString("description"));
            book.setImages(rs.getString("image"));
            book.setStock(rs.getInt("stock"));
            listBooks.add(book);
        }
        return listBooks;
    }

    @Override
    public List<Books> getBooksByText(String textSearch) throws SQLException {
        String query = "select * from books where author like '%"+textSearch+"%' or title like '%"+textSearch+"%'";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Books> listBooks = new ArrayList();

        while (rs.next()) {
            Books book = new Books();
            book.setIsbn(new BigInteger(String.valueOf(rs.getLong("isbn"))));
            book.setAuthor(rs.getString("author"));
            book.setPrice(rs.getDouble("price"));
            book.setTitle(rs.getString("title"));
            book.setDescription(rs.getString("description"));
            book.setImages(rs.getString("image"));
            book.setStock(rs.getInt("stock"));
            listBooks.add(book);
        }
        return listBooks;
    }
}
