package com.book.verse.ecommercebook.controller;

import com.book.verse.ecommercebook.EcommerceApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PantallaPrincipalController {
    @FXML
    private void goToNextScreen(ActionEvent event) throws IOException {
        // Imprime la ubicación del recurso para asegurarte de que se esté cargando correctamente
        System.out.println(EcommerceApplication.class.getResource("PantallaListaLibros.fxml"));

        // Cargar la pantalla siguiente
        Parent nextScreenParent = FXMLLoader.load(EcommerceApplication.class.getResource("PantallaListaLibros.fxml"));
        Scene nextScreenScene = new Scene(nextScreenParent, 550, 550);

        // Obtener la ventana actual
        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

        // Mostrar la pantalla siguiente
        window.setScene(nextScreenScene);
        window.show();
    }
}