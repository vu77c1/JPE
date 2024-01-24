package JPL.L.A201;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Map;

public abstract class Airplane {
    protected String id;

    public Airplane(String id, String model, double cruiseSpeed, double emptyWeight, double maxTakeoffWeight) {
        this.id = id;
        this.model = model;
        this.cruiseSpeed = cruiseSpeed;
        this.emptyWeight = emptyWeight;
        this.maxTakeoffWeight = maxTakeoffWeight;
    }
    public Airplane(){}

    protected String model;
    protected double cruiseSpeed;
    protected double emptyWeight;
    protected double maxTakeoffWeight;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCruiseSpeed() {
        return cruiseSpeed;
    }

    public void setCruiseSpeed(double cruiseSpeed) {
        this.cruiseSpeed = cruiseSpeed;
    }

    public double getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(double emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    public double getMaxTakeoffWeight() {
        return maxTakeoffWeight;
    }

    public void setMaxTakeoffWeight(double maxTakeoffWeight) {
        this.maxTakeoffWeight = maxTakeoffWeight;
    }
    @Override
    public String toString() {
        return "Airplane{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", cruiseSpeed=" + cruiseSpeed +
                ", emptyWeight=" + emptyWeight +
                ", maxTakeoffWeight=" + maxTakeoffWeight +
                '}';
    }
    public void printAirplanesTable(Map<String, Airplane> airplanes) {
        System.out.println("| %-10s | %-6s | %-12s | %-11s | %-18s | %-10s | %-15s |");
        System.out.println("|------------|--------|--------------|-------------|------------------|------------|------------------|");

        for (Airplane airplane : airplanes.values()) {
            System.out.printf("| %-10s | %-6s | %-12.2f | %-11.2f | %-18.2f | %-10s | %-15.2f |\n",
                    airplane.getId(),
                    airplane.getModel(),
                    airplane.getCruiseSpeed(),
                    airplane.getEmptyWeight(),
                    airplane.getMaxTakeoffWeight(),
                    (airplane instanceof FixedWing) ? ((FixedWing) airplane).getPlaneType().getLabel() : "",
                    (airplane instanceof FixedWing) ? ((FixedWing) airplane).getMinRunwaySize() : ((Helicopter) airplane).getRange());
        }
    }
}
