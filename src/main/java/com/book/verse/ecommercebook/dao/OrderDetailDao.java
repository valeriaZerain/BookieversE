package com.book.verse.ecommercebook.dao;

import com.book.verse.ecommercebook.model.OrderDetail;

import java.sql.SQLException;

public interface OrderDetailDao {
    void addOrderDetail(OrderDetail orderDetail)throws SQLException;
}
