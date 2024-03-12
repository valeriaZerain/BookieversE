package com.book.verse.ecommercebook.controller;

import com.book.verse.ecommercebook.EcommerceApplication;
import com.book.verse.ecommercebook.dao.BooksDao;
import com.book.verse.ecommercebook.dao.BooksDaoImpl;
import com.book.verse.ecommercebook.dao.OrderDaoImpl;
import com.book.verse.ecommercebook.dao.OrderDetailDaoImpl;
import com.book.verse.ecommercebook.model.Order;
import com.book.verse.ecommercebook.model.OrderDetail;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class PantallaFinalController {
    @FXML
    private Label lblIdBook;
    @FXML
    private Label lblQuantity;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblReceiptName;
    @FXML
    private Label lblNit;
    @FXML
    private Label lblTotalPayed;
    @FXML
    private Label lblPaymentMethod;

    private Order order;
    private OrderDetail orderDetail;


    public void setOrder(Order order) {
        this.order = order;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public void initFields() throws SQLException {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        OrderDetailDaoImpl orderDetailDao = new OrderDetailDaoImpl();
        lblIdBook.setText(orderDetail.getIsbn().toString());
        lblQuantity.setText(String.valueOf(orderDetail.getQuantity()));
        lblDate.setText(order.getDate().toString());
        lblReceiptName.setText(order.getReceiptName());
        lblNit.setText(String.valueOf(order.getNit()));
        lblTotalPayed.setText(String.valueOf(orderDetail.getTotalPrice()));
        lblPaymentMethod.setText(order.getPayment());
        System.out.println(order.toString() + orderDetail.toString());
        orderDao.addOrder(order);
        orderDetailDao.addOrderDetail(orderDetail);
    }

    public void irAlMenu(ActionEvent event) throws IOException {
        Parent nextScreenParent = FXMLLoader.load(EcommerceApplication.class.getResource("main-store.fxml"));
        Scene nextScreenScene = new Scene(nextScreenParent, 940, 640);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        window.setScene(nextScreenScene);
        window.show();
    }
}

