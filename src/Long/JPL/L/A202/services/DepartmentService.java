package JPL.L.A202.services;
import JPL.L.A202.entities.Department;
import JPL.L.A202.entities.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DepartmentService {
    private Set<Department> departmentList;
    private Map<String, Employee> employees;

    public DepartmentService(Set<Department> list, Map<String, Employee> employees) {
        this.departmentList = list;
        this.employees = employees;
    }

    public void addDepartment() {
        Department department = new Department();
        departmentList.add(department);
    }

    public static Set<Department> readDepartmentsFromFile(String filePath) {
        Set<Department> departments = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Department department = new Department(line);
                departments.add(department);
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return departments;
    }
    //•	Search employee by department name, return a list of all employees
    //Tìm kiếm nhân viên theo tên bộ phận, trả về danh sách tất cả nhân viên
    public Map<String,Employee> searchEmployeesByDepartment(String departmentName) {
        Map<String,Employee> employeesInDepartment = new HashMap<>();

        for (Department department : departmentList) {
            if (department.getDepartmentName().equalsIgnoreCase(departmentName)) {
                for (Employee employee : employees.values()) {
                    if (employee.getDepartmentName().equalsIgnoreCase(departmentName)) {
                        employeesInDepartment.put(employee.getSsn(),employee);
                    }
                }
                break; // Assuming there is only one department with the given name
            }
        }
        return employeesInDepartment;
    }
    //5.	Report: display the list of departments and the number of employees for each.
    //Báo cáo: hiển thị danh sách các phòng ban và số lượng nhân viên của từng phòng ban.
    public void displayDepartmentEmployeeCount() {
        for (Department department : departmentList) {
            int employeeCount = getEmployeeCountByDepartment(department.getDepartmentName());
            System.out.println("Department: " + department.getDepartmentName() + ", Employee Count: " + employeeCount);
        }
    }

    private int getEmployeeCountByDepartment(String departmentName) {
        int count = 0;
        for (Employee employee : employees.values()) {
            if (employee.getDepartmentName().equalsIgnoreCase(departmentName)) {
                count++;
            }
        }
        return count;
    }
}
