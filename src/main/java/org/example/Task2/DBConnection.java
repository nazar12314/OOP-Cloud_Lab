package org.example.Task2;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
        System.out.println("Connection established!");
        return dbConnection;
    }

    @SneakyThrows
    public void executePostQuery(String query) {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
    }

    @SneakyThrows
    public List<String> executeGetQuery(String query) {
        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery(query);
        List<String> resultList = new ArrayList<>();

        while(result.next()){
            resultList.add(result.getString("image_data"));
        }

        stmt.close();

        return resultList;
    }
}