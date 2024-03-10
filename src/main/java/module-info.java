module com.book.verse.ecommercebook {
    requires javafx.controls;
    requires javafx.fxml;

//    requires org.controlsfx.controls;
//    requires com.dlsc.formsfx;
//    requires org.kordamp.ikonli.javafx;
//    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.book.verse.ecommercebook to javafx.fxml;
    exports com.book.verse.ecommercebook;
    exports com.book.verse.ecommercebook.controller;
    opens com.book.verse.ecommercebook.controller to javafx.fxml;
}