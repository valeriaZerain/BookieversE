package com.book.verse.ecommercebook.dao;

import com.book.verse.ecommercebook.model.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailDaoImpl implements OrderDetailDao{
    static Connection con
            = DatabaseSingleton.getInstance().getConnection();
    @Override
    public void addOrderDetail(OrderDetail orderDetail) throws SQLException {
        String sql = "INSERT INTO railway.order_detail (IDOrder,ISBN,Quantity,TotalPrice,UnitPrice) VALUES (?,?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setInt(1, orderDetail.getOrder());
        pstm.setLong(2, orderDetail.getIsbn().longValue());
        pstm.setInt(3, orderDetail.getQuantity());
        pstm.setDouble(4, orderDetail.getTotalPrice());
        pstm.setDouble(5,orderDetail.getUnitPrice());

        pstm.executeUpdate();

        System.out.println("Detalle de orden annadida correctamente");
    }
}
