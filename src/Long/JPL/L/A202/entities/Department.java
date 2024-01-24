package JPL.L.A202;

import java.util.HashMap;
import java.util.Map;

public class Department {
    private Map<String, Employee> employees;
    private String departmentName;
    public Department(String departmentName) {
        this.departmentName = departmentName;
        employees = new HashMap<>();
    }

    // Method to add an employee to the department
    public void addEmployee(Employee employee) {
        employees.put(employee.getSsn(), employee);
    }

    // Method to get an employee by their identifier (e.g., Social Security Number)
    public Employee getEmployee(String ssn) {
        return employees.get(ssn);
    }

    // Method to get all employees in the department
    public Map<String, Employee> getEmployees() {
        return employees;
    }
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
