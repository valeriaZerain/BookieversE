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
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


public class PantallaEstadoCompraController extends ListCell<Books> {

    @FXML
    private Button botonqr;

    @FXML
    private Button botonTarjeta;

    @FXML
    private Button cancelarCompra;

    @FXML
    private ImageView imagenCompra;

    @FXML
    private Label precioCompra;

    @FXML
    private Label tituloCompra;

    private FXMLLoader fxmlLoader;

    private Pane gridPane;

    public void initBookDetails(Books book) {
        tituloCompra.setText(book.getTitle());
        precioCompra.setText(book.getPrice().toString());
        imagenCompra.setImage(new Image(getClass().getResourceAsStream(book.getImages())));

    }

    @FXML
    void volverLista(ActionEvent event) throws IOException {

        Parent nextScreenParent = FXMLLoader.load(EcommerceApplication.class.getResource("main-store.fxml"));
        Scene nextScreenScene = new Scene(nextScreenParent, 940, 640);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        window.setScene(nextScreenScene);
        window.show();

    }

    @FXML
    void IrPagoTarjeta(ActionEvent event) throws IOException {

        Parent nextScreenParent = FXMLLoader.load(EcommerceApplication.class.getResource("pagoTarjeta.fxml"));
        Scene nextScreenScene = new Scene(nextScreenParent, 940, 640);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        window.setScene(nextScreenScene);
        window.show();

    }

    @FXML
    void irpantallaqr(ActionEvent event) throws IOException {

        Parent nextScreenParent = FXMLLoader.load(EcommerceApplication.class.getResource("pagoqr.fxml"));
        Scene nextScreenScene = new Scene(nextScreenParent, 940, 640);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        window.setScene(nextScreenScene);
        window.show();

    }

}
