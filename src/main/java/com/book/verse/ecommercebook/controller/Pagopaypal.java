package com.book.verse.ecommercebook.controller;

import com.book.verse.ecommercebook.EcommerceApplication;
import com.book.verse.ecommercebook.model.Books;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Pagopaypal {

    @FXML
    private Button botoncancelarpp;

    @FXML
    private Button botonpagopp;

    @FXML
    private Label montopagopp;

    @FXML
    private TextField quantityShop;

    @FXML
    void iraestadodecompra(ActionEvent event) {

    }

//    PantallaEstadoCompraController pantallaEstadoCompraController = new PantallaEstadoCompraController();

    public void initMonto (double totalPrice) {
                montopagopp.setText(totalPrice + "");

    }
    @FXML
    void cancelarpaypal(ActionEvent event) throws IOException {

        Parent nextScreenParent = FXMLLoader.load(EcommerceApplication.class.getResource("pantallacomprar.fxml"));
        Scene nextScreenScene = new Scene(nextScreenParent, 940, 640);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        window.setScene(nextScreenScene);
        window.show();

    }

}
