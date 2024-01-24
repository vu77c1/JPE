package JPL.L.A301.entities;

public class Product {
    private int productId;
    private String productName;
    private double listPrice;

    // Default constructor
    public Product() {
    }

    // Constructor with parameters
    public Product(int productId, String productName, double listPrice) {
        this.productId = productId;
        this.productName = productName;
        this.listPrice = listPrice;
    }

    // Getter and setter methods
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }
}
