package org.captions.ai.extract;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TextExtractor {
    private String jsonFilePath;
    private String outputFilePath;

    public TextExtractor(String jsonFilePath, String outputFilePath) {
        this.jsonFilePath = jsonFilePath;
        this.outputFilePath = outputFilePath;
    }

    public void extractText() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            JSONArray jsonArray = new JSONArray(content);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String text = jsonObject.getString("text");
                Files.write(Paths.get(outputFilePath), (text + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }

            System.out.println("Extraction completed successfully. Check the output.txt file.");

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file or writing to the file.");
            e.printStackTrace();
        }
    }
}