package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DatasetReader {
    public static String readFromResource(String fileName) throws IOException {
        try (var inputStream = DatasetReader.class.getResourceAsStream("/" + fileName)) {
            if (inputStream == null) {
                throw new IOException("Resource not found: " + fileName);
            }
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}
