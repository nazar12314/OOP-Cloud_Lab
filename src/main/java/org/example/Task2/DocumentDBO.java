package org.example.Task2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentDBO {

    private String imgLink;
    private String imgData;

    public void save() {
        DBConnection dbConnection = DBConnection.getInstance();

        dbConnection.executePostQuery(
                String.format(
                        "insert into documents (image_link, image_data) values ('%s', '%s');",
                        imgLink,
                        imgData
                )
        );
    }
}
