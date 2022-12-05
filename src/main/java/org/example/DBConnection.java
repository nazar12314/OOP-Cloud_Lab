package org.example;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {

    private static DBConnection dbConnection;
    private final Connection connection;

    @SneakyThrows
    private DBConnection() {
        connection = DriverManager.getConnection("jdbc:sqlite:db.sqlite3");
    }

    public static DBConnection getInstance() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    @SneakyThrows
    public void executeQuery(String query) {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
    }
}