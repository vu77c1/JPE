package JPL.L.A202.main;

import JPL.L.A201.*;
import JPL.L.A202.entities.Department;
import JPL.L.A202.entities.Employee;
import JPL.L.A202.entities.HourlyEmployee;
import JPL.L.A202.entities.SalariedEmployee;
import JPL.L.A202.services.DepartmentService;
import JPL.L.A202.services.EmployeeService;
import JPL.L.A202.utils.ValidationUtils;

import java.util.*;

public class EmployeeManagement {
    public static void main(String[] args) {
        Set<Department> departmentList = new HashSet<>(DepartmentService.readDepartmentsFromFile("/Users/tuanvu/Downloads/JPE/src/Long/JPL/L/A202/utils/Department.txt"));
        Map<String, Employee> employeeMap = new HashMap<>();
        EmployeeService employeeService = new EmployeeService(employeeMap, departmentList);
        DepartmentService departmentService = new DepartmentService(departmentList, employeeMap);


        int choice;
        boolean exitMenu = false;
        do {
            do {
                System.out.println("0. Exit ");
                System.out.println("1. Enter Hourly ");
                System.out.println("2. Enter SalariedEmployee ");
                System.out.println("3. Display Employee  ");
                System.out.println("4. Search employee by department name   ");
                System.out.println("5. Search employee by employee name   ");
                System.out.println("6. Display the list of departments and the number of employees for each   ");

                choice = InputValidator.validateIntInput("Enter 0-6: ");
                if (choice >= 0 && choice <= 9) {
                    break; // Exit the loop if the input is 1 or 2
                } else {
                    System.out.println("Invalid choice. Please enter again.");
                }
            } while (true);

            switch (choice) {
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    exitMenu = true;
                    break;

                case 1:
                    HourlyEmployee hourlyEmployee = new HourlyEmployee();
                    employeeService.addEmployee(hourlyEmployee);

                    break;
                case 2:
                    SalariedEmployee salariedEmployee = new SalariedEmployee();
                    employeeService.addEmployee(salariedEmployee);

                    break;
                case 3:
                    employeeService.displayEmp(employeeMap);

                    break;
                case 4:
                    System.out.println("List Department: ");
                    System.out.println(departmentList);
                    String dpmName = ValidationUtils.validateStringInput("Enter DepartmentName: ");
                    Map<String,Employee> departments = departmentService.searchEmployeesByDepartment(dpmName);
                    employeeService.displayEmp(departments);

                    break;
                case 5:
                    String empName = ValidationUtils.validateStringInput("Enter EmployeesByName: ");
                    employeeService.displayEmp(employeeService.searchEmployeesByName(empName));

                    break;
                case 6:
                    departmentService.displayDepartmentEmployeeCount();

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:


                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        }
        while (!exitMenu);

    }

}
