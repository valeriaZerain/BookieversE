package com.book.verse.ecommercebook.controller;

import com.book.verse.ecommercebook.EcommerceApplication;
import com.book.verse.ecommercebook.dao.ClientDaoImpl;
import com.book.verse.ecommercebook.data.SearchClientResponse;
import com.book.verse.ecommercebook.logic.PurchaceState;
import com.book.verse.ecommercebook.logic.PurchaseStateImpl;
import com.book.verse.ecommercebook.model.Books;
import com.book.verse.ecommercebook.model.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class PantallaComprarController extends ListCell<Books> {

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
    @FXML
    private Button rellenarButton;
    @FXML
    private TextField emailShop;
    @FXML
    private TextField nameShop;
    @FXML
    private TextField addressShop;
    @FXML
    private TextField quantityShop;
    @FXML
    private Label quantityAvailable;
    @FXML
    private Label lblTotalPrice;
    @FXML
    private Button buttonVerify;

    private FXMLLoader fxmlLoader;

    private Pane gridPane;
    private PurchaseStateImpl searchProcess = new PurchaseStateImpl();
    private Client resultClient;
    private Books book;
    public void initBookDetails(Books book) {
        tituloCompra.setText(book.getTitle());
        precioCompra.setText(book.getPrice().toString());
        imagenCompra.setImage(new Image(getClass().getResourceAsStream(book.getImages())));
        this.book = book;
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

    @FXML
    void onRellenarButtonClick()throws SQLException {
        String textSearch = emailShop.getText();
        SearchClientResponse response = searchProcess.getClient(textSearch);
        int stock = book.getStock();
        if(response.getClient()!= null){
            String fullname = response.getClient().getName() + " " + response.getClient().getLastname();
            String address = response.getClient().getAddress();
            nameShop.setText(fullname);
            addressShop.setText(address);
        }
    }
    @FXML
    public void onVerifyButtonClick()throws SQLException{
        int stock = book.getStock();
        int quantity = Integer.parseInt(quantityShop.getText());
        if(stock < quantity){
            quantityAvailable.setText("Solo hay " + stock + " libro(s) disponible(s)");
        }else{
            quantityAvailable.setText("Cantidad de libros disponibles en stock");
            double totalPrice = book.getPrice() * quantity;
            lblTotalPrice.setText(totalPrice + "Bs.");
        }
    }
}
