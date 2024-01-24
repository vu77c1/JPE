import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonFileExample {
    public static void main(String[] args) {
        // Example data to write to JSON file
        Map<String, String> dataToWrite = new HashMap<>();
        dataToWrite.put("name", "John Doe");
        dataToWrite.put("age", "30");
        dataToWrite.put("city", "Example City");

        // File paths
        String filePathWrite = "example.json";
        String filePathRead = "example.json";

        // Write JSON to file
        writeJsonToFile(dataToWrite, filePathWrite);

        // Read JSON from file
        Map<String, String> dataRead = readJsonFromFile(filePathRead);

        // Display the read data
        System.out.println("Data read from JSON file: " + dataRead);
    }

    private static void writeJsonToFile(Map<String, String> data, String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(filePath), data);
            System.out.println("Data written to JSON file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, String> readJsonFromFile(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(filePath), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>(); // Return an empty map in case of an error
        }
    }
}
