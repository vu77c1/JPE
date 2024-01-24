import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Customer implements Serializable {
    private static final long serialVersionUID = 4271551018602578192L;

    private String name;
    private String phoneNumber;
    private String address;
    private List<Order> orders;

    public Customer() {
        // Default constructor
        this.orders = new ArrayList<>();
    }

    public Customer(String name, String phoneNumber, String address, List<Order> orders) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orders = orders;
    }


    // Getter and setter methods for Customer class
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Customer> createCustomer() {
        List<Customer> customers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        char continueInput;
        do {
            System.out.println("Enter customer details:");
            setName(Validator.validateStringInput("Enter Name: "));
            setPhoneNumber(PersonManageValidator.validatePhoneNumber("Enter Phone Number: "));
            setAddress(Validator.validateStringInput("Address: "));
            List<Order> orders = new ArrayList<>();
            char continueOrderInput;

            do {
                System.out.println("Enter order details:");
                String orderNumber = CustomerValidate.validateOrderNumberInput("Order Number: ");
                Order order = new Order(orderNumber, new Date());
                orders.add(order);
                System.out.print("Do you want to add another order? (y/n): ");
                continueOrderInput = scanner.nextLine().charAt(0);
            } while (continueOrderInput == 'y' || continueOrderInput == 'Y');

            Customer customer = new Customer(name, phoneNumber, address, orders);
            customers.add(customer);
            System.out.print("Do you want to add another customer? (y/n): ");
            continueInput = scanner.nextLine().charAt(0);
        } while (continueInput == 'y' || continueInput == 'Y');

        return customers;
    }

    public static String save(List<Customer> newCustomers, boolean append) {
        String fileName = "/Users/tuanvu/Downloads/JPE/src/Java.M.A501/customer.dat";

        List<Customer> existingCustomers = readFromFile(fileName);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            if (append) {
                existingCustomers.addAll(newCustomers);
            } else {
                existingCustomers = newCustomers;
            }
            oos.writeObject(existingCustomers);
            return "Customer data saved to " + fileName;
        } catch (IOException e) {
//            e.printStackTrace();
            return "Error saving customer data to " + fileName;
        }
    }


    public static List<Customer> readFromFile(String fileName) {
        List<Customer> customers = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            customers = (List<Customer>) ois.readObject();
            System.out.println("Customer data loaded from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error loading customer data from " + fileName);
        }

        return customers;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Customer {")
                .append("Name: ").append(name).append(", ")
                .append("Phone Number: ").append(phoneNumber).append(", ")
                .append("Address: ").append(address).append(", ")
                .append("Orders: ").append(orders)
                .append("}");
        return sb.toString();
    }

    public void display(List<Customer> customers) {
        System.out.printf("%-20s%-20s%-15s%-15s%n", "Customer Name", "Address", "Phone Number", "Order List");
        for (Customer customer : customers) {
            System.out.printf("%-20s%-20s%-15s%-15s%n",
                    customer.getName(), customer.getAddress(), customer.getPhoneNumber(), customer.getOrderListAsString());
        }
    }

    public String getOrderListAsString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder orderListAsString = new StringBuilder();
        List<Order> orders = getOrders();
        for (Order order : orders) {
            orderListAsString.append("Order Number: ").append(order.getNumber()).append(", ");
            orderListAsString.append("Order Date: ").append(dateFormat.format(order.getDate())).append("; ");
        }
        return orderListAsString.toString();
    }

    public static List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        String fileName = "/Users/tuanvu/Downloads/JPE/src/Java.M.A501/customer.dat";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            customers = (List<Customer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error loading customer data from " + fileName);
        }

        return customers;
    }

    public static List<Customer> search(String phone) {
        List<Customer> matchingCustomers = new ArrayList<>();

        for (Customer customer : findAll()) {
            if (customer.getPhoneNumber().equals(phone)) {
                matchingCustomers.add(customer);
            }
        }

        return matchingCustomers;
    }

    public static boolean remove(String phone) {
        List<Customer> allCustomers = findAll();
        boolean customerRemoved = false;

        // Find and remove the customer with the specified phone number
        for (Customer customer : allCustomers) {
            if (customer.getPhoneNumber().equals(phone)) {
                allCustomers.remove(customer);
                customerRemoved = true;
                break; // Assuming there is only one customer with a given phone number
            }
        }

        // Save the updated list back to the file
        save(allCustomers, false);

        return customerRemoved;
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        int choice;

        do {
            System.out.println("Customer Management Menu:");
            System.out.println("1. Add a new Customer ");
            System.out.println("2. Show all Customer");
            System.out.println("3. Search Customer");
            System.out.println("4. Remove Customer");
            System.out.println("5. Exit");

            choice = InputValidate.validateIntInput("Enter your choice (1-5):");

            switch (choice) {
                case 1:
                    save(customer.createCustomer(), true);
                    System.out.println("Customer added successfully!");
                    break;
                case 2:
                    customer.display(findAll());
                    break;
                case 3:
                    String phone = PersonManageValidator.validatePhoneNumber(" Search by Phone: Enter Phone: ");
                    customer.display((search(phone)));
                    break;
                case 4:
                    String phone_rm = PersonManageValidator.validatePhoneNumber(" Remove by Phone: Enter Phone: ");
                    remove(phone_rm);
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }

        } while (choice != 5);

    }
}
