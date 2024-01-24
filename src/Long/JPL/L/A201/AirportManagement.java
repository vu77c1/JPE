package JPL.L.A201;

import java.io.*;
import java.util.*;

public class AirportManagement {
    private Map<String, Airport> airports;
    public static final String filePathWriteAirport = "/Users/tuanvu/Downloads/JPE/src/Long/JPL/L/A201/Airport.txt";


    public AirportManagement(Map<String, Airport> airports) {
        this.airports = airports;
    }

    public boolean addAirport(Airport a) {
        if (airports.put(a.getId(), a) == null) {
            System.out.println("Airport added to the management system: " + a.getId());
            return true;
        } else {
            System.out.println("Airport with the same ID already exists: " + a.getId());
            return false;
        }
    }

    public Airport addAirport(Map<String, Airplane> airplanes) {
        Airport airport = new Airport();
        AirplaneManagement airplaneManagement = new AirplaneManagement(airplanes);

        validatorAirportID(airport);
        airport.setName(InputValidator.validateStringInput("Enter airport name: "));
        airport.setRunwaySize(InputValidator.validateDoubleInput("Enter runway size: "));

        // Set fixed-wing airplane IDs
        Set<String> fixedWingIds = new HashSet<>();
        System.out.println("fixedWingIds: " + airplaneManagement.getListIdFixedWing());
        airport.setMaxFixedWingParkingPlace(InputValidator.validateIntInput("Enter max fixed-wing parking places: "));
        int maxFixedWingParkingPlace = airport.getMaxFixedWingParkingPlace();
        for (int i = 0; i < maxFixedWingParkingPlace; i++) {
            String fixedWingId;
            Boolean continuefixedWingIds = false;

            if (validateFixedWingRunwaySize(airplaneManagement.getListIdFixedWing(), airplanes, airport.getRunwaySize())) {
                do {
                    fixedWingId = InputValidator.validateFixedWingId("Enter fixed-wing airplane ID for parking place " + (i + 1) + ": ");
                    if (fixedWingIds.contains(fixedWingId)) {
                        System.out.println("Error: No airplane with ID " + fixedWingId + " found.");
                    } else {
                        fixedWingIds.add(fixedWingId);
                        continuefixedWingIds = true;
                    }
                }
                while (!continuefixedWingIds);
                airport.setFixedWingAirplaneIds(fixedWingIds);

            } else {
                System.out.println("\u001B[31mError: Minimum runway size exceeds the airport's runway size.\u001B[0m");

            }

        }

        // Set helicopter IDs
        Set<String> helicopterIds = new HashSet<>();
        System.out.println("helicopterIds: " + airplaneManagement.getListHelicopter());
        airport.setMaxRotatedWingParkingPlace(InputValidator.validateIntInput("Enter max rotated-wing parking places: "));
        int maxRotatedWingParkingPlace = airport.getMaxRotatedWingParkingPlace();
        for (int i = 0; i < maxRotatedWingParkingPlace; i++) {
            String helicopterId;
            Boolean continuehelicopterIds = false;

            do {
                helicopterId = InputValidator.validateHelicopterId("Enter helicopter airplane ID for parking place " + (i + 1) + ": ");
                if (helicopterIds.contains(helicopterId)) {
                    System.out.println("Error: No airplane with ID " + helicopterId + " found.");
                } else {
                    helicopterIds.add(helicopterId);
                    continuehelicopterIds = true;
                }
            }
            while (!continuehelicopterIds);
        }
        airport.setHelicopterIds(helicopterIds);

        // Add the airport to the management system
        addAirport(airport);
        try {
            // Ghi đối tượng vào tệp văn bản
            writeAirportToFile(airport, filePathWriteAirport);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return airport;
    }

    private void writeAirportToFile(Airport airport, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Mở tệp với cờ true để thêm nội dung vào cuối tệp

            // Sử dụng toString() để chuyển đối tượng thành chuỗi và ghi vào tệp
            writer.write(airport.toString());
            writer.newLine(); // Thêm một dòng mới cho các đối tượng khác (tùy chọn)

            System.out.println("Helicopter has been added and written to the file.");
        }
    }

    private void validatorAirportID(Airport airport) {
        do {
            String airportId = InputValidator.validateAirportId("Enter Airport ID: ");
            if (airports.containsKey(airportId)) {
                System.out.println("Error: Airplane with the same ID already exists: " + airportId);
            } else {
                airport.setId(airportId);
                break;
            }
        } while (true);
    }

    public static Map<String, Airport> readAirportFromFile(String filePath) {
        Map<String, Airport> airportMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Phân tích dòng thành các trường
                String[] fields = line.split("\\|");
                if (fields.length == 8) {
                    String id = fields[1].trim();
                    String name = fields[2].trim();
                    double runwaySize = Double.parseDouble(fields[3].trim());
                    int maxFixedWingParkingPlace = Integer.parseInt(fields[4].trim());
                    Set<String> fixedWingAirplaneIds = parseIds(fields[5].trim());
                    int maxRotatedWingParkingPlace = Integer.parseInt(fields[6].trim());
                    Set<String> helicopterIds = parseIds(fields[7].trim());

                    // Create Airport object and add it to the map
                    Airport airport = new Airport(id, name, runwaySize, maxFixedWingParkingPlace, maxRotatedWingParkingPlace);
                    airport.setFixedWingAirplaneIds(fixedWingAirplaneIds);
                    airport.setHelicopterIds(helicopterIds);
                    airportMap.put(id, airport);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ theo ý muốn của bạn
        }

        return airportMap;
    }

    private static Set<String> parseIds(String input) {
        // Assuming the input format is [id1, id2, id3]
        String[] idArray = input.substring(1, input.length() - 1).split(",\\s*");
        return new HashSet<>(Arrays.asList(idArray));
    }

    private boolean validateFixedWingRunwaySize(Set<String> fixedWingIds, Map<String, Airplane> airplanes, double airportRunwaySize) {
        if (fixedWingIds != null) {
            for (String fixedWingId : fixedWingIds) {
                Airplane airplane = airplanes.get(fixedWingId);
                if (airplane instanceof FixedWing) {
                    FixedWing fixedWing = (FixedWing) airplane;
                    if (fixedWing.getMinRunwaySize() > airportRunwaySize) {
                        return false; // Minimum runway size exceeds the airport's runway size
                    }
                }
            }
        }
        return true; // All fixed-wing airplanes meet the runway size requirement
    }

    public void removeHelicopters(Map<String, Airport> airports) {
        String airportID = InputValidator.validateAirportId("Enter airportID:  ");
        System.out.println(airports.get(airportID));
        Airport airport = airports.get(airportID);
        Set<String> setId = new HashSet<>(airport.getHelicopterIds());
        System.out.println(setId);

        boolean continueId = false;
        do {
            String idRemove = InputValidator.validateHelicopterId("Enter HelicopterId (delete):  ");
            boolean flag = setId.remove(idRemove);
            if (flag) {
                System.out.println("Remove OK!!!");
                airport.setHelicopterIds(setId);
            } else {
                System.out.println("Remove not OK!!!");
            }
            String Continue = InputValidator.validateStringInput("Continue delete HelicopterId (y,n): ");
            if (Continue.toLowerCase().equals("y")) {
                continueId = true;
            } else {
                break;
            }
        }
        while (continueId);
        System.out.println(airports);

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Airport airport : airports.values()) {
            result.append(airport.toString()).append("\n");
        }
        return result.toString();
    }

    public static void displayAirports(Map<String, Airport> airports) {
        List<Airport> airplaneList = new ArrayList<>(airports.values());
        // Sort the list by id in descending order
        airplaneList.sort(Comparator.comparing(Airport::getId).reversed());
        // In tiêu đề
        System.out.println("|--------------|--------|--------------|--------------------------|-------------------|------------------------|-------------------|");

        // In dòng tiêu đề
        System.out.println("| Airport ID   | Name   | Runway Size  | Max FixedWing Parking     | FixedWing IDs     | Max RotatedWing Parking | Helicopter IDs    |");

        // In đường kẻ ngang giữa
        System.out.println("|--------------|--------|--------------|--------------------------|-------------------|------------------------|-------------------|");

        // Duyệt qua danh sách sân bay và in thông tin
        for (Airport airport : airplaneList) {
            System.out.println(airport.toString());
        }

        // In đường kẻ ngang dưới cùng
        System.out.println("|--------------|--------|--------------|--------------------------|-------------------|------------------------|-------------------|");
    }

    public  void displayAirportStatus(Map<String, Airport> airports, String selectedAirportId) {
        // Check if the selected airport ID exists
        if (airports.containsKey(selectedAirportId)) {
            // Print the header
            System.out.println("|--------------|--------|--------------|--------------------------|-------------------|------------------------|-------------------|");

            // Print the column headers
            System.out.println("| Airport ID   | Name   | Runway Size  | Max FixedWing Parking     | FixedWing IDs     | Max RotatedWing Parking | Helicopter IDs    |");

            // Print the separator line
            System.out.println("|--------------|--------|--------------|--------------------------|-------------------|------------------------|-------------------|");

            // Get the selected airport
            Airport selectedAirport = airports.get(selectedAirportId);

            // Print information for the selected airport
            System.out.println(selectedAirport.toString());

            // Print the bottom line
            System.out.println("|--------------|--------|--------------|--------------------------|-------------------|------------------------|-------------------|");
        } else {
            System.out.println("Airport with ID " + selectedAirportId + " not found.");
        }
    }
}
