package JPL.L.A202.entities;

public class HourlyEmployee extends Employee {
    private double rate;
    private double workingHours;

    // Constructor
    public HourlyEmployee(String ssn, String firstName, String lastName,
                          String birthDate, String phone, String email,String departmentName,
                          double rate, double workingHours) {
        super(ssn, firstName, lastName, birthDate, phone, email,departmentName);
        this.rate = rate;
        this.workingHours = workingHours;
    }
    public HourlyEmployee(){}

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
    @Override
    public String toString() {
        return String.format("HourlyEmployee{id=%s, firstName=%s, lastName=%s, " +
                        "birthDate=%s, phone=%s, email=%s,dptName=%s, rate=%.2f, workingHours=%.2f}",
                getSsn(), getFirstName(), getLastName(), getBirthDate(),
                getPhone(), getEmail(),getDepartmentName(), rate, workingHours);
    }
}
