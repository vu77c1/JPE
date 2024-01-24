package JPL.L.A201;

import java.io.*;
import java.util.*;

public class AirplaneManagement {
    private static final String filePathWriteAirplane = "/Users/tuanvu/Downloads/JPE/src/Long/JPL/L/A201/Airplane.txt";

    public static void main(String[] args) throws IOException {
        Map<String, Airplane> airplanes = readAirplanesFromFile(filePathWriteAirplane);
        Map<String, Airport> airport = AirportManagement.readAirportFromFile(AirportManagement.filePathWriteAirport);
        AirportManagement airportManagement = new AirportManagement(airport);
        AirplaneManagement management = new AirplaneManagement(airplanes);

        int choice;
        boolean exitMenu = false;
        do {
            do {
                System.out.println("0. Exit ");
                System.out.println("1. Enter FixedWing ");
                System.out.println("2. Enter Helicopter ");
                System.out.println("3. List Airplane  ");
                System.out.println("4. Enter Airport   ");
                System.out.println("5. Display list of all airport information, sorted by airport ID   ");
                System.out.println("6. Remove Helicopter in  Airport   ");
                System.out.println("7. Display list of all fixed wing airplanes with its parking airport ID and name   ");
                System.out.println("8. Display list of all helicopters with its parking airport ID and name   ");
                System.out.println("9. Display the status of one airport, selected by airport ID   ");

                choice = InputValidator.validateIntInput("Enter 0-9: ");
                if (choice >= 0 && choice <= 9) {
                    break; // Exit the loop if the input is 1 or 2
                } else {
                    System.out.println("Invalid choice. Please enter again.");
                }
            } while (true);

            switch (choice) {
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    exitMenu = true;
                    break;

                case 1:
                    FixedWing fixedWing = management.addFixedWing();
                    management.addAirplane(fixedWing);
                    break;
                case 2:
                    Helicopter helicopter = management.addHelicopter();
                    management.addAirplane(helicopter);
                    break;
                case 3:
                    management.displayAirplanes();
                    break;
                case 4:
                    Airport airport1 = airportManagement.addAirport(airplanes);
                    break;
                case 5:
                    AirportManagement.displayAirports(airport);
                    break;
                case 6:
                    System.out.println(airportManagement);
                    airportManagement.removeHelicopters(airport);
                    break;
                case 7:
                    management.displayFixedWingAirplanes(airplanes, airport);
                    break;
                case 8:
                    management.displayHelicopters(airplanes, airport);
                    break;
                case 9:
                    String idSearch = InputValidator.validateAirportId("Enter AirportId (search): ");
                    airportManagement.displayAirportStatus(airport,idSearch);

                    break;

                default:
                    // Handle other cases
                    System.out.println("Invalid choice.");
                    break;
            }

        }
        while (!exitMenu);


    }

    private Map<String, Airplane> airplanes;
//    private Map<String, Airport> airports;


    public AirplaneManagement(Map<String, Airplane> airplanes) {

        this.airplanes = airplanes;
    }

    public boolean addAirplane(Airplane airplane) {
        if (airplanes.put(airplane.getId(), airplane) == null) {
            System.out.println("Airplane added to the management system: " + airplane.getModel());
            return true;
        } else {
            System.out.println("Airplane with the same ID already exists: " + airplane.getId());
            return false;
        }
    }

    public FixedWing addFixedWing() throws IOException {
        FixedWing fixedWing = new FixedWing();
        do {
            String airplaneId = InputValidator.validateFixedWingId("Enter FixedWing ID: ");
            if (airplanes.containsKey(airplaneId)) {
                System.out.println("Error: Airplane with the same ID already exists: " + airplaneId);
            } else {
                fixedWing.setId(airplaneId);
                break;
            }
        } while (true);
        fixedWing.setModel(InputValidator.validateModel("Enter airplane model: "));
        fixedWing.setCruiseSpeed(InputValidator.validateDoubleInput("Enter cruise speed: "));
        fixedWing.setEmptyWeight(InputValidator.validateDoubleInput("Enter empty weight: "));
        fixedWing.setMaxTakeoffWeight(InputValidator.validateDoubleInput("Enter max takeoff weight: "));
        // Get and set planeType using enum
        String planeTypeInput = InputValidator.validatePlaneType("Enter plane type (CAG, LGR, PRV): ");
        try {
            PlaneType planeType = PlaneType.valueOf(planeTypeInput.toUpperCase());
            fixedWing.setPlaneType(planeType);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid plane type. Please enter CAG, LGR, or PRV.");
            // You may choose to handle the error in a different way, e.g., ask the user to input again
        }
        fixedWing.setMinRunwaySize(InputValidator.validateDoubleInput("Enter minimum runway size:"));
        try {
            // Ghi đối tượng vào tệp văn bản
            writeFixedWingToFile(fixedWing, filePathWriteAirplane);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fixedWing;
    }

    private void writeFixedWingToFile(FixedWing fixedWing, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Mở tệp với cờ true để thêm nội dung vào cuối tệp

            // Sử dụng toString() để chuyển đối tượng thành chuỗi và ghi vào tệp
            writer.write(fixedWing.toString());
            writer.newLine(); // Thêm một dòng mới cho các đối tượng khác (tùy chọn)

            System.out.println("FixedWing has been added and written to the file.");
        }
    }

    public Helicopter addHelicopter() {
        Helicopter helicopter = new Helicopter();
        do {
            String airplaneId = InputValidator.validateHelicopterId("Enter helicopter ID: ");
            if (airplanes.containsKey(airplaneId)) {
                System.out.println("Error: Airplane with the same ID already exists: " + airplaneId);
            } else {
                helicopter.setId(airplaneId);
                break;
            }
        } while (true);
        helicopter.setModel(InputValidator.validateModel("Enter helicopter model: "));
        helicopter.setCruiseSpeed(InputValidator.validateDoubleInput("Enter cruise speed: "));
        helicopter.setEmptyWeight(InputValidator.validateDoubleInput("Enter empty weight: "));

        do {
            double takeoffWeight = InputValidator.validateDoubleInput("Enter max takeoff weight: ");
            if (takeoffWeight > helicopter.emptyWeight * 1.5) {
                System.out.println("Maximum takeoff weight exceeds 1.5 times the empty weight");
            } else {
                helicopter.setMaxTakeoffWeight(takeoffWeight);
                break;
            }

        } while (true);
        helicopter.setRange(InputValidator.validateDoubleInput("Enter range: "));
        try {
            // Ghi đối tượng vào tệp văn bản
            writeHelicopterToFile(helicopter, filePathWriteAirplane);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return helicopter;
    }

    private void writeHelicopterToFile(Helicopter helicopter, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Mở tệp với cờ true để thêm nội dung vào cuối tệp

            // Sử dụng toString() để chuyển đối tượng thành chuỗi và ghi vào tệp
            writer.write(helicopter.toString());
            writer.newLine(); // Thêm một dòng mới cho các đối tượng khác (tùy chọn)

            System.out.println("Helicopter has been added and written to the file.");
        }
    }

    public Set<String> getListIdFixedWing() {
        Set<String> fixedWingIds = new HashSet<>();
        for (Airplane airplane : airplanes.values()) {
            if (airplane instanceof FixedWing) {
                fixedWingIds.add(airplane.getId());
            }
        }
        return fixedWingIds.isEmpty() ? null : fixedWingIds;
    }

    public Set<String> getListHelicopter() {
        Set<String> helicopterIds = new HashSet<>();

        for (Airplane airplane : airplanes.values()) {
            if (airplane instanceof Helicopter) {
                helicopterIds.add(airplane.getId());
            }
        }

        return helicopterIds.isEmpty() ? null : helicopterIds;
    }

    private boolean validateHelicopterTakeoffWeight(Helicopter helicopter) {

        if (helicopter.maxTakeoffWeight > 1.5 * helicopter.emptyWeight) {
            return false; // Maximum takeoff weight exceeds 1.5 times the empty weight
        }
        return true; // All helicopters meet the takeoff weight requirement
    }

    public static Map<String, Airplane> readAirplanesFromFile(String filePath) {
        Map<String, Airplane> airplanes = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Phân tích dòng thành các trường
                String[] fields = line.split("\\|");
                if (fields.length == 7 || fields.length == 8) {
                    String id = fields[1].trim();
                    String model = fields[2].trim();
                    double cruiseSpeed = Double.parseDouble(fields[3].trim());
                    double emptyWeight = Double.parseDouble(fields[4].trim());
                    double maxTakeoffWeight = Double.parseDouble(fields[5].trim());

                    // Kiểm tra loại máy bay (FixedWing hoặc Helicopter) dựa vào sự có mặt của planeType
                    if (fields[6].trim().equalsIgnoreCase("CAG") || fields[6].trim().equalsIgnoreCase("LGR") || fields[6].trim().equalsIgnoreCase("PRV")) {
                        PlaneType planeType = PlaneType.valueOf(fields[6].trim().toUpperCase());
                        double minRunwaySize = Double.parseDouble(fields[7].trim());
                        FixedWing fixedWing = new FixedWing(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight, planeType, minRunwaySize);
                        airplanes.put(id, fixedWing);
                    } else {
                        double range = Double.parseDouble(fields[6].trim());
                        Helicopter helicopter = new Helicopter(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight, range);
                        airplanes.put(id, helicopter);
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ theo ý muốn của bạn
        }

        return airplanes;
    }

    public void displayAirplanes() {
        System.out.println("List of Airplanes:");

        // Create a list from the values of the airplanes map
        List<Airplane> airplaneList = new ArrayList<>(airplanes.values());

        // Sort the list by id in descending order
        airplaneList.sort(Comparator.comparing(Airplane::getId).reversed());

        // Keep track of whether the title has been printed for FixedWing and Helicopter
        boolean fixedWingTitlePrinted = false;
        boolean helicopterTitlePrinted = false;

        // Iterate over the sorted list and print each airplane
        for (Airplane airplane : airplaneList) {
            // Check if the airplane is a FixedWing
            if (airplane instanceof FixedWing) {
                // Print the title for FixedWing only once
                if (!fixedWingTitlePrinted) {
                    System.out.printf("\nFixedWing Airplanes:\n");
                    System.out.printf("| %-10s | %-6s | %-12s | %-11s | %-18s | %-10s | %-15s |\n",
                            "ID", "Model", "CruiseSpeed", "EmptyWeight", "MaxTakeoffWeight", "PlaneType", "MinRunwaySize");
                    System.out.println("|------------|--------|--------------|-------------|--------------------|------------|------------------|");
                    fixedWingTitlePrinted = true;
                }
            } else if (airplane instanceof Helicopter) {
                // Check if the title for Helicopter has been printed
                if (!helicopterTitlePrinted) {
                    System.out.printf("\nHelicopter Airplanes:\n");
                    System.out.printf("| %-10s | %-6s | %-12s | %-11s | %-18s | %-10s |\n",
                            "ID", "Model", "CruiseSpeed", "EmptyWeight", "MaxTakeoffWeight", "Range");
                    System.out.println("|------------|--------|--------------|-------------|--------------------|------------|");
                    helicopterTitlePrinted = true;
                }
            }

            // Print the general title if neither FixedWing nor Helicopter titles have been printed
            if (!fixedWingTitlePrinted && !helicopterTitlePrinted) {
                System.out.printf("| %-10s | %-6s | %-12s | %-11s | %-18s | %-10s | %-15s |\n",
                        "ID", "Model", "CruiseSpeed", "EmptyWeight", "MaxTakeoffWeight", "PlaneType", "AdditionalField");
                System.out.println("|------------|--------|--------------|-------------|--------------------|------------|------------------|");
            }

            System.out.println(airplane.toString());
        }


    }

    public void displayFixedWingAirplanes(Map<String, Airplane> airplanes, Map<String, Airport> airports) {
        // Print the header
        System.out.println("|--------------|--------------|--------------|----------------|----------------|");

        // Print the column headers
        System.out.println("| Airplane ID  | Airport ID   | Airport Name  | Model          | Parking Type   |");

        // Print the separator line
        System.out.println("|--------------|--------------|--------------|----------------|----------------|");

        // Iterate through airplanes
        for (Airplane airplane : airplanes.values()) {
            // Check if the airplane is a fixed-wing airplane
            if (airplane instanceof FixedWing) {
                FixedWing fixedWing = (FixedWing) airplane;

                // Get the parking airport ID
                String parkingAirportId = getFixedWingParkingAirportId(airports, fixedWing.getId());

                // Get the parking airport name
                String parkingAirportName = getAirportName(airports, parkingAirportId);

                // Print airplane information
                System.out.println(String.format("| %-12s | %-12s | %-12s | %-14s | %-14s |",
                        fixedWing.getId(), parkingAirportId, parkingAirportName, fixedWing.getModel(), "Fixed Wing"));
            }
        }

        // Print the bottom line
        System.out.println("|--------------|--------------|--------------|----------------|----------------|");
    }

    private static String getFixedWingParkingAirportId(Map<String, Airport> airports, String airplaneId) {
        for (Airport airport : airports.values()) {
            if (airport.getFixedWingAirplaneIds().contains(airplaneId)) {
                return airport.getId();
            }
        }
        return "N/A";
    }

    private static String getAirportName(Map<String, Airport> airports, String airportId) {
        Airport airport = airports.get(airportId);
        return (airport != null) ? airport.getName() : "N/A";
    }

    public void displayHelicopters(Map<String, Airplane> airplanes, Map<String, Airport> airports) {
        // Print the header
        System.out.println("|--------------|--------------|--------------|----------------|----------------|");

        // Print the column headers
        System.out.println("| Helicopter ID| Airport ID   | Airport Name  | Model          | Parking Type   |");

        // Print the separator line
        System.out.println("|--------------|--------------|--------------|----------------|----------------|");

        // Iterate through airplanes
        for (Airplane airplane : airplanes.values()) {
            // Check if the airplane is a helicopter
            if (airplane instanceof Helicopter) {
                Helicopter helicopter = (Helicopter) airplane;

                // Get the parking airport ID
                String parkingAirportId = getHelicopterParkingAirportId(airports, helicopter.getId());

                // Get the parking airport name
                String parkingAirportName = getAirportName(airports, parkingAirportId);

                // Print helicopter information
                System.out.println(String.format("| %-12s | %-12s | %-12s | %-14s | %-14s |",
                        helicopter.getId(), parkingAirportId, parkingAirportName, helicopter.getModel(), "Helicopter"));
            }
        }

        // Print the bottom line
        System.out.println("|--------------|--------------|--------------|----------------|----------------|");
    }

    private static String getHelicopterParkingAirportId(Map<String, Airport> airports, String helicopterId) {
        for (Airport airport : airports.values()) {
            if (airport.getHelicopterIds().contains(helicopterId)) {
                return airport.getId();
            }
        }
        return "N/A";
    }


}

