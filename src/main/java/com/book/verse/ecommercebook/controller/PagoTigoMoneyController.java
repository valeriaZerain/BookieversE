package com.book.verse.ecommercebook.controller;

import com.book.verse.ecommercebook.EcommerceApplication;
import com.book.verse.ecommercebook.dao.builder.OrderBuilderOrders;
import com.book.verse.ecommercebook.logic.PaymentStrategy;
import com.book.verse.ecommercebook.logic.TigoMoneyStrategy;
import com.book.verse.ecommercebook.model.Order;
import com.book.verse.ecommercebook.model.OrderDetail;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class PagoTigoMoneyController extends PayController{

    public PagoTigoMoneyController() {
        paymentStrategy = new TigoMoneyStrategy();
    }
    public Order getOrder() {
        return order;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

}
