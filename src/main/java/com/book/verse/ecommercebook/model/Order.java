package com.book.verse.ecommercebook.model;

public class Order {
    private int order;
    private int client;
    private String date;
    private int CIReceipt;
    private String ReceiptName;

    public void setOrder(int order) {
        this.order = order;
    }
    public int getOrder() {
        return order;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public int getClient() {
        return client;
    }
}
