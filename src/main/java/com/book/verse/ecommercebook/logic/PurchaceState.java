package com.book.verse.ecommercebook.logic;

import com.book.verse.ecommercebook.data.SearchClientResponse;

import java.sql.SQLException;

public interface PurchaceState {
    SearchClientResponse getClient(String email)throws SQLException;
}
