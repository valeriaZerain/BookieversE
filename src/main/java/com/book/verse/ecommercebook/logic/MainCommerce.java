package com.book.verse.ecommercebook.logic;

import com.book.verse.ecommercebook.data.SearchBookResponse;

import java.sql.SQLException;

public interface MainCommerce {
    SearchBookResponse listBooks (String criterial) throws SQLException;

    SearchBookResponse getBooks () throws SQLException;

}
