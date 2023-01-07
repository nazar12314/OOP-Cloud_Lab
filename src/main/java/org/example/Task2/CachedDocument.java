package org.example.Task2;

import java.sql.SQLException;
import java.util.List;

public class CachedDocument implements Document {

    private final Document document;

    public CachedDocument(Document document) {
        this.document = document;
    }

    @Override
    public String parse() throws SQLException {
        String query = String.format(
                "SELECT image_data FROM documents WHERE image_link = '%s'",
                document.getPath()
        );
        DBConnection dbConnection = DBConnection.getInstance();
        List<String> result = dbConnection.executeGetQuery(query);

        if (result.isEmpty()) {
            String data = document.parse();
            dbConnection.executePostQuery(
                    String.format(
                            "insert into documents (image_link, image_data) values ('%s', '%s');",
                            document.getPath(),
                            data
                    )
            );

            return data;
        } else {
            return result.get(0);
        }
    }

    @Override
    public String getPath() {
        return document.getPath();
    }
}
