/**
 * @project SaleManagement
 */
package JPL.L.A301.dao;

import JPL.L.A301.entities.Employee;

import java.util.List;

public interface EmployeeDAO {
  boolean addEmployee(Employee employee);
  boolean updateEmployee(Employee employee);
  boolean deleteEmployee(int employeeId);
  List<Employee> listAllEmployees();

  Employee findById(int employeeId);

}
