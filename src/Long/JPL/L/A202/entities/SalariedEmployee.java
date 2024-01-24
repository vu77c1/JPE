package JPL.L.A202.entities;

public class SalariedEmployee extends Employee {
    private double commissionRate;
    private double grossSales;
    private double basicSalary;

    // Constructor
    public SalariedEmployee(String ssn, String firstName, String lastName,
                            String birthDate, String phone, String email,String departmentName,
                            double commissionRate, double grossSales, double basicSalary) {
        super(ssn, firstName, lastName, birthDate, phone, email,departmentName);
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
        this.basicSalary = basicSalary;
    }
    public SalariedEmployee(){}
    // Getter and setter methods for the new fields

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }
    @Override
    public String toString() {
        return String.format("SalariedEmployee{id=%s, firstName=%s, lastName=%s, " +
                        "birthDate=%s, phone=%s, email=%s,dptName=%s, commissionRate=%.2f, " +
                        "grossSales=%.2f, basicSalary=%.2f}",
                getSsn(), getFirstName(), getLastName(), getBirthDate(),
                getPhone(), getEmail(),getDepartmentName(), commissionRate, grossSales, basicSalary);
    }

}
