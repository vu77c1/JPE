package JPL.L.A301.entities;

public class Customer {
    private int customerId;
    private String customerName;

    // Default constructor
    public Customer() {
    }

    // Constructor with parameters
    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    // Getter and setter methods
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("customerId=").append(customerId);
        sb.append(", customerName='").append(customerName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
