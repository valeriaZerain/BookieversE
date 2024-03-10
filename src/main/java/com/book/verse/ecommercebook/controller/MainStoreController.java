package com.book.verse.ecommercebook.controller;

import com.book.verse.ecommercebook.data.SearchBookResponse;
import com.book.verse.ecommercebook.logic.MainCommerceImpl;
import com.book.verse.ecommercebook.model.Books;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class MainStoreController {
    @FXML
    private TextField txtSearch;

    @FXML
    private ScrollPane rootPane;

    @FXML
    private ListView<Books> listView;

    private ObservableList<Books> booksResultList;

    @FXML
    protected void onSearchButtonClick() throws SQLException {
        MainCommerceImpl searchProcess = new MainCommerceImpl();
        SearchBookResponse response = searchProcess.listBooks(txtSearch.getText());
        if (response.getResultList() != null || response.getResultList().size() > 0) {
            booksResultList = FXCollections.observableArrayList();
            for (Books book : response.getResultList()) {
                booksResultList.add(book);
            }
            rootPane.setContent(listView);

            System.out.println(response.toString());
        }
    }

}
