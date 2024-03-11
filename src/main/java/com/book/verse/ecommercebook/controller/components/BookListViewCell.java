package com.book.verse.ecommercebook.controller.components;

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

public class BookListViewCell extends ListCell<Books> {
    @FXML
    private Label lblTitulo;

    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblPrice;

    @FXML
    private ImageView imageBook;

    private FXMLLoader mLLoader;

    @FXML
    private Pane gridPane;

    @Override
    protected void updateItem(Books book, boolean empty) {
        super.updateItem(book, empty);

        if(empty || book == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(EcommerceApplication.class.getResource("list-cell.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            lblTitulo.setText(book.getTitle());
            lblAuthor.setText(book.getAuthor());
            lblDescription.setText(book.getDescription());
            lblPrice.setText(book.getPrice().toString());
            imageBook.setImage(new Image(getClass().getResourceAsStream(book.getImages())));
            setText(null);
            setGraphic(gridPane);
        }

    }

}
