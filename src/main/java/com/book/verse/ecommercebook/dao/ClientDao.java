package com.book.verse.ecommercebook.dao;

import com.book.verse.ecommercebook.model.Client;

import java.sql.SQLException;

public interface ClientDao {
    public String getAddressByEmail(String email) throws SQLException;
    public String getFullNameByEmail(String email) throws SQLException;
}
