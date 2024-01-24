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
import fa.training.entities.Product;

/**
 * author Duy Bach.
 * @time 2:25:15 PM
 * @date Jun 22, 2019
 */
public class ProductDAOImpl implements ProductDAO{

  private Connection connection = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet results = null;
  
  @Override
  public Product findById(int productId) {
    Product product = null;
    try {
      connection = DBUtils.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(Constant.PRODUCT_QUERY_FIND_BY_ID);
      preparedStatement.setInt(1, productId);
       results = preparedStatement.executeQuery();
       if (results.next()) {
          product = new Product();
          product.setProID(results.getInt("product_id"));
          product.setProName(results.getString("product_name"));
          product.setLisPrice(results.getDouble("list_price"));
       }
    } catch (SQLException e) {
       // TODO Auto-generated catch block
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
    return product;
  }

}
