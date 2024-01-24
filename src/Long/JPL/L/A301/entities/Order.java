package JPL.L.A301.entities;

import java.util.Date;

public class Order {
    private int orderId;
    private Date orderDate;
    private int customerId;
    private int employeeId;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("orderId=").append(orderId);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", customerId=").append(customerId);
        sb.append(", employeeId=").append(employeeId);
        sb.append(", total=").append(total);
        sb.append('}');
        return sb.toString();
    }

    private double total;

    // Default constructor
    public Order() {
    }

    // Constructor with parameters
    public Order(int orderId, Date orderDate, int customerId, int employeeId, double total) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.total = total;
    }

    // Getter and setter methods
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
