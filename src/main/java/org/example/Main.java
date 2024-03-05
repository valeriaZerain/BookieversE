package org.example;

import org.example.dao.BooksDaoImpl;
import org.example.model.Books;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        BooksDaoImpl bookDao=new BooksDaoImpl();
        System.out.println("Bienvenido al ecommerce de libros: Bookiverse");

        List<Books> listBooks = bookDao.getBooks();
        for (Books book : listBooks) {
            System.out.println(book);
        }

        System.out.println("******************");

        List<Books> listBooksAuthor = bookDao.getBooksByAuthor("Austen");
        for (Books book : listBooksAuthor) {
            System.out.println(book);
        }

        System.out.println("******************");

        List<Books> listBooksText = bookDao.getBooksByText("au");
        for (Books book : listBooksText) {
            System.out.println(book);
        }
    }
}