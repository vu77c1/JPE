package JPL.L.A301.main;

import JPL.L.A201.InputValidator;
import JPL.L.A301.dao.CustomerDAO;
import JPL.L.A301.dao.CustomerDAOImpl;
import JPL.L.A301.dao.LineItemDAOImpl;
import JPL.L.A301.dao.OrderDAOImpl;
import JPL.L.A301.entities.Customer;

import java.util.HashMap;
import java.util.Map;

public class SaleManagement {
    public static void main(String[] args) {
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        LineItemDAOImpl lineItemDAO = new LineItemDAOImpl();


        int choice;
        boolean exitMenu = false;
        do {
            do {
                System.out.println("0. Exit ");
                System.out.println("1. List all customers  ");
                System.out.println("2. Get All Orders By CustomerId ");
                System.out.println("3. Get All LineItems By OrderId  ");
                System.out.println("4. Sarch employee by department name   ");
                System.out.println("5. Insert Customer ");
                System.out.println("6. Delete a customer from the database   ");

                choice = InputValidator.validateIntInput("Enter 0-6: ");
                if (choice >= 0 && choice <= 9) {
                    break; // Exit the loop if the input is 1 or 2
                } else {
                    System.out.println("Invalid choice. Please enter again.");
                }
            } while (true);

            switch (choice) {
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    exitMenu = true;
                    break;

                case 1:
                    customerDAO.printListCustomer(customerDAO.getAllCustomer());
                    break;
                case 2:
                    int CustomerId = InputValidator.validateIntInput("Enter CustomerId:");
                    orderDAO.printListOrder(orderDAO.getAllOrdersByCustomerId(CustomerId));


                    break;
                case 3:
                    int OrderId = InputValidator.validateIntInput("Enter OrderId:");
                    lineItemDAO.printLineItems(lineItemDAO.getAllItemsByOrderId(OrderId));

                    break;
                case 4:


                    break;
                case 5:

                    int customerId ;
                    Map<Integer, Customer> customerMap = customerDAO.getListCustomer();
                    do {
                        customerId=  InputValidator.validateIntInput("Enter customerID: ");
                        if (customerMap.containsKey(customerId)) {
                            System.out.println("Cannot insert duplicate key: ");
                        }
                    }
                    while (customerMap.containsKey(customerId));
                    String customerName = InputValidator.validateStringInput("Enter customerName: ");
                    Customer customer = new Customer(customerId, customerName);
                    boolean flag = customerDAO.addCustomer(customer);
                    if (flag) {
                        System.out.println("Insert success");
                    } else {
                        System.out.println("Insert Error");
                    }

                    break;
                case 6:
                    if (customerDAO.deleteCustomer(InputValidator.validateIntInput("Enter customerID: "))) {
                        System.out.println("Delete success");
                    } else {
                        System.out.println("Delete Error");
                    }

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:


                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        }
        while (!exitMenu);

    }
}
