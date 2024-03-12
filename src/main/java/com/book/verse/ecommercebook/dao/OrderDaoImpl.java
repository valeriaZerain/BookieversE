package com.book.verse.ecommercebook.dao;

import com.book.verse.ecommercebook.dao.builder.OrderBuilderOrders;
import com.book.verse.ecommercebook.model.Client;
import com.book.verse.ecommercebook.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao{
    static Connection con
            = DatabaseSingleton.getInstance().getConnection();
    @Override
    public void addOrder(Order order) throws SQLException {
        String sql = "INSERT INTO railway.`order` (`Date`, Nit, ReceiptName, paymentMethod, idClientEmail, paymentState) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setDate(1, order.getDate());
        pstm.setInt(2, order.getNit());
        pstm.setString(3, order.getReceiptName());
        pstm.setString(4, order.getPayment());
        pstm.setString(5, order.getClientEmail());
        pstm.setBoolean(6, order.getPaymentState());

        pstm.executeUpdate();

        System.out.println("Orden añadida correctamente");
    }


    public Order getOrderById(int id) throws SQLException {
        String query = "select * from order where idOrder like ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, "%" + id + "%");
        ResultSet rs = ps.executeQuery();
        OrderBuilderOrders orders = new OrderBuilderOrders();
        if (rs.next()) { // Verificar si hay al menos un resultado
            orders.reset();
            orders.buildIdOrder(rs.getInt("idOrder"));
            orders.buildDate(rs.getDate("date"));
            orders.buildNit(rs.getInt("nit"));
            orders.buildReceiptName(rs.getString("receiptName"));
            orders.buildPaymentMethod(rs.getString("paymentMethod"));
            orders.buildClientEmail(rs.getString("idClientEmail"));
            orders.buildPaymentState(rs.getBoolean("paymentState"));
        }
        rs.close();
        ps.close();
        return orders.getResultOrder();
    }
}
