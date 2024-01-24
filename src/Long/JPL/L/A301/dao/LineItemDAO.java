package JPL.L.A301.dao;

import JPL.L.A301.entities.LineItem;

import java.util.List;
import java.util.Map;

public interface LineItemDAO {

  /**
   * Adds a new line item to the data store.
   *
   * @param lineItem The line item to be added.
   * @return true if the line item was added successfully, false otherwise.
   */
  boolean addLineItem(LineItem lineItem);

  /**
   * Updates an existing line item in the data store.
   *
   * @param lineItem The line item to be updated.
   * @return true if the line item was updated successfully, false otherwise.
   */
  boolean updateLineItem(LineItem lineItem);

  /**
   * Deletes a line item from the data store based on its order ID and product ID.
   *
   * @param orderId    The ID of the order associated with the line item.
   * @param productId  The ID of the product associated with the line item.
   * @return true if the line item was deleted successfully, false otherwise.
   */
  boolean deleteLineItem(int orderId, int productId);

  /**
   * Retrieves a list of all line items from the data store.
   *
   * @return List of all line items.
   */
  List<LineItem> listAllLineItems();
  Map<Integer, LineItem> getAllItemsByOrderId(int orderId);

  /**
   * Finds a line item in the data store by its order ID and product ID.
   *
   * @param orderId   The ID of the order associated with the line item.
   * @param productId The ID of the product associated with the line item.
   * @return The found line item or null if not found.
   */
  LineItem findById(int orderId, int productId);
}
