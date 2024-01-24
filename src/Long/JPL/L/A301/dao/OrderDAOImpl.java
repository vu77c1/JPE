/**
 * @project SaleManagement
 */

package JPL.L.A301.dao;

import JPL.L.A301.common.Constant;
import JPL.L.A301.common.DbQuery;
import JPL.L.A301.entities.Customer;
import JPL.L.A301.entities.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDAOImpl implements OrderDAO {
    Map<Integer, Order> orders;

    public OrderDAOImpl() {
        orders=new HashMap<>();
    }


    @Override
    public boolean addOrder(Order order) {
        return false;
    }

    @Override
    public boolean updateOrder(Order order) {
        return false;
    }

    @Override
    public boolean deleteOrder(int orderId) {
        return false;
    }

    @Override
    public Map<Integer, Order> getAllOrdersByCustomerId(int customerId) {

        try {
            DbQuery.openConnection();

            // Use a parameterized query to avoid SQL injection
            String sql = Constant.ORDER_QUERY_FIND_BY_CUSTOMER_ID;
            ResultSet rs = DbQuery.executeSelectQuery(sql, customerId);

            if (rs != null) {
                try {
                    while (rs.next()) {
                        Order order = new Order(
                                rs.getInt("order_id"),
                                rs.getDate("order_date"),
                                rs.getInt("customer_id"),
                                rs.getInt("employee_id"),
                                rs.getDouble("total")
                        );
                        orders.put(rs.getInt("order_id"),order);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    rs.close();
                }
            }
        } catch (Exception exception) {
            // Handle or log the exception appropriately
            exception.printStackTrace();
        } finally {
            DbQuery.closeConnection();
        }

        return orders;

    }
    public void printListOrder(Map<Integer, Order> orderMap) {
        for (Order order : orderMap.values()) {
            System.out.println(order.toString());
        }
    }

    @Override
    public Order findById(int orderId) {
        return null;
    }
}
