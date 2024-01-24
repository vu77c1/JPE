/**
 * @project SaleManagement
 */
package JPL.L.A301.dao;

import JPL.L.A301.entities.Customer;

import java.util.List;
import java.util.Map;

/**
 * author Duy Bach.
 * @time 9:54:16 AM
 * @date Jun 22, 2019
 */
public interface CustomerDAO {

  /**
   * @param customer
   * @return
   */
  boolean addCustomer(Customer customer);

  /**
   * @param customer
   * @return
   */
  boolean updateCustomer(Customer customer);

  /**
   * @param idCus
   * @return
   */
  boolean deleteCustomer(int idCus);

  /**
   * @return
   */
  Map<Integer,Customer> getAllCustomer();

  /**
   * @param id
   * @return
   */
  Customer findById(int id);
  Map<Integer,Customer> getListCustomer();
  
}
