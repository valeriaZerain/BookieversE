package com.book.verse.ecommercebook.controller;

import com.book.verse.ecommercebook.EcommerceApplication;
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

public class PantallaFinalController {
    @FXML
    private Label lblIdOrder;
    @FXML
    private Label lblClient;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblReceiptName;
    @FXML
    private Label lblNit;
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
    public void initFields(){

    }


    public void irAlMenu(ActionEvent event) throws IOException {
        Parent nextScreenParent = FXMLLoader.load(EcommerceApplication.class.getResource("main-store.fxml"));
        Scene nextScreenScene = new Scene(nextScreenParent, 940, 640);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        window.setScene(nextScreenScene);
        window.show();
    }
}
