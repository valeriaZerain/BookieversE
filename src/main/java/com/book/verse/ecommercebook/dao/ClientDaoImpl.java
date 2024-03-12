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
    public Client getClientByEmail(String email) throws SQLException {
        String query = "select * from client where idClientEmail like ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, "%" + email + "%");
        ResultSet rs = ps.executeQuery();

        Client client = null;

        if (rs.next()) { // Verificar si hay al menos un resultado
            client = new Client();
            client.setIdEmail(rs.getString("idClientEmail"));
            client.setName(rs.getString("name"));
            client.setLastname(rs.getString("lastname"));
            client.setAddress(rs.getString("address"));
        }

        rs.close(); // Cerrar ResultSet
        ps.close(); // Cerrar PreparedStatement

        return client;
    }
}
