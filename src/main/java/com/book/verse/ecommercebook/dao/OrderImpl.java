package com.book.verse.ecommercebook.dao;

import com.book.verse.ecommercebook.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderImpl implements OrderDao{
    static Connection con
            = DatabaseSingleton.getInstance().getConnection();
    @Override
    public void addOrder(Order order) throws SQLException {
        String sql = "INSERT INTO railway.`order` (`Date`,State,Nit,ReceiptName,payment,idClientEmail,paymentState) VALUES (?, ?, ?, ?, ?, ?,?)";
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setDate(1, order.getDate());
        pstm.setString(2, order.getState());
        pstm.setInt(3, order.getNit());
        pstm.setString(4, order.getReceiptName());
        pstm.setString(5, order.getPayment());
        pstm.setString(6, order.getClientEmail());
        pstm.setBoolean(7, order.getPaymentState());

        pstm.executeUpdate();

        System.out.println("Orden annadida correctamente");
    }
}
