package com.book.verse.ecommercebook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EcommerceApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EcommerceApplication.class.getResource("pantalla-principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 550, 550);
        stage.setTitle("Eccomerce de Libros");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
