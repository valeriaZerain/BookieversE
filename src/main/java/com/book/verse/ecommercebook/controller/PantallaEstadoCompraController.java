package com.book.verse.ecommercebook.controller;

import com.book.verse.ecommercebook.EcommerceApplication;
import com.book.verse.ecommercebook.dao.ClientDaoImpl;
import com.book.verse.ecommercebook.dao.builder.BuilderDetail;
import com.book.verse.ecommercebook.dao.builder.DetailsBuilderDetail;
import com.book.verse.ecommercebook.data.SearchClientResponse;
import com.book.verse.ecommercebook.logic.PaypalStrategy;
import com.book.verse.ecommercebook.logic.PurchaceState;
import com.book.verse.ecommercebook.logic.PurchaseStateImpl;
import com.book.verse.ecommercebook.model.Books;
import com.book.verse.ecommercebook.model.Client;
import com.book.verse.ecommercebook.model.OrderDetail;
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


public class PantallaEstadoCompraController extends ListCell<Books> {

    @FXML
    private Button botonPaypal;
    @FXML
    private Button botonTarjeta;
    @FXML
    private Button botonTigoMoney;
    @FXML
    private Button cancelarCompra;
    @FXML
    private Button rellenarButton;
    @FXML
    private Button buttonVerify;

    @FXML
    private ImageView imagenCompra;

    @FXML
    private Label precioCompra;
    @FXML
    private Label tituloCompra;
    @FXML
    private Label quantityAvailable;
    @FXML
    private Label lblTotalPrice;

    @FXML
    private TextField emailShop;
    @FXML
    private TextField nameShop;
    @FXML
    private TextField addressShop;
    @FXML
    private TextField quantityShop;

    private FXMLLoader fxmlLoader;

    private Pane gridPane;
    private PurchaseStateImpl searchProcess = new PurchaseStateImpl();
    private Books book;
    public void initBookDetails(Books book) {
        tituloCompra.setText(book.getTitle());
        precioCompra.setText(book.getPrice().toString());
        imagenCompra.setImage(new Image(getClass().getResourceAsStream(book.getImages())));
        this.book = book;
    }
    public void disablePaymentButtons(boolean bool){
        botonTarjeta.setDisable(bool);
        botonPaypal.setDisable(bool);
        botonTigoMoney.setDisable(bool);
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
        FXMLLoader loader = new FXMLLoader(EcommerceApplication.class.getResource("pagoTarjeta.fxml"));
        Parent nextScreenParent = loader.load();
        PagoTarjetaController controller = loader.getController();

        Scene nextScreenScene = new Scene(nextScreenParent, 600, 400);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        window.setScene(nextScreenScene);
        window.show();
    }

    @FXML
    void irpantallaTigoMoney(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(EcommerceApplication.class.getResource("pagoTigoMoney.fxml"));
        Parent nextScreenParent = loader.load();
        PagoTigoMoneyController controller = loader.getController();
        controller.setOrderDetail(createOrderDetail());
        controller.setIdClientEmail(emailShop.getText());
        Scene nextScreenScene = new Scene(nextScreenParent, 640, 440);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        window.setScene(nextScreenScene);
        window.show();
    }
    @FXML
    void irPantallaPaypal(ActionEvent event)throws IOException{
        FXMLLoader loader = new FXMLLoader(EcommerceApplication.class.getResource("pagoPayPal.fxml"));
        Parent nextScreenParent = loader.load();
        PagoPayPalController controller = loader.getController();

        Scene nextScreenScene = new Scene(nextScreenParent, 640, 440);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        window.setScene(nextScreenScene);
        window.show();
    }


    @FXML
    void onRellenarButtonClick()throws SQLException {
        String textSearch = emailShop.getText();
        SearchClientResponse response = searchProcess.getClient(textSearch);
        disablePaymentButtons(true);
        if(response.getClient()!= null){
            String fullname = response.getClient().getName() + " " + response.getClient().getLastname();
            String address = response.getClient().getAddress();
            nameShop.setText(fullname);
            addressShop.setText(address);
            disablePaymentButtons(false);
        }
    }
    @FXML
    public void onVerifyButtonClick(){
        int stock = book.getStock();
        int quantity = Integer.parseInt(quantityShop.getText());
        if(stock < quantity){
            quantityAvailable.setText("Solo hay " + stock + " libro(s) disponible(s)");
            disablePaymentButtons(true);
        }else if(quantity <= 0){
            quantityAvailable.setText("Ingresa un valor válido");
            disablePaymentButtons(true);
        }
        else{
            quantityAvailable.setText("Cantidad de libros disponibles en stock");
            double totalPrice = book.getPrice() * quantity;
            lblTotalPrice.setText(totalPrice + "Bs.");
            disablePaymentButtons(false);
        }
    }

    public OrderDetail createOrderDetail(){
        DetailsBuilderDetail builderDetail = new DetailsBuilderDetail();
        builderDetail.reset();
        builderDetail.buildIsbn(book.getIsbn());
        builderDetail.buildQuantity(Integer.parseInt(quantityShop.getText()));
        builderDetail.buildUnitPrice(book.getPrice());
        builderDetail.buildTotalPrice(book.getPrice() * (double)Integer.parseInt(quantityShop.getText()));
        return builderDetail.getResultDetail();
    }
}
