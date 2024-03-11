package com.book.verse.ecommercebook.controller;

import com.book.verse.ecommercebook.EcommerceApplication;
import com.book.verse.ecommercebook.controller.components.BookListViewCell;
import com.book.verse.ecommercebook.data.SearchBookResponse;
import com.book.verse.ecommercebook.logic.MainCommerceImpl;
import com.book.verse.ecommercebook.model.Books;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class
MainStoreController implements Initializable {
    @FXML
    private TextField txtSearch;
    @FXML
    private ScrollPane rootPane;
    @FXML
    private ListView<Books> listView;
    private ObservableList<Books> booksResultList;
    MainCommerceImpl searchProcess = new MainCommerceImpl();
    public MainStoreController() throws SQLException {
        SearchBookResponse response = searchProcess.getBooks();
        booksResultList = FXCollections.observableArrayList();
        booksResultList.addAll(response.getResultList());
    }


    @FXML
    protected void onSearchButtonClick() throws SQLException {
        listView = new ListView<>();
        SearchBookResponse response = searchProcess.listBooks(txtSearch.getText());
        if (response.getResultList() != null || response.getResultList().size() > 0) {
            booksResultList = FXCollections.observableArrayList();
            booksResultList.addAll(response.getResultList());
            listView.setItems(booksResultList);
            listView.setCellFactory(bookListView -> new BookListViewCell());
            rootPane.setContent(listView);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView = new ListView<>();
        listView.setItems(booksResultList);
        listView.setCellFactory(bookListView -> new BookListViewCell());
        rootPane.setContent(listView);
    }



}
