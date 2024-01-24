package JPL.L.A202;

public class HourlyEmployee extends Employee {
    private double rate;
    private double workingHours;

    // Constructor
    public HourlyEmployee(String ssn, String firstName, String lastName,
                          String birthDate, String phone, String email,
                          double rate, double workingHours) {
        super(ssn, firstName, lastName, birthDate, phone, email);
        this.rate = rate;
        this.workingHours = workingHours;
    }

    // Getter and setter methods for the new fields

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }
}
