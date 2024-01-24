package JPL.L.A301.dao;

import JPL.L.A301.entities.Product;

import java.util.List;

public interface ProductDAO {

  /**
   * Adds a new product to the data store.
   *
   * @param product The product to be added.
   * @return true if the product was added successfully, false otherwise.
   */
  boolean addProduct(Product product);

  /**
   * Updates an existing product in the data store.
   *
   * @param product The product to be updated.
   * @return true if the product was updated successfully, false otherwise.
   */
  boolean updateProduct(Product product);

  /**
   * Deletes a product from the data store based on its ID.
   *
   * @param productId The ID of the product to be deleted.
   * @return true if the product was deleted successfully, false otherwise.
   */
  boolean deleteProduct(int productId);

  /**
   * Retrieves a list of all products from the data store.
   *
   * @return List of all products.
   */
  List<Product> listAllProducts();

  /**
   * Finds a product in the data store by its ID.
   *
   * @param productId The ID of the product to find.
   * @return The found product or null if not found.
   */
  Product findById(int productId);
}
