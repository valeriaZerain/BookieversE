package com.book.verse.ecommercebook.controller.components;

import com.book.verse.ecommercebook.EcommerceApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PagoTarjeta {
    public void pagar(ActionEvent event) throws IOException {
        Parent nextScreenParent = FXMLLoader.load(EcommerceApplication.class.getResource("pantallaestado.fxml"));
        Scene nextScreenScene = new Scene(nextScreenParent, 550, 640);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        window.setScene(nextScreenScene);
        window.show();
    }
}
