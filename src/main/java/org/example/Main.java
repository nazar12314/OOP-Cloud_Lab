package org.example;

import org.example.decorators.CachedDocument;
import org.example.decorators.TimedDocument;

public class Main {
    public static void main(String[] args) {
        Document document = new SmartDocument("gs://ucu-bucket/Знімок екрана 2022-12-01 о 14.11.41.png");
        document = new TimedDocument(document);
//        document = new CachedDocument(document);
        System.out.println(document.parse());
    }
}
