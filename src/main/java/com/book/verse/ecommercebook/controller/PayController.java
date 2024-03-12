package com.book.verse.ecommercebook.controller;

import com.book.verse.ecommercebook.EcommerceApplication;
import com.book.verse.ecommercebook.dao.builder.OrderBuilderOrders;
import com.book.verse.ecommercebook.logic.PaymentStrategy;
import com.book.verse.ecommercebook.model.Order;
import com.book.verse.ecommercebook.model.OrderDetail;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class PayController {
    protected PaymentStrategy paymentStrategy;
    protected OrderDetail orderDetail;
    protected Order order;
    protected String idClientEmail;

    @FXML
    private Button payButton;
    @FXML
    private Button nextButton;
    @FXML
    private Label montoTotal;
    @FXML
    private Label lblMessage;
    @FXML
    private TextField textFieldReceipt;
    @FXML
    private TextField textFieldNIT;


    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
        System.out.println(orderDetail.toString());
        montoTotal.setText(Double.toString(orderDetail.getTotalPrice()));
    }

    public Order buildOrder(){
        OrderBuilderOrders builderOrders = new OrderBuilderOrders();

        LocalDate fechaActual = LocalDate.now();
        java.sql.Date fechaSql = java.sql.Date.valueOf(fechaActual);
        builderOrders.buildDate(fechaSql);
        builderOrders.buildReceiptName(textFieldReceipt.getText());
        builderOrders.buildNit(Integer.parseInt(textFieldNIT.getText()));
        builderOrders.buildPaymentMethod(paymentStrategy.toString());
        builderOrders.buildClientEmail(idClientEmail);
        builderOrders.buildPaymentState(true);
        return builderOrders.getResultOrder();
    }

    public void irPantallaFinal(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(EcommerceApplication.class.getResource("pantallaestado.fxml"));
        Parent nextScreenParent = loader.load();
        PantallaFinalController controller = loader.getController();

        controller.setOrderDetail(orderDetail);
        controller.setOrder(order);

        Scene nextScreenScene = new Scene(nextScreenParent, 540, 640);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        window.setScene(nextScreenScene);
        window.show();
        controller.initFields();
    }

    public void setIdClientEmail(String idClientEmail) {
        this.idClientEmail = idClientEmail;
    }
    public void onPayButtonClick(){
        lblMessage.setText(paymentStrategy.pay(orderDetail.getTotalPrice()));
        System.out.println(paymentStrategy.pay(orderDetail.getTotalPrice()));
        order = buildOrder();
        System.out.println(order.toString());
    }
}
