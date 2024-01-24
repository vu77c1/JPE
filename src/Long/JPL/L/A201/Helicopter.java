package JPL.L.A201;

public class Helicopter extends Airplane {
    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    private double range;

    public Helicopter(String id, String model, double cruiseSpeed, double emptyWeight, double maxTakeoffWeight,
                      double range) {
        super(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight);
        this.range = range;
    }

    public Helicopter() {
    }

    public String getFlyMethod() {
        return "rotated wing";
    }

    //    @Override
//    public String toString() {
//        return "Helicopter{" +
//                "id='" + id + '\'' +
//                ", model='" + model + '\'' +
//                ", cruiseSpeed=" + cruiseSpeed +
//                ", emptyWeight=" + emptyWeight +
//                ", maxTakeoffWeight=" + maxTakeoffWeight +
//                ", range=" + range +
//                '}';
//    }
    @Override
    public String toString() {
        // Sử dụng định dạng bảng để xuất thông tin
        return String.format("| %-10s | %-6s | %-12s | %-11s | %-18s | %-6s |",
                id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight, range);
    }
}
