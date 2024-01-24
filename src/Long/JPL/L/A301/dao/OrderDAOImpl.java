/**
 * @project SaleManagement
 */

package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fa.training.common.Constant;
import fa.training.common.DBUtils;
import fa.training.entities.Order;

/**
 * author Duy Bach.
 * 
 * @time 2:24:52 PM
 * @date Jun 22, 2019
 */
public class OrderDAOImpl implements OrderDAO {

  private Connection connection = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet results = null;
  private DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

  @Override
  public boolean addOrder(Order order) {
    boolean check = false;
    try {
      connection = DBUtils.getInstance().getConnection();
      preparedStatement = connection.prepareCall(Constant.ORDER_QUERY_ADD);
      preparedStatement.setInt(1, order.getOrderID());
      preparedStatement.setString(2, dateFormat.format(order.getOrderDate()));
      preparedStatement.setInt(3, order.getCusID());
      preparedStatement.setInt(4, order.getEmpID());
      preparedStatement.setDouble(5, order.getTotal());
      check = preparedStatement.executeUpdate() > 0;
    } catch (SQLException e) {
      // TODO: handle exception
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
        if (preparedStatement != null) {
          preparedStatement.close();
        }
      } catch (SQLException e) {
        // TODO: handle exception
      }
    }
    return check;
  }

  @Override
  public boolean updateOrderTotal(int orderId) {
    boolean check = false;
    try {
      connection = DBUtils.getInstance().getConnection();
      preparedStatement = connection
          .prepareStatement(Constant.ORDER_QUERY_UPDATE_TOTAL);
      preparedStatement.setInt(1, orderId);
      preparedStatement.setInt(2, orderId);
      check = preparedStatement.executeUpdate() > 0;
    } catch (SQLException e) {
      // TODO: handle exception
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
        if (preparedStatement != null) {
          preparedStatement.close();
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
      }
    }
    return check;
  }

  @Override
  public List<Order> getCustomerOrdersByCus(int customerId) {
    List<Order> orders = new ArrayList<>();
    Order order = null;

    try {
      connection = DBUtils.getInstance().getConnection();
      preparedStatement = connection
          .prepareCall(Constant.ORDER_QUERY_FIND_BY_CUS_ID);
      preparedStatement.setInt(1, customerId);

      results = preparedStatement.executeQuery();
      while (results.next()) {
        order = new Order();
        order.setOrderID(results.getInt("order_id"));
        order.setOrderDate(dateFormat.parse(results.getString("order_date")));
        order.setCusID(results.getInt("customer_id"));
        order.setEmpID(results.getInt("employee_id"));
        order.setTotal(results.getInt("total"));

        orders.add(order);
      }

    } catch (SQLException | ParseException e) {
      // TODO: handle exception
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
        // TODO Auto-generated catch block
      }
    }
    return orders;
  }

  @Override
  public Order findById(int orderId) {
    Order order = null;

    try {
      connection = DBUtils.getInstance().getConnection();
      preparedStatement = connection
          .prepareCall(Constant.ORDER_QUERY_FIND_BY_ID);
      preparedStatement.setInt(1, orderId);
      results = preparedStatement.executeQuery();
      if (results.next()) {
        order = new Order();
        order.setOrderID(results.getInt("order_id"));
        order.setOrderDate(dateFormat.parse(results.getString("order_date")));
        order.setCusID(results.getInt("customer_id"));
        order.setEmpID(results.getInt("employee_id"));
        order.setTotal(results.getInt("total"));

      }

    } catch (SQLException | ParseException e) {
      // TODO: handle exception
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
        // TODO Auto-generated catch block
      }
    }
    return order;
  }

  @Override
  public Double computeOrderTotal(int orderId) {
    Double totalPrice = null;
    try {
      connection = DBUtils.getInstance().getConnection();
      preparedStatement = connection
          .prepareCall(Constant.ORDER_QUERY_COMPUTE_TOTAL);
      preparedStatement.setInt(1, orderId);
      results = preparedStatement.executeQuery();
      if (results.next()) {
        totalPrice = results.getDouble("total_price");
      }
    } catch (SQLException e) {
      // TODO: handle exception
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
        // TODO Auto-generated catch block
      }
    }
    return totalPrice;
  }

}
