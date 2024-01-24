/**
 * @project SaleManagement
 */
package fa.training.dao;

import java.util.List;

import fa.training.entities.Order;

/**
 * author Duy Bach.
 * @time 9:56:31 AM
 * @date Jun 22, 2019
 */
public interface OrderDAO {

  /**
   * @param order
   * @return
   */
  boolean addOrder(Order order) ;
  
  /**
   * @param order
   * @return
   */
  boolean updateOrderTotal(int orderId) ;
  
  /**
   * @return
   */
  List<Order> getCustomerOrdersByCus(int customerId) ;
  
  /**
   * @param orderId
   * @return
   */
  Order findById(int orderId) ;
  
  /**
   * @method computeOrderTotal 
   * @param orderId
   * @return
   */
  Double computeOrderTotal(int orderId);
}
