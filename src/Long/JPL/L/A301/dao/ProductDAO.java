/**
 * @project SaleManagement
 */
package fa.training.dao;

import fa.training.entities.Product;

/**
 * author Duy Bach.
 * @time 9:56:03 AM
 * @date Jun 22, 2019
 */
public interface ProductDAO {

  Product findById(int productId) ;
}
