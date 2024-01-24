/**
 * @project SaleManagement
 */

package JPL.L.A301.dao;

import JPL.L.A301.common.Constant;
import JPL.L.A301.common.DbQuery;
import JPL.L.A301.entities.Customer;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author Duy Bach.
 *
 * @time 2:24:39 PM
 * @date Jun 22, 2019
 */
public class CustomerDAOImpl implements CustomerDAO {
    private Map<Integer, Customer> customerMap;

    public CustomerDAOImpl() {
        this.customerMap = new HashMap<>();
    }

    @Override
    public boolean addCustomer(Customer customer) {
        boolean success = false;

        try {
            DbQuery.openConnection();

            // Use a callable statement to call the stored procedure
            String sql = "{ call usp_addCustomer(?, ?) }";
            try (CallableStatement cs = DbQuery.getConnection().prepareCall(sql)) {
                cs.setString(1, customer.getCustomerName());
                cs.setInt(2, customer.getCustomerId());
                cs.execute();
                success = true;
            }

        } catch (Exception exception) {
            // Handle or log the exception appropriately
            exception.printStackTrace();
        } finally {
            DbQuery.closeConnection();
        }

        return success;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean deleteCustomer(int idCus) {
        boolean success = false;

        try {
            DbQuery.openConnection();

            // Use a callable statement to call the stored procedure
            String sql =Constant.CUSTOMER_QUERY_DELETE;
            try (CallableStatement cs = DbQuery.getConnection().prepareCall(sql)) {
                cs.setInt(1, idCus);
                cs.registerOutParameter(2,Types.BIT);
                cs.execute();
                success = cs.getBoolean(2);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            DbQuery.closeConnection();
        }

        return success;
    }

    @Override
    public Map<Integer, Customer> getAllCustomer() {
        try {
            DbQuery.openConnection();
            String sql = Constant.CUSTOMER_QUERY_FIND_ALL;
            ResultSet rs = DbQuery.executeSelectQuery(sql);
            if (rs != null) {
                try {
                    while (rs.next()) {
                        customerMap.put(rs.getInt("customer_id"), new Customer(
                                rs.getInt("customer_id"),
                                rs.getString("customer_name")
                        ));
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        } catch (Exception exception) {

        } finally {
         DbQuery.closeConnection();


        }
        return customerMap;

    }
    public void printListCustomer(Map<Integer, Customer> customerMap) {
        for (Customer customer : customerMap.values()) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public Map<Integer, Customer> getListCustomer() {
        try {
            DbQuery.openConnection();
            String sql = Constant.CUSTOMER_QUERY_SELECT;
            ResultSet rs = DbQuery.executeSelectQuery(sql);
            if (rs != null) {
                try {
                    while (rs.next()) {
                        customerMap.put(rs.getInt("customer_id"), new Customer(
                                rs.getInt("customer_id"),
                                rs.getString("customer_name")
                        ));
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        } catch (Exception exception) {

        } finally {
            DbQuery.closeConnection();


        }
        return customerMap;
    }
}
