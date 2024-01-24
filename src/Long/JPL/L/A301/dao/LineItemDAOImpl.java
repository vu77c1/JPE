/**
 * @project SaleManagement
 */

package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.common.Constant;
import fa.training.common.DBUtils;
import fa.training.entities.LineItem;

/**
 * author Duy Bach.
 * 
 * @time 2:25:27 PM
 * @date Jun 22, 2019
 */
public class LineItemDAOImpl implements LineItemDAO {

  private Connection connection = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet results = null;

  @Override
  public boolean addLineItem(LineItem item) {
    boolean check = false;
    try {

      connection = DBUtils.getInstance().getConnection();
      preparedStatement = connection
          .prepareStatement(Constant.LINEITEM_QUERY_ADD);
      preparedStatement.setInt(1, item.getOrderID());
      preparedStatement.setInt(2, item.getProID());
      preparedStatement.setInt(3, item.getQuatity());
      preparedStatement.setDouble(4, item.getPrice());

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
  public List<LineItem> listLineItemsByOrder(int orderId) {
    LineItem lineItem = null;
    List<LineItem> items = new ArrayList<>();

    try {
      connection = DBUtils.getInstance().getConnection();
      preparedStatement = connection
          .prepareStatement(Constant.LINEITEM_QUERY_FIND_BY_ORDER_ID);
      preparedStatement.setInt(1, orderId);
      results = preparedStatement.executeQuery();
      while (results.next()) {
        lineItem = new LineItem();
        lineItem.setOrderID(results.getInt("order_id"));
        lineItem.setProID(results.getInt("product_id"));
        lineItem.setQuatity(results.getInt("quantity"));
        lineItem.setPrice(results.getDouble("price"));
        items.add(lineItem);
      }
      return items;
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
      }
    }
    return items;
  }

}
