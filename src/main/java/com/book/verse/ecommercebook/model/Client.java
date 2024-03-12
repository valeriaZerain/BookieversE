package com.book.verse.ecommercebook.model;

public class Client {
    private String idEmail;
    private String name;
    private String lastname;
    private String address;

    public String getIdEmail() {
        return this.idEmail;
    }
    public void setIdEmail(String idEmail) {
        this.idEmail = idEmail;
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

    @Override
    public String toString(){
        return "Client{" +
                "idClientEmail=" + idEmail +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address=" + address +
                '}';
    }
}
