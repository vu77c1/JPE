package JPL.L.A201;

public enum PlaneType {
    CAG("Cargo"),
    LGR("Long_range"),
    PRV("Private");

    private final String label;

    PlaneType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
