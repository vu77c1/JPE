/**
 * @project SaleManagement
 */

package fa.training.dao;

import java.util.List;

import fa.training.entities.LineItem;

/**
 * author Duy Bach.
 * 
 * @time 9:55:27 AM
 * @date Jun 22, 2019
 */
public interface LineItemDAO {
  
  /**
   * @param item
   * @return
   */
  boolean addLineItem(LineItem item);

  /**
   * @param orderId
   * @return
   */
  List<LineItem> listLineItemsByOrder(int orderId);
}
