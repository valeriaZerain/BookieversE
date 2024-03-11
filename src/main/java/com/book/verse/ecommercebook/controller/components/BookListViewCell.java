package com.book.verse.ecommercebook.controller.components;

import com.book.verse.ecommercebook.EcommerceApplication;
import com.book.verse.ecommercebook.model.Books;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class BookListViewCell extends ListCell<Books> {
    @FXML
    private TextField titleBook;

    @FXML
    private TextField authorBook;

    @FXML
    private TextField descriptionBook;

    @FXML
    private TextField priceBook;

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

            titleBook.setText(book.getTitle());
            authorBook.setText(book.getAuthor());

            setText(null);
            setGraphic(gridPane);
        }

    }

}
