package com.book.verse.ecommercebook.dao;
import com.book.verse.ecommercebook.model.Order;

import java.sql.SQLException;

public interface OrderDao {
    void addOrder(Order order) throws SQLException;
}
