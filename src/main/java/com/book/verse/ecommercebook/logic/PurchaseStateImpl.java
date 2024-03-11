package com.book.verse.ecommercebook.logic;

import com.book.verse.ecommercebook.dao.ClientDaoImpl;
import com.book.verse.ecommercebook.data.SearchClientResponse;
import com.book.verse.ecommercebook.model.Client;

import java.lang.ref.Cleaner;
import java.sql.SQLException;

public class PurchaseStateImpl implements PurchaceState{
    @Override
    public SearchClientResponse getClient(String email) throws SQLException {
        SearchClientResponse response = new SearchClientResponse();
        ClientDaoImpl buscador = new ClientDaoImpl();
        Client result = buscador.getClientByEmail(email);
        if(result == null){
            response.setMessage("No se encontraron clientes con ese email");
        }else{
            response.setMessage("Se encontro al cliente correspondiente");
            response.setClient(result);
        }
        return response;
    }
}
