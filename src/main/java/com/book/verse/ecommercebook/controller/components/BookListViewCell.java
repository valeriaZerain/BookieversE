package com.book.verse.ecommercebook.controller.components;

import com.book.verse.ecommercebook.EcommerceApplication;
import com.book.verse.ecommercebook.controller.PantallaComprarController;
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

    @FXML
    private Button shopButton;

    @FXML
    void irPantallaCompra(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(EcommerceApplication.class.getResource("pantallacomprar.fxml"));
        Parent nextScreenParent = loader.load();
        PantallaComprarController controller = loader.getController();

        // Obtener el libro actual de la celda de la lista
        Books selectedBook = getItem();

        // Inicializar los detalles del libro en la pantalla de estado de compra
        controller.initBookDetails(selectedBook);

        Scene nextScreenScene = new Scene(nextScreenParent, 940, 640);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        window.setScene(nextScreenScene);
        window.show();
    }

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