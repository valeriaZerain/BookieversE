package com.book.verse.ecommercebook.data;

import com.book.verse.ecommercebook.model.Order;

public class SearchOrderResponse extends BasicResponse{
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    @Override
    public String toString() {
        return "SearchOrderResponse{" +
                "order=" + order +
                '}';
    }
}
