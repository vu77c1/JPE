import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order implements Serializable {
    private static final long serialVersionUID = -2898805247528282747L;

    private String number;
    private Date date;

    public Order() {
        // Default constructor
    }

    public Order(String number, Date date) {
        this.number = number;
        this.date = date;
    }

    // Getter and setter methods for Order class
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return "Order {OrderNumber: " + number + ", Date: " + dateFormat.format(date) + "}";
    }
}
