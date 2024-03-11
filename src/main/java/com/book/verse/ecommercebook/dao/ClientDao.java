package com.book.verse.ecommercebook.dao;

import com.book.verse.ecommercebook.model.Client;

import java.sql.SQLException;

public interface ClientDao {
    public Client getClientByEmail(String email) throws SQLException;

}
