package JPL.L.A301.common;

public class Constant {
    public static String CUSTOMER_QUERY_ADD = "{call usp_addCustomer(?, ?, ?)}",
            CUSTOMER_QUERY_UPDATE = "{CALL usp_updateCustomer(?, ?, ?)}",
            CUSTOMER_QUERY_DELETE = "{ call usp_deleteCustomerWithOrders(?, ?) }",
            CUSTOMER_QUERY_SELECT = "SELECT * FROM Customer",
            CUSTOMER_QUERY_FIND_BY_ID = "SELECT * FROM Customer WHERE customer_id = ?",
            CUSTOMER_QUERY_FIND_ALL = "SELECT * FROM Customer WHERE customer_id in (SELECT customer_id FROM Orders GROUP BY customer_id)";
    public static String ORDER_QUERY_FIND_BY_CUSTOMER_ID = "SELECT * FROM Orders WHERE customer_id = ?";
    public static String LINEITEM_QUERY_FIND_BY_ORDER_ID = "SELECT * FROM LineItem WHERE order_id = ?";



}
