/**
 * @project SaleManagement
 */

package JPL.L.A301.dao;

import JPL.L.A301.common.Constant;
import JPL.L.A301.common.DbQuery;
import JPL.L.A301.entities.LineItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineItemDAOImpl implements LineItemDAO {
    Map<Integer, LineItem> lineItemMap;

    public LineItemDAOImpl() {
        this.lineItemMap=new HashMap<>();

    }
    @Override
    public boolean addLineItem(LineItem lineItem) {
        return false;
    }

    @Override
    public boolean updateLineItem(LineItem lineItem) {
        return false;
    }

    @Override
    public boolean deleteLineItem(int orderId, int productId) {
        return false;
    }

    @Override
    public List<LineItem> listAllLineItems() {
        return null;
    }

    @Override

    public Map<Integer, LineItem> getAllItemsByOrderId(int orderId) {

        try {
            DbQuery.openConnection();

            // Use a parameterized query to avoid SQL injection
            String sql = Constant.LINEITEM_QUERY_FIND_BY_ORDER_ID;
            ResultSet rs = DbQuery.executeSelectQuery(sql, orderId);

            if (rs != null) {
                try {
                    while (rs.next()) {
                        LineItem lineItem = new LineItem(
                                rs.getInt("order_id"),
                                rs.getInt("product_id"),
                                rs.getInt("quantity"),
                                rs.getDouble("price")
                        );
                        lineItemMap.put(rs.getInt("product_id"), lineItem);
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

        return lineItemMap;
    }
    public void printLineItems(Map<Integer, LineItem> lineItemMap) {
        for (Map.Entry<Integer, LineItem> entry : lineItemMap.entrySet()) {
            System.out.println(entry.toString());
        }
    }

    @Override
    public LineItem findById(int orderId, int productId) {
        return null;
    }
}
