package com.book.verse.ecommercebook.controller;

import com.book.verse.ecommercebook.logic.PaymentStrategy;
import com.book.verse.ecommercebook.logic.TigoMoneyStrategy;
import com.book.verse.ecommercebook.model.Order;
import com.book.verse.ecommercebook.model.OrderDetail;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PagoTigoMoneyController {
    private Order order;
    private OrderDetail orderDetail;
    private PaymentStrategy paymentStrategy;
    private String idClientEmail;

    @FXML
    private Button verifyButton;

    public PagoTigoMoneyController() {
        paymentStrategy = new TigoMoneyStrategy();
    }
    public Order getOrder() {
        return order;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setIdClientEmail(String idClientEmail) {
        this.idClientEmail = idClientEmail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
        System.out.println("Se recibio la clase " + orderDetail.toString());
    }
}
