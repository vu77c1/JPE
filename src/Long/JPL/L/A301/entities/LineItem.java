package JPL.L.A301.entities;

public class LineItem {
    private int orderId;
    private int productId;
    private int quantity;
    private double price;

    // Default constructor
    public LineItem() {
    }

    // Constructor with parameters
    public LineItem(int orderId, int productId, int quantity, double price) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    // Getter and setter methods
    public int getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LineItem{");
        sb.append("orderId=").append(orderId);
        sb.append(", productId=").append(productId);
        sb.append(", quantity=").append(quantity);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
