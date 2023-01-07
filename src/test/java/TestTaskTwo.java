import org.example.Task2.CachedDocument;
import org.example.Task2.Document;
import org.example.Task2.SmartDocument;
import org.example.Task2.TimedDocument;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class TestTaskTwo {

    @Test
    public void testCachedDecorator() throws SQLException {
        Document document = new SmartDocument(
                "gs://ucu-bucket/Знімок екрана 2022-12-01 о 14.11.41.png"
        );
        document = new CachedDocument(document);

        Assertions.assertEquals(
                document.parse(),
                "package org.example;\n"
                        +
                        "import java.util.*;\n"
                        +
                        "public class Main {\n"
                        +
                        "public static void main(String[] args) {\n"
                        +
                        "List<List<Integer>> nums = "
                        +
                        "new ArrayList<>(List.of(List.of(1, 2), List.of(1, 1), List.of(4, 3)));\n"
                        +
                        "}\n"
                        +
                        "}\n"
                        +
                        "nums.sort (Comparator.comparing Int (o -> o.get(1)));\n"
                        +
                        "System.out.println(nums);"
                );
    }

    @Test
    public void testTimedDecorator() throws SQLException {
        Document document = new SmartDocument(
                "gs://ucu-bucket/Знімок екрана 2022-12-01 о 14.11.41.png"
        );
        document = new TimedDocument(document);

        Assertions.assertEquals(
                document.parse(),
                "package org.example;\n"
                        +
                        "import java.util.*;\n"
                        +
                        "public class Main {\n"
                        +
                        "public static void main(String[] args) {\n"
                        +
                        "List<List<Integer>> nums = "
                        +
                        "new ArrayList<>(List.of(List.of(1, 2), List.of(1, 1), List.of(4, 3)));\n"
                        +
                        "}\n"
                        +
                        "}\n"
                        +
                        "nums.sort (Comparator.comparing Int (o -> o.get(1)));\n"
                        +
                        "System.out.println(nums);"
        );
    }
}