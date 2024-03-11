package com.book.verse.ecommercebook.controller;

import com.book.verse.ecommercebook.EcommerceApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Pagotigo {

    @FXML
    private Label montotm;

    @FXML
    private Button botoncancelartm;

    public void initMontotigomoney (double totalPrice) {
        montotm.setText(totalPrice + "");

    }

    @FXML
    void cancelarpagotigomoney(ActionEvent event) throws IOException {

        Parent nextScreenParent = FXMLLoader.load(EcommerceApplication.class.getResource("pantallacomprar.fxml"));
        Scene nextScreenScene = new Scene(nextScreenParent, 940, 640);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        window.setScene(nextScreenScene);
        window.show();

    }

}