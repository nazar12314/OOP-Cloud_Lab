package org.example.Task2;

import java.sql.SQLException;

public interface Document {
    String parse() throws SQLException;

    String getPath();
}
