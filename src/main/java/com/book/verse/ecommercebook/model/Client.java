package com.book.verse.ecommercebook.model;

public class Client {
    private int id;
    private String name;
    private String lastname;
    private String address;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public String getLastname() {
        return lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
}
