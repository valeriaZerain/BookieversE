package com.book.verse.ecommercebook.data;

import com.book.verse.ecommercebook.model.Client;

public class SearchClientResponse extends BasicResponse{
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    @Override
    public String toString() {
        return "SearchClient{" +
                "client=" + client +
                '}';
    }
}
