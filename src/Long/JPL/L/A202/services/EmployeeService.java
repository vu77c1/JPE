package JPL.L.A202.services;

import JPL.L.A202.entities.*;
import JPL.L.A202.utils.ValidationUtils;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class EmployeeService {
    private Map<String, Employee> employeeMap;
    private Set<Department> departmentList;

    public EmployeeService(Map<String, Employee> employeeMap, Set<Department> departmentList) {
        this.employeeMap = employeeMap;
        this.departmentList = departmentList;

    }

    public void addEmployee(Employee employee) {
        if (employee instanceof HourlyEmployee) {
            HourlyEmployee hourlyEmployee = (HourlyEmployee) employee;

            String id;
            boolean checkEmpId;

            do {
                id = ValidationUtils.validateStringInput("Enter HourlyEmployee ID: ");
                checkEmpId = !employeeMap.containsKey(id);
                if (!checkEmpId) {
                    System.err.println("Error: Employee with ID " + id + " already exists.");
                }
            } while (!checkEmpId);

            hourlyEmployee.setSsn(id);
            hourlyEmployee.setFirstName(ValidationUtils.validateStringInput("Enter First Name: "));
            hourlyEmployee.setLastName(ValidationUtils.validateStringInput("Enter Last Name: "));
            hourlyEmployee.setBirthDate(ValidationUtils.validateBirthDate("Enter Birth Date: "));
            hourlyEmployee.setPhone(ValidationUtils.validatePhoneNumber("Enter Phone: "));
            hourlyEmployee.setEmail(ValidationUtils.validateEmail("Enter Email: "));
            System.out.println("List Department: ");
            System.out.println(departmentList);
            hourlyEmployee.setDepartmentName(ValidationUtils.validateStringInput("Enter Department Name: "));
            hourlyEmployee.setRate(ValidationUtils.validateDoubleInput("Enter Hourly Rate: "));
            hourlyEmployee.setWorkingHours(ValidationUtils.validateDoubleInput("Enter Working Hours: "));
            employeeMap.put(id, hourlyEmployee);

            writeEmployeeToJsonFile(hourlyEmployee);
        } else if (employee instanceof SalariedEmployee) {
            SalariedEmployee salariedEmployee = (SalariedEmployee) employee;

            String id;
            boolean checkEmpId;

            do {
                id = ValidationUtils.validateStringInput("Enter SalariedEmployee ID: ");
                checkEmpId = !employeeMap.containsKey(id);
                if (!checkEmpId) {
                    System.err.println("Error: Employee with ID " + id + " already exists.");
                }
            } while (!checkEmpId);

            salariedEmployee.setSsn(id);
            salariedEmployee.setFirstName(ValidationUtils.validateStringInput("Enter First Name: "));
            salariedEmployee.setLastName(ValidationUtils.validateStringInput("Enter Last Name: "));
            salariedEmployee.setBirthDate(ValidationUtils.validateBirthDate("Enter Birth Date: "));
            salariedEmployee.setPhone(ValidationUtils.validatePhoneNumber("Enter Phone: "));
            salariedEmployee.setEmail(ValidationUtils.validateEmail("Enter Email: "));
            System.out.println("List Department: ");
            System.out.println(departmentList);
            salariedEmployee.setDepartmentName(ValidationUtils.validateStringInput("Enter Department Name: "));
            salariedEmployee.setCommissionRate(ValidationUtils.validateDoubleInput("Enter Commission Rate: "));
            salariedEmployee.setGrossSales(ValidationUtils.validateDoubleInput("Enter Gross Sales: "));
            salariedEmployee.setBasicSalary(ValidationUtils.validateDoubleInput("Enter Basic Salary: "));

            employeeMap.put(id, salariedEmployee);
        }
    }
    private void writeEmployeeToJsonFile(Employee employee) {
        Gson gson = new Gson();
        String employeeType = (employee instanceof SalariedEmployee) ? "salariedEmployee" : "hourlyEmployee";
        String json = gson.toJson(employee);

        String formattedJson = String.format("[ \"%s\", %s ]", employeeType, json);

        String filePath = "/Users/tuanvu/Downloads/JPE/src/Long/JPL/L/A202/utils/employee.json";

        try {
            Path path = Paths.get(filePath);

            if (!Files.exists(path)) {
                Files.createFile(path);
            }

            String jsonWithNewLine = formattedJson + "," + System.lineSeparator();

            // Đọc dữ liệu từ file nếu có
            List<String> existingData = Files.readAllLines(path, StandardCharsets.UTF_8);

            // Ghi lại toàn bộ dữ liệu cũ và thêm dữ liệu mới
            Files.write(path, existingData);
            Files.write(path, Collections.singletonList(jsonWithNewLine), StandardCharsets.UTF_8,
                    StandardOpenOption.APPEND);

            System.out.println("Data has been written to the file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public Map<String, Employee> searchEmployeesByName(String employeeName) {
        Map<String, Employee> employeesWithSameName = new HashMap<>();

        for (Employee employee : employeeMap.values()) {
            if (employee.getFirstName().equalsIgnoreCase(employeeName)) {
                employeesWithSameName.put(employee.getSsn(), employee);
            }
        }

        return employeesWithSameName;
    }

    public void displayEmp(Map<String, Employee> employees) {
        System.out.println("List Employees:");
        for (Employee employee : employees.values()) {
            System.out.println(employee);
        }
    }


}
