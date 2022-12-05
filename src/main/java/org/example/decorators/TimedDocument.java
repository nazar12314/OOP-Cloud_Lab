package org.example.decorators;

import org.example.Document;

public class TimedDocument implements Document {

    private final Document smartDocument;

    public TimedDocument(Document smartDocument) {
        this.smartDocument = smartDocument;
    }

    @Override
    public String parse() {
        long startTime = System.currentTimeMillis();
        String result = smartDocument.parse();
        long endTime = System.currentTimeMillis();

        System.out.println("Parsing took: " + (endTime - startTime) + " milliseconds\n");

        return result;
    }
}
