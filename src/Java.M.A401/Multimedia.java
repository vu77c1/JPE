public abstract class Multimedia {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    private String name;
    private double duration;

    public Multimedia() {
    }

    public Multimedia(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }
    public void createMultimedia() {
        setName(InputValidate.validateStringInput("Enter Name: "));
        setDuration(InputValidate.validateDoubleInput("Enter Duration: "));
    }

}
