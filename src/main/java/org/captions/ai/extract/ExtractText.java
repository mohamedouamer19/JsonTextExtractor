package org.captions.ai.extract;

public class ExtractText {
    public static void main(String[] args) {
        String jsonFilePath = "src/main/java/org/captions/ai/extract/data/data.json";
        String outputFilePath = "src/main/java/org/captions/ai/extract/data/output.txt";

        TextExtractor textExtractor = new TextExtractor(jsonFilePath, outputFilePath);
        textExtractor.extractText();
    }
}