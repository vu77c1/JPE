/**
 * @project SaleManagement
 */
package fa.training.dao;

import fa.training.entities.Employee;

/**
 * author Duy Bach.
 * @time 9:54:51 AM
 * @date Jun 22, 2019
 */
public interface EmployeeDAO {

  Employee findById(int employeeId) ;
}
