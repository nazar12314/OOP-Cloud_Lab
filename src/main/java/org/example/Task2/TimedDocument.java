package org.example.Task2;

import java.sql.SQLException;

public class TimedDocument implements Document {

    private final Document smartDocument;

    public TimedDocument(Document smartDocument) {
        this.smartDocument = smartDocument;
    }

    @Override
    public String parse() throws SQLException {
        long startTime = System.currentTimeMillis();
        String result = smartDocument.parse();
        long endTime = System.currentTimeMillis();

        System.out.println("Parsing took: " + (endTime - startTime) + " milliseconds\n");

        return result;
    }

    @Override
    public String getPath() {
        return smartDocument.getPath();
    }
}
