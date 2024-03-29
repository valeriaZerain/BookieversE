package com.book.verse.ecommercebook.dao;

import com.book.verse.ecommercebook.dao.builder.BookBuilderBooks;
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
        BookBuilderBooks bookBuilder = new BookBuilderBooks();

        while (rs.next()) {
            bookBuilder.reset();
            bookBuilder.buildIsbn(new BigInteger(String.valueOf(rs.getLong("isbn"))));
            bookBuilder.buildTitle(rs.getString("title"));
            bookBuilder.buildAuthor(rs.getString("author"));
            bookBuilder.buildDescription(rs.getString("description"));
            bookBuilder.buildPrice(rs.getDouble("price"));
            bookBuilder.buildImage(rs.getString("image"));
            bookBuilder.buildStock(rs.getInt("stock"));
            listBooks.add(bookBuilder.getResultBooks());
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
        BookBuilderBooks bookBuilder = new BookBuilderBooks();
        while (rs.next()) {
            bookBuilder.reset();
            bookBuilder.buildIsbn(new BigInteger(String.valueOf(rs.getLong("isbn"))));
            bookBuilder.buildTitle(rs.getString("title"));
            bookBuilder.buildAuthor(rs.getString("author"));
            bookBuilder.buildDescription(rs.getString("description"));
            bookBuilder.buildPrice(rs.getDouble("price"));
            bookBuilder.buildImage(rs.getString("image"));
            bookBuilder.buildStock(rs.getInt("stock"));
            listBooks.add(bookBuilder.getResultBooks());
        }
        return listBooks;
    }
}
