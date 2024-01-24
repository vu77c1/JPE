package JPL.L.A201;

public class FixedWing extends Airplane {
    private PlaneType planeType;
    private double minRunwaySize;

    public FixedWing(String id, String model, double cruiseSpeed, double emptyWeight, double maxTakeoffWeight, PlaneType planeType, double minRunwaySize) {
        super(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight);
        this.planeType = planeType;
        this.minRunwaySize = minRunwaySize;
    }

    public FixedWing() {
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public void setPlaneType(PlaneType planeType) {
        this.planeType = planeType;
    }

    public double getMinRunwaySize() {
        return minRunwaySize;
    }

    public void setMinRunwaySize(double minRunwaySize) {
        this.minRunwaySize = minRunwaySize;
    }

    public String getFlyMethod() {
        return "fixed wing";
    }
   /* public String toString() {
        return "FixedWing{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", cruiseSpeed=" + cruiseSpeed +
                ", emptyWeight=" + emptyWeight +
                ", maxTakeoffWeight=" + maxTakeoffWeight +
                ", planeType='" + planeType.getLabel() + '\'' +
                ", minRunwaySize=" + minRunwaySize +
                '}';
    }*/
    @Override
    public String toString() {
        // Sử dụng định dạng bảng để xuất thông tin
        return String.format("| %-10s | %-6s | %-12s | %-11s | %-18s | %-10s | %-15s |",
                id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight, planeType, minRunwaySize);
    }


}
