package com.book.verse.ecommercebook.dao;

import com.book.verse.ecommercebook.dao.builder.DetailsBuilderDetail;
import com.book.verse.ecommercebook.model.OrderDetail;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    @Override
    public OrderDetail getOrderDetailById(int id) throws SQLException {
        String query = "select * from order_detail where idDetail like ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, "%" + id + "%");
        ResultSet rs = ps.executeQuery();
        DetailsBuilderDetail details = new DetailsBuilderDetail();
        if (rs.next()) {
            details.reset();
            details.buildId(rs.getInt("idDetail"));
            details.buildOrder(rs.getInt("idOrder"));
            details.buildIsbn(new BigInteger(String.valueOf(rs.getLong("isbn"))));
            details.buildQuantity(rs.getInt("quantity"));
            details.buildTotalPrice(rs.getDouble("totalPrice"));
            details.buildUnitPrice(rs.getDouble("unitPrice"));
        }
        return details.getResultDetail();
    }
}
