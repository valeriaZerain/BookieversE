package com.book.verse.ecommercebook.controller.components;

import com.book.verse.ecommercebook.model.Books;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class BookListViewCell extends ListCell<Books> {
    @FXML
    private TextField titleBook;

    @FXML
    private TextField authorBook;

    @FXML
    private TextField descriptionBook;

    @FXML
    private TextField priceBook;

    @FXML
    private Pane paneCell;

}
