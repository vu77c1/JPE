package JPL.L.A201;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonFile {

    public static void writeJsonToFile(Map<String, Airplane> newData, String filePath) {

            try {
                // Read existing data from the file
                Map<String, Airplane> existingData = readJsonFromFile(filePath);

                // Merge the new data with the existing data
                existingData.putAll(newData);

                // Write the merged data back to the file
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(new File(filePath), existingData);
                System.out.println("Data written to JSON file successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }


    }
    public static Map<String, Airplane> readJsonFromFile(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Read existing data from the file
            Map<String, Airplane> existingData = objectMapper.readValue(new File(filePath), Map.class);
            return existingData;
        } catch (IOException e) {
//            e.printStackTrace();
            return new HashMap<>(); // Return an empty map in case of an error
        }
    }
    public static void writeJsonToFileAirport(Map<String, Airport> newData, String filePath) {

        try {
            // Read existing data from the file
            Map<String, Airport> existingData = readJsonFromFileAirport(filePath);

            // Merge the new data with the existing data
            existingData.putAll(newData);

            // Write the merged data back to the file
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(filePath), existingData);
            System.out.println("Data written to JSON file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static Map<String, Airport> readJsonFromFileAirport(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Read existing data from the file
            Map<String, Airport> existingData = objectMapper.readValue(new File(filePath), Map.class);
            return existingData;
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>(); // Return an empty map in case of an error
        }
    }
}
