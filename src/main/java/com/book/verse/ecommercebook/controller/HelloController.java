package com.book.verse.ecommercebook.controller;

import com.book.verse.ecommercebook.data.SearchBookResponse;
import com.book.verse.ecommercebook.logic.MainCommerceImpl;
import com.book.verse.ecommercebook.model.Books;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.sql.SQLException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField criterialText;


    @FXML
    private TableColumn colISBN;

    @FXML
    private BorderPane rootPane;


    @FXML
    protected void onHelloButtonClick() throws SQLException {
        welcomeText.setText(criterialText.getText());
        MainCommerceImpl searchProcess = new MainCommerceImpl();
        SearchBookResponse response = searchProcess.listBooks(criterialText.getText());
        if (response.getResultList() != null || response.getResultList().size() > 0) {
            TableView<Books> table = new TableView<>();

            TableColumn<Books, String> titleColumn = new TableColumn<Books, String>("Titulo");
            titleColumn.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));

            table.getColumns().add(titleColumn);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


            for (Books book : response.getResultList()) {
                table.getItems().add(book);
            }
            rootPane.setCenter(table);

            System.out.println(response.toString());
        }
    }
}