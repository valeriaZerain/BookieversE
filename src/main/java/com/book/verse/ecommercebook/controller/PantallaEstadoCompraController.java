package com.book.verse.ecommercebook.controller;

import com.book.verse.ecommercebook.EcommerceApplication;
import com.book.verse.ecommercebook.model.Books;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class PantallaEstadoCompraController extends ListCell<Books> {

    @FXML
    private ImageView imagenCompra;

    @FXML
    private Label precioCompra;

    @FXML
    private Label tituloCompra;

    private FXMLLoader fxmlLoader;

    private Pane gridPane;

    @Override
    protected void updateItem(Books book, boolean empty) {
        super.updateItem(book, empty);

        if(empty || book == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (fxmlLoader == null) {
                fxmlLoader = new FXMLLoader(EcommerceApplication.class.getResource("PantallaEstadoCompra.fxml"));
                fxmlLoader.setController(this);
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            tituloCompra.setText(book.getTitle());
            precioCompra.setText(book.getPrice().toString());
            imagenCompra.setImage(new Image(getClass().getResourceAsStream(book.getImages())));
            setText(null);
            setGraphic(gridPane);
        }

    }


}
