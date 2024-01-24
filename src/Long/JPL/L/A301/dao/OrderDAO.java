package JPL.L.A301.dao;

import JPL.L.A301.entities.Order;

import java.util.List;
import java.util.Map;

public interface OrderDAO {

  /**
   * Adds a new order to the data store.
   *
   * @param order The order to be added.
   * @return true if the order was added successfully, false otherwise.
   */
  boolean addOrder(Order order);

  /**
   * Updates an existing order in the data store.
   *
   * @param order The order to be updated.
   * @return true if the order was updated successfully, false otherwise.
   */
  boolean updateOrder(Order order);

  /**
   * Deletes an order from the data store based on its ID.
   *
   * @param orderId The ID of the order to be deleted.
   * @return true if the order was deleted successfully, false otherwise.
   */
  boolean deleteOrder(int orderId);

  /**
   * Retrieves a list of all orders from the data store.
   *
   * @return List of all orders.
   */
  Map<Integer,Order> getAllOrdersByCustomerId(int customerId);

  /**
   * Finds an order in the data store by its ID.
   *
   * @param orderId The ID of the order to find.
   * @return The found order or null if not found.
   */
  Order findById(int orderId);
}
