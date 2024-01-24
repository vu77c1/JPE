/**
 * @project SaleManagement
 */

package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fa.training.common.Constant;
import fa.training.common.DBUtils;
import fa.training.entities.Employee;

/**
 * author Duy Bach.
 * 
 * @time 2:25:08 PM
 * @date Jun 22, 2019
 */
public class EmployeeDAOImpl implements EmployeeDAO {
  
  private Connection connection = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet results = null;

  @Override
  public Employee findById(int employeeId) {
    Employee employee = null;
    try {
      connection = DBUtils.getInstance().getConnection();
      preparedStatement = connection
          .prepareStatement(Constant.EMPLOYEE_QUERY_FIND_BY_ID);
      preparedStatement.setInt(1, employeeId);
      results = preparedStatement.executeQuery();
      if (results.next()) {
        employee = new Employee();
        employee.setEmpID(results.getInt("employee_id"));
        employee.setEmpName(results.getString("employee_name"));
        employee.setSalary(results.getDouble("salary"));
        employee.setSpvrID(results.getInt("supervisor_id"));
      }
    } catch (SQLException e) {
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
        if (preparedStatement != null) {
          preparedStatement.close();
        }
      } catch (SQLException e) {
      }
    }
    return employee;
  }

}
