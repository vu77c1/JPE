package JPL.L.A301.entities;

public class Employee {
    private int employeeId;
    private String employeeName;
    private double salary;
    private int spvrId;

    // Default constructor
    public Employee() {
    }

    // Constructor with parameters
    public Employee(int employeeId, String employeeName, double salary, int spvrId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.spvrId = spvrId;
    }

    // Getter and setter methods
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getSpvrId() {
        return spvrId;
    }

    public void setSpvrId(int spvrId) {
        this.spvrId = spvrId;
    }
}
