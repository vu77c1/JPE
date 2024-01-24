/**
 * @project SaleManagement
 */
package fa.training.dao;

import java.util.List;

import fa.training.entities.Customer;

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
  List<Customer> listAllCustomers();

  /**
   * @param id
   * @return
   */
  Customer findById(int id);
  
}
