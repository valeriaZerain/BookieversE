package com.book.verse.ecommercebook.logic;

import com.book.verse.ecommercebook.dao.BooksDaoImpl;
import com.book.verse.ecommercebook.data.SearchBookResponse;
import com.book.verse.ecommercebook.model.Books;

import java.sql.SQLException;
import java.util.List;

public class MainCommerceImpl implements MainCommerce {
    @Override
    public SearchBookResponse listBooks(String criterial) throws SQLException {
        SearchBookResponse response = new SearchBookResponse();
        BooksDaoImpl buscador = new BooksDaoImpl();
        List<Books> result = buscador.getBooksByText(criterial);
        if (result == null ||result.isEmpty()) {
            response.setMessage("No se encontraron libros con su criterio");

        } else {
            response.setMessage(String.format("Se encontraron %d libros",result.size()));
            response.setResultList(result);
        }
        return response;
    }
}
