package org.example.decorators;

import org.example.Document;

public class CachedDocument implements Document {

    private final Document document;

    public CachedDocument(Document document) {
        this.document = document;
    }

    @Override
    public String parse() {
        return null;
    }
}
