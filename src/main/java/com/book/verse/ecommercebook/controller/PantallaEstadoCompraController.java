package com.book.verse.ecommercebook.controller;

import com.book.verse.ecommercebook.model.Books;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PantallaEstadoCompraController {

    @FXML
    private ImageView imagenCompra;

    @FXML
    private Label precioCompra;

    @FXML
    private Label tituloCompra;

    public void initBookDetails(Books book) {
        tituloCompra.setText(book.getTitle());
        precioCompra.setText(book.getPrice().toString());
        imagenCompra.setImage(new Image(getClass().getResourceAsStream(book.getImages())));

    }
}
