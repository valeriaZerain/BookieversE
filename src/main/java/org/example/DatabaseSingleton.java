package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {
    private static DatabaseSingleton instance;
    private Connection connection;
    private DatabaseSingleton(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommercebooks", "root", "Vale123");
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
