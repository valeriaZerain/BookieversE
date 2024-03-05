package org.example.dao;

import org.example.DatabaseSingleton;
import org.example.model.Books;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksDaoImpl implements BooksDao {

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
            listBooks.add(book);
        }
        return listBooks;
    }

    @Override
    public List<Books> getBooksByAuthor(String author) throws SQLException {
        String query = "select * from books where author like '%"+author+"%'";
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

            listBooks.add(book);
        }
        return listBooks;
    }
}
