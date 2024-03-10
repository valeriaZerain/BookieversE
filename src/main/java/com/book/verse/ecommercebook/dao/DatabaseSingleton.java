package com.book.verse.ecommercebook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {
    private static DatabaseSingleton instance;
    private Connection connection;
    private DatabaseSingleton(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://viaduct.proxy.rlwy.net:11657/railway", "root", "DgEBaCa-EEgbB4HB6ce56fF6B3AeF-c2");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static synchronized DatabaseSingleton getInstance(){
        if(instance == null){
            instance = new DatabaseSingleton();
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }
}
