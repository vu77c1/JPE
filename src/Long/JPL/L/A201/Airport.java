package JPL.L.A201;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Airport {
    private String id;
    private String name;
    private double runwaySize;
    private int maxFixedWingParkingPlace;
    private Set<String> fixedWingAirplaneIds;
    private int maxRotatedWingParkingPlace;
    private Set<String> helicopterIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRunwaySize() {
        return runwaySize;
    }

    public void setRunwaySize(double runwaySize) {
        this.runwaySize = runwaySize;
    }

    public int getMaxFixedWingParkingPlace() {
        return maxFixedWingParkingPlace;
    }

    public void setMaxFixedWingParkingPlace(int maxFixedWingParkingPlace) {
        this.maxFixedWingParkingPlace = maxFixedWingParkingPlace;
    }

    public Set<String> getFixedWingAirplaneIds() {
        return fixedWingAirplaneIds;
    }

    public void setFixedWingAirplaneIds(Set<String> fixedWingAirplaneIds) {
        this.fixedWingAirplaneIds = fixedWingAirplaneIds;
    }

    public int getMaxRotatedWingParkingPlace() {
        return maxRotatedWingParkingPlace;
    }

    public void setMaxRotatedWingParkingPlace(int maxRotatedWingParkingPlace) {
        this.maxRotatedWingParkingPlace = maxRotatedWingParkingPlace;
    }

    public Set<String> getHelicopterIds() {
        return helicopterIds;
    }

    public void setHelicopterIds(Set<String> helicopterIds) {
        this.helicopterIds = helicopterIds;
    }
    public Airport(){}

    public Airport(String id, String name, double runwaySize, int maxFixedWingParkingPlace,
                   int maxRotatedWingParkingPlace) {
        this.id = id;
        this.name = name;
        this.runwaySize = runwaySize;
        this.maxFixedWingParkingPlace = maxFixedWingParkingPlace;
        this.fixedWingAirplaneIds = new HashSet<>();
        this.maxRotatedWingParkingPlace = maxRotatedWingParkingPlace;
        this.helicopterIds = new HashSet<>();
    }
    // Method to remove helicopters based on their IDs
    public void removeHelicopters(Set<String> helicopterIdsToRemove) {
        if (helicopterIdsToRemove != null && !helicopterIdsToRemove.isEmpty()) {
            helicopterIds.removeAll(helicopterIdsToRemove);
            System.out.println("Helicopters removed from the airport.");
        } else {
            System.out.println("No helicopters to remove.");
        }
    }

    @Override
    public String toString() {
        return String.format("| %-12s | %-6s | %-12s | %-24s | %-17s | %-23s | %-17s |",
                id, name, runwaySize, maxFixedWingParkingPlace, fixedWingAirplaneIds, maxRotatedWingParkingPlace, helicopterIds);
    }

}
