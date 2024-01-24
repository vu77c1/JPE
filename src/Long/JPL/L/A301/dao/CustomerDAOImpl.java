/**
 * @project SaleManagement
 */

package fa.training.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fa.training.common.Constant;
import fa.training.common.DBUtils;
import fa.training.entities.Customer;

/**
 * author Duy Bach.
 * 
 * @time 2:24:39 PM
 * @date Jun 22, 2019
 */
public class CustomerDAOImpl implements CustomerDAO {

  private Connection connection = null;
  private CallableStatement caStatement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet results = null;

  @Override
  public boolean addCustomer(Customer customer) {
    boolean check = false;
    try {

      connection = DBUtils.getInstance().getConnection();

      caStatement = connection.prepareCall(Constant.CUSTOMER_QUERY_ADD);
      caStatement.setInt(1, customer.getCusID());
      caStatement.setString(2, customer.getCusName());
      caStatement.registerOutParameter(3, Types.INTEGER);
      caStatement.executeUpdate();
      check = caStatement.getInt(3) > 0;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
        if (caStatement != null) {
          caStatement.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return check;
  }

  @Override
  public boolean updateCustomer(Customer customer) {
    boolean check = false;
    try {

      connection = DBUtils.getInstance().getConnection();
      caStatement = connection.prepareCall(Constant.CUSTOMER_QUERY_UPDATE);
      caStatement.setInt(1, customer.getCusID());
      caStatement.setString(2, customer.getCusName());
      caStatement.registerOutParameter(3, Types.INTEGER);
      caStatement.executeUpdate();
      check = caStatement.getInt(3) > 0;
    } catch (SQLException e) {
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
        if (caStatement != null) {
          caStatement.close();
        }
      } catch (SQLException e) {
      }
    }
    return check;
  }

  @Override
  public boolean deleteCustomer(int idCus) {
    boolean check = false;
    try {

      connection = DBUtils.getInstance().getConnection();
      caStatement = connection.prepareCall(Constant.CUSTOMER_QUERY_DELETE);
      caStatement.setInt(1, idCus);
      caStatement.registerOutParameter(2, Types.INTEGER);
      check = caStatement.getInt(2) > 0;
    } catch (SQLException e) {
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
        if (caStatement != null) {
          caStatement.close();
        }
      } catch (SQLException e) {
      }
    }
    return check;
  }

  @Override
  public List<Customer> listAllCustomers() {
    List<Customer> customers = null;
    Customer customer = null;
    try {
      customers = new ArrayList<>();
      connection = DBUtils.getInstance().getConnection();
      preparedStatement = connection
          .prepareStatement(Constant.CUSTOMER_QUERY_FIND_ALL);
      results = preparedStatement.executeQuery();
      while (results.next()) {
        customer = new Customer();

        customer.setCusID(results.getInt("customer_id"));
        customer.setCusName(results.getString("customer_name"));

        customers.add(customer);
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
        if (results != null) {
          results.close();
        }
      } catch (SQLException e) {
      }
    }
    return customers;
  }

  @Override
  public Customer findById(int id) {
    Customer customer = null;
    try {
      connection = DBUtils.getInstance().getConnection();
      preparedStatement = connection
          .prepareStatement(Constant.CUSTOMER_QUERY_FIND_BY_ID);
      preparedStatement.setInt(1, id);
      results = preparedStatement.executeQuery();
      if (results.next()) {
        customer = new Customer();
        customer.setCusID(results.getInt("customer_id"));
        customer.setCusName(results.getString("customer_name"));
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
        if (results != null) {
          results.close();
        }
      } catch (SQLException e) {
      }
    }
    return customer;
  }

}
