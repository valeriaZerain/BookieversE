package com.book.verse.ecommercebook.dao;

import com.book.verse.ecommercebook.model.Books;
import com.book.verse.ecommercebook.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao{
    static Connection con
            = DatabaseSingleton.getInstance().getConnection();
    @Override
    public String getAddressByEmail(String email) throws SQLException {
        String query = "select * from client where idClientEmail like '%"+email+"%'";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return rs.getString("address");
    }

    @Override
    public String getFullNameByEmail(String email) throws SQLException{
        String query = "select * from client where idClientEmail like '%"+email+"%'";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return rs.getString("name") + " " + rs.getString("lastname");
    }
}
